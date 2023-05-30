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
        AnalysisResult result = medicalExamination(P);
        if (result != null) {
            // Hastalık var, teşhis koy ve reçete yaz
            setDiagnosis(P, result);
            writePrescription(P);
            Disease[] diseases = P.getDiseases();
            boolean puttingUpFlag = false;
            for (int i = 0; i < diseases.length; i++)
            {
                if (diseases[i]!=null && diseases[i].isImportant())
                {
                    puttingThePatient(P);
                    puttingUpFlag = true;
                    break;
                }
            }
            if(!puttingUpFlag)
                discharge(P);
        } else {
            // Hastalık yok, taburcu et
            discharge(P);
        }
    }

    public AnalysisResult medicalExamination(Patient P) {
        LinkedList<Double> results = getResults(P);
        AnalysisResult result = new AnalysisResult(P);
        int counter = 0;
        while (!results.isEmpty())
        {
            double patientData = results.pop();
            switch (counter)
            {
                case 0:
                    if (patientData>h1n1_parameter)
                        result.setH1n1(true);
                    break;
                case 1:
                    if (patientData>rhinovirus_parameter)
                        result.setRhinovirus(true);
                    break;
                case 2:
                    if(patientData>sars_cov_parameter)
                        result.setSarscov2(true);
                    break;
                case 3:
                    if(patientData > insulin_parameter)
                        result.setInsuline(true);
                    break;
                case 4:
                    if (patientData> pressure_parameter)
                        result.setBloodpres(true);
                    break;
                case 5:
                    if(patientData > ecoli_parameter)
                        result.setEscColi(true);
                    break;
                case 6:
                    if(patientData > tetani_parameter)
                        result.setClostTetani(true);
                    break;
                case 7:
                    if(patientData > hiv_parameter)
                        result.setHiv(true);
                    break;
            }
            counter ++;
        }
        return result;
    }

    public LinkedList<Double> getResults(Patient P) {
        // Belirli bir hastanın sonuçlarını döndür
        LinkedList<Double> results = P.GetDatas();
        return results;
    }

    public void setDiagnosis(Patient P, AnalysisResult result)
    {
        int count = 0;
        if(result.isH1n1())
        {
            Disease d = new Disease("Flu");
            count = P.AddDiseaseToArray(d,count);
        }
        if(result.isRhinovirus())
        {
            Disease d = new Disease("Cold");
            count = P.AddDiseaseToArray(d,count);
        }
        if (result.isBloodpres()){
            Disease d = new Disease("High Blood Pressure");
            count = P.AddDiseaseToArray(d,count);
        }
        if(result.isHiv()){
            Disease d = new Disease("AIDS");
            count = P.AddDiseaseToArray(d,count);
        }
        if(result.isInsuline()){
            Disease d = new Disease("Diabetes");
            count = P.AddDiseaseToArray(d,count);
        }
        if(result.isClostTetani())
        {
            Disease d = new Disease("Tetanus");
            count = P.AddDiseaseToArray(d,count);
        }
        if(result.isEscColi()){
            Disease d = new Disease("Diarrhea");
            count = P.AddDiseaseToArray(d,count);
        }
        if(result.isSarscov2())
        {
            Disease d = new Disease("Coronavirus");
            count = P.AddDiseaseToArray(d,count);
        }
    }

    public void writePrescription(Patient P) {
        // Belirli bir hastaya reçete yaz
        MedicalPrescription prescription = new MedicalPrescription(P.getDiseases());
        P.setMedPrescription(prescription);
        // ... (Reçete yazma işlemi)
    }

    public void puttingThePatient(Patient P) {
        // Hasta ciddi bir hastalığa sahipse hastayı gözetim için al
        // ... (Gözetim işlemi)
    }

    public void discharge(Patient P) {
        P.setTreated(true);
        // ... (Taburcu işlemi)
    }
}


