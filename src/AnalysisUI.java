package src;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class AnalysisUI
{
    private JPanel analysisPanel;

    public AnalysisUI(Patient P)
    {
        analysisPanel.setLayout(new BoxLayout(analysisPanel,BoxLayout.PAGE_AXIS));
        CreateStrLabels(P,analysisPanel);
        JFrame f = new JFrame();
        f.add(analysisPanel);
        f.setSize(1200,400);
        f.setVisible(true);
    }

    private void CreateStrLabels(Patient patient,JPanel panel)
    {
        Font font = new Font("Monospaced", Font.ITALIC, 16);
        String tempStr = "NAME : "+patient.getName()+" "+patient.getSurname();
        JLabel nameLbl = new JLabel(tempStr);
        nameLbl.setFont(font);
        panel.add(nameLbl);
        tempStr = "Age: "+patient.getAge()+"     Gender: "+patient.getGender()+"     Height: "+patient.getHeight()
                +"     Weight: "+patient.getWeight()+"      Blood Type: "+patient.getBloodType();
        JLabel personalAttributesLbl = new JLabel(tempStr);
        personalAttributesLbl.setFont(font);
        tempStr = "ID: "+patient.getID();
        JLabel IDlbl = new JLabel(tempStr);
        IDlbl.setFont(font);
        panel.add(personalAttributesLbl);
        panel.add(IDlbl);
        LinkedList<Double> personalParameters = patient.GetDatas();
        tempStr = "Parameters : ";
        for (int i = 0; i < personalParameters.size(); i++)
        {

            tempStr = tempStr + Double.toString(personalParameters.get(i))+"      ";
        }
        JLabel parametersLbl = new JLabel(tempStr);
        parametersLbl.setFont(font);
        panel.add(parametersLbl);
        Disease[] diseases = patient.getDiseases();
        tempStr = "Diseases :  ";
        for (int i = 0; i < diseases.length; i++)
        {
            if(diseases[i]!=null)
                tempStr = tempStr + diseases[i].getName() + "       ";
        }
        JLabel diseasesLbl = new JLabel(tempStr);
        diseasesLbl.setFont(font);
        panel.add(diseasesLbl);
        MedicalPrescription prescription = patient.getMedPrescription();
        LinkedList<Medicine> meds = new LinkedList<>();
        if(prescription!=null)
             meds = prescription.medicines;
        tempStr = "Medicines : ";
        while (!meds.isEmpty())
        {
            tempStr = tempStr + meds.pop().name+"       ";
        }
        JLabel medsLbl = new JLabel(tempStr);
        medsLbl.setFont(font);
        panel.add(medsLbl);

    }
}
