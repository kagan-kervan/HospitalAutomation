package src;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class DoctorInfoUI {
    private JPanel panel;
    private JLabel menuLabel;

    public DoctorInfoUI(Doctor doctor)
    {
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        AddPatientLabelsToPanel(doctor.getPatientQueue(),panel);
        menuLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
        JFrame f = new JFrame();
        f.add(panel);
        f.setSize(1000,300);
        f.setVisible(true);
    }

    public void AddPatientLabelsToPanel(LinkedList<Patient> patientqueue,JPanel pn)
    {
        Font font = new Font("Monospaced", Font.ITALIC, 22);
        for (int i = 0; i < patientqueue.size(); i++)
        {
            Patient pt = patientqueue.get(i);
            String labelStr = i +" "+pt.getName()+" "+pt.getSurname()+"         "+pt.getAge()+"         "+pt.getGender()
                    +"          "+pt.getBloodType()+"           "+pt.getPhone().PhoneNumber;
            JLabel label = new JLabel(labelStr);
            label.setFont(font);
            pn.add(label);
        }
    }
}
