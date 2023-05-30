package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class System
{
    private static System instance = new System(10,30); //For singleton pattern
    //Arraylist variables.
    private ArrayList<String> nameList;
    private ArrayList<String> surnameList;
    public ArrayList<Doctor> doctorList;
    public  ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;
    public Disease[] diseases;
    public Medicine[] medicines;

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    int hourRepeatCount; //When it reaches 3, 1 hour passes.
    int shiftHour;


    private System(int doctorAmount, int PatientAmount)
    {
        nameList = new ArrayList<String>();
        surnameList = new ArrayList<String>();
        doctorList = new ArrayList<Doctor>();
        patients = new ArrayList<Patient>();
        appointments =new ArrayList<Appointment>();
        try
        {
            TakeNamesSurnamesFromFile();
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
       doctorList =  CreateDoctors(doctorAmount); //Create doctors.
        patients = CreatePatients(PatientAmount); //Create Patients.
        shiftHour = 10; // Resets hour
        hourRepeatCount = 0; // Resets hour count.
        CreateAppointments();
    }

    public static System getInstance() {
        return instance;
    }

    private ArrayList<Doctor> CreateDoctors(int amount)
    {
        ArrayList<Doctor> tempList = new ArrayList<Doctor>();
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
            //Randomizes the variables.
           int rand_name = r.nextInt(nameList.size());
           int rand_surname = r.nextInt(surnameList.size());
           int rand_height = r.nextInt(150,195);
           int rand_weight = r.nextInt(62,100);
           int rand_gender = r.nextInt(1);
           String gender;
           if (rand_gender == 0)
               gender = "M";
           else
               gender = "F";
           int exp = r.nextInt(1,15);
           int phoneNum = r.nextInt(1000000, 10000000);
           Phone p = new Phone("+90",phoneNum);
           //Creates a new doctor object.
           Doctor tempDoc = new Doctor(nameList.get(rand_name),surnameList.get(rand_surname),rand_height,rand_weight,
                   31,gender,"AB",123,p,"ER");
           //Adds it to list.
           tempList.add(tempDoc);
        }

        return  tempList;
    }

    public ArrayList<Patient> CreatePatients(int amount)
    {
        ArrayList<Patient> tempList = new ArrayList<Patient>();
        tempList.clear(); //Clears the list because we use this list multiple times.
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
            //Randomizes variables.
            int rand_name = r.nextInt(nameList.size());
            int rand_surname = r.nextInt(surnameList.size());
            int rand_height = r.nextInt(150,195);
            int rand_weight = r.nextInt(62,100);
            int rand_gender = r.nextInt(3);
            String gender;
            if (rand_gender == 0)
                gender = "M";
            else
                gender = "F";
            int age = r.nextInt(15,99);
            String bloodType = GenerateBloodType();
            int id = r.nextInt(1234567,9999999);
            int phoneNum = r.nextInt(1000000,10000000);
            Phone p = new Phone("+90",phoneNum);
            //Creates patient object.
            Patient tempPatient = new Patient(nameList.get(rand_name),surnameList.get(rand_surname),rand_height,rand_weight
                    ,age,gender,bloodType,id,p);
            //Adds it to list.
            tempList.add(tempPatient);
        }
        return  tempList;
    }

    public void CreateAppointments()
    {
        appointments.clear();
        for (int i = 0; i < doctorList.size(); i++)
        {
            //Clears patient queue of the doctor.
            doctorList.get(i).getPatientQueue().clear();
        }
        for (int i = 0; i < patients.size(); i++) {
            CreateAppointment(patients.get(i));
        }
    }
    private void CreateAppointment(Patient P)
    {
        Random r = new Random();
        //Select a doctor.
        Doctor selectedDoc = doctorList.get(r.nextInt(doctorList.size()));
        int doctorSelectionCount = 0;
        while (selectedDoc.getPatientQueue().size()>4) //If doctor has 4 patients for that timeline.
        {
            selectedDoc = doctorList.get(doctorSelectionCount); //Get a new doctor(Starting from the beginning.)
            doctorSelectionCount ++;
        }
        String digitalClock = ""+shiftHour +":"+(20*hourRepeatCount);
        //Create appointment object.
        Appointment tempAppointment = P.setAppointment(digitalClock,selectedDoc);
        //Add to list.
        appointments.add(tempAppointment);
    }

    public void EndWorkingHour() //Completes the
    {
        while(hourRepeatCount<2)
        {
            EndWorkingShift(); //Call working shift function.
        }
        shiftHour ++;
        hourRepeatCount = 0; //Clear repeat.
        patients = CreatePatients(30);
        CreateAppointments();
    }

    public void EndWorkingShift()
    {
        for (int i = 0; i < doctorList.size(); i++) {
            Doctor tempDoc = doctorList.get(i);
            LinkedList<Patient> patientQueue = (LinkedList<Patient>) tempDoc.getPatientQueue();
            while (!patientQueue.isEmpty())
            {
                //Start appointment from queue.
                tempDoc.StartAppointment(patientQueue.pop());
            }
        }
        hourRepeatCount ++; //Increase repeat.
        if(hourRepeatCount>2) //If it reaches 3, it means that the hour is completed.
        {
            shiftHour ++; //Increase shift hour.
            hourRepeatCount = 0; //Reset repeat count.
        }
        //patients = CreatePatients(30); //Create new 30 patients.
        CreateAppointments();
    }

    private void TakeNamesSurnamesFromFile() throws FileNotFoundException {
        File f = new File("names.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()) {
            String[] names = sc.nextLine().split(" ");
            for (int i = 0; i < names.length; i++)
            {
                nameList.add(names[i]);
            }
        }
        sc.close();
        File surnameFile = new File("surnames.txt");
        sc = new Scanner(surnameFile);
        while(sc.hasNextLine()) {
            String[] surnames = sc.nextLine().split(" ");
            for (int i = 0; i < surnames.length; i++)
            {
                surnameList.add(surnames[i]);
            }
        }
        sc.close();
    }

    public String GenerateBloodType()
    {
        String[] bloodTypes = {"A-","A+","B-","B+","0-","0+","AB-","AB+"};
        Random r = new Random();
        int index = r.nextInt(bloodTypes.length);
        return bloodTypes[index];
    }
}
