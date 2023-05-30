package src;

import java.util.LinkedList;

public class MedicalPrescription {
    private Disease[] disease;
    public LinkedList<Medicine> medicines;

    public MedicalPrescription(Disease[] disease) {
        this.disease = disease;
        medicines = new LinkedList<Medicine>();
        SetMedicines(disease);

    }

    public void SetMedicines(Disease[] d)
    {
        for (int i = 0; i < d.length; i++)
        {
            if(d[i] == null)
                return;
            String diseaseName = d[i].getName();
            Medicine newMed;
            switch (diseaseName)
            {
                case "Flu":
                    newMed = new Medicine("Acetaminophen",20,2,500);
                    medicines.add(newMed);
                    break;
                case "Cold":
                    newMed = new Medicine("Ibuprofen",10,1,800);
                    medicines.add(newMed);
                    break;
                case "Coronavirus":
                    newMed = new Medicine("Coraspin",30,2,400);
                    medicines.add(newMed);
                    break;
                case "Diabetes":
                    newMed = new Medicine("Insulin Sting",40,1,500);
                    medicines.add(newMed);
                    break;
                case "High Blood Pressure":
                    newMed = new Medicine("ACE",40,1,1000);
                    medicines.add(newMed);
                    break;
                case "Diarrhea":
                    newMed = new Medicine("Loperamide",40,2,500);
                    medicines.add(newMed);
                    break;
                case "Tetanus":
                    newMed = new Medicine("Penicilin",12,1,2000);
                    medicines.add(newMed);
                    break;
                case "AIDS":
                    newMed = new Medicine("Triumeq",30,2,700);
                    medicines.add(newMed);
                    break;
                default:
                    return;
            }
        }
    }
}