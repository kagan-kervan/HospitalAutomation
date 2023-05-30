package src;

import java.util.LinkedList;
import java.util.Random;

public class Patient extends Person {
    public Patient(String name, String surname, float height, float weight, int age, String gender, String bloodType,
                   int id,Phone p) {
        super(name, surname, height, weight, age, gender, bloodType, id,p);
        Random r = new Random();
        diseases = new Disease[8];
        h1n1 = r.nextDouble(13,19);
        rhinovirus = r.nextDouble(15,21);
        sars_cov2 = r.nextDouble(18,24);
        insulin = r.nextDouble(120,150);
        bloodPressure = r.nextDouble(120,160);
        e_coli = r.nextDouble(23,28);
        c_tetani = r.nextDouble(50,68);
        hiv = r.nextDouble(66,75);
        // TODO Auto-generated constructor stub
    }

    private Appointment appointment;
    private Disease[] diseases;
    private MedicalPrescription medPrescription;
    private boolean isTreated;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setTreated(boolean treated) {
        isTreated = treated;
    }

    public Disease[] getDiseases() {
        return diseases;
    }

    public MedicalPrescription getMedPrescription() {
        return medPrescription;
    }

    public void setMedPrescription(MedicalPrescription medPrescription) {
        this.medPrescription = medPrescription;
    }

    private double h1n1;
    private double rhinovirus;
    private double sars_cov2;
    private double insulin;
    private double bloodPressure;
    private double e_coli;
    private double c_tetani;
    private double hiv;

    public Appointment setAppointment(String digitalHour, Doctor doctor)
    {
        String[] hourParameters = digitalHour.split(":");
        appointment = new Appointment(doctor,this,Integer.parseInt(hourParameters[0]),Integer.parseInt(hourParameters[1]));
        doctor.getPatientQueue().add(this);
        return appointment;
    }

    public String getAnalysisResults() {
        // Implement your code to print the important variables for diseases to the screen
        return "Analysis Results:\n Disease: "/*+diseases.getName()*/;
        // Print other relevant disease variables
    }

    public int AddDiseaseToArray(Disease d, int count )
    {
        diseases[count] = d;
        count ++;
        return count;
    }

    public LinkedList<Double> GetDatas()
    {
        LinkedList<Double> temp = new LinkedList<Double>();
        temp.add(h1n1);
        temp.add(rhinovirus);
        temp.add(sars_cov2);
        temp.add(insulin);
        temp.add(bloodPressure);
        temp.add(e_coli);
        temp.add(c_tetani);
        temp.add(hiv);
        return  temp;
    }

    /*public void getMedicine() {
        // Assuming Prescription object is available in the patient's object
        if (medPrescription != null) {
            String medicine = medPrescription.getMedicine();
            //System.out.println("Prescribed Medicine: " + medicine);
        } else {
           // System.out.println("No prescription available.");
        }
    }*/
}

