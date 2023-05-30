package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PatientsUI {
    private JPanel patientsPanel;
    private JLabel patientsMenuLabel;

    public PatientsUI(ArrayList<Patient> patients, System system)
    {
        patientsPanel.setLayout(new BoxLayout(patientsPanel,BoxLayout.PAGE_AXIS));
        patientsMenuLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        for (int i = 0; i < patients.size(); i++)
        {
            createUIPatientLabels(patientsPanel,i,patients.get(i));
        }
        JButton analysisButton = new JButton("Get Analysis Report");
        analysisButton.setHorizontalAlignment(SwingConstants.CENTER);
        analysisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(JOptionPane.showInputDialog("Please enter index between 0 and 30"));
                if(index>29)
                    JOptionPane.showMessageDialog(null,"You entered a wrong index.");
                else
                {
                    system.EndWorkingShift();
                    AnalysisUI analysisUI = new AnalysisUI(patients.get(index));
                }
            }
        });
        patientsPanel.add(analysisButton);
        JFrame f = new JFrame();
        f.add(patientsPanel);
        f.setSize(1200,1000);
        f.setVisible(true);
    }

    private void createUIPatientLabels(JPanel panel,int index,Patient p)
    {
        String labelStr = ""+index+" "+p.getName()+" "+p.getSurname()+"          "+p.getAge()+"           " +p.getGender()
                +"              "+p.getHeight()+"          "+p.getWeight()+"                   "+p.getBloodType();
        JLabel lbl = new JLabel(labelStr);
        lbl.setFont(new Font("Monospaced", Font.ITALIC, 18));
        panel.add(lbl);
    }
}
