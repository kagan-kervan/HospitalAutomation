package src;

import java.util.LinkedList;
import java.util.Queue;

class Doctor extends Person {
    private String profession;
    private LinkedList<Patient> patientQueue;
    public double h1n1_parameter = 16.2;
    public double rhinovirus_parameter = 18.7;
    public double sars_cov_parameter = 21.8;
    public double insulin_parameter = 140;
    public double pressure_parameter = 140;
    public double ecoli_parameter = 25.9;
    public double tetani_parameter = 62.0;
    public double hiv_parameter = 72.2;

    public LinkedList<Patient> getPatientQueue() {
        return patientQueue;
    }

    public Doctor(String name, String surname, float height, float weight, int age, String gender, String bloodType, int id,Phone phone, String Proffesion)
    {
        super(name, surname, height, weight, age, gender, bloodType, id,phone);
        profession = Proffesion;
        patientQueue = new LinkedList<Patient>();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void StartAppointment(Patient P) {
        String result = medicalExamination(P);
        if (result != null) {
            // Hastalık var, teşhis koy ve reçete yaz
            Disease disease = new Disease(result);
            setDiagnosis(P, disease);
            writePrescription(disease,P);
            if (disease.isImportant())
            {
                puttingThePatient(P);
            }
            else {
                discharge(P);
            }
        } else {
            // Hastalık yok, taburcu et
            discharge(P);
        }
    }

    public String medicalExamination(Patient P) {
        LinkedList<Double> results = getResults(P);
        int counter = 0;
        while (!results.isEmpty())
        {
            double patientData = results.pop();
            switch (counter)
            {
                case 0:
                    if (patientData>h1n1_parameter)
                        return "Flu";
                case 1:
                    if (patientData>rhinovirus_parameter)
                        return "Cold";
                case 2:
                    if(patientData>sars_cov_parameter)
                        return "Coronavirus";
                case 3:
                    if(patientData > insulin_parameter)
                        return "Diabetes";
                case 4:
                    if (patientData> pressure_parameter)
                        return "High Blood Pressure";
                case 5:
                    if(patientData > ecoli_parameter)
                        return "Diarrhea";
                case 6:
                    if(patientData > tetani_parameter)
                        return "Tetanus";
                case 7:
                    if(patientData > hiv_parameter)
                        return "AIDS";
            }
            counter ++;
        }
        return null;
    }

    public LinkedList<Double> getResults(Patient P) {
        // Belirli bir hastanın sonuçlarını döndür
        LinkedList<Double> results = P.GetDatas();
        return results;
    }

    public void setDiagnosis(Patient P, Disease disease) {
        P.setDisease(disease);
    }

    public void writePrescription(Disease disease, Patient P) {
        // Belirli bir hastaya reçete yaz
        MedicalPrescription prescription = new MedicalPrescription(disease);
        P.setMedPrescription(prescription);
        // ... (Reçete yazma işlemi)
    }

    public void puttingThePatient(Patient P) {
        // Hasta ciddi bir hastalığa sahipse hastayı gözetim için al
        // ... (Gözetim işlemi)
    }

    public void discharge(Patient P) {
        // Hasta taburcu edildi
        // ... (Taburcu işlemi)
    }
}





// ... (Diğer reçete bilgileri ve metotları)

