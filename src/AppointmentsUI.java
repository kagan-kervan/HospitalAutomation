package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppointmentsUI
{
    private JPanel appointmentsPanel;
    private JLabel doctorNamePatientNameLabel;
    private JTextField[] textFields;
public AppointmentsUI(ArrayList<Appointment> appointments)
{
    doctorNamePatientNameLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
    appointmentsPanel.setLayout(new BoxLayout(appointmentsPanel,BoxLayout.PAGE_AXIS));
    for (int i = 0; i < appointments.size(); i++)
    {
        Appointment a = appointments.get(i);
        createUIComponents(a.getDoctor(),a.getPatient(),a.getDate(), appointmentsPanel);
    }
    JFrame f = new JFrame();
    f.setSize(1000,800);
    f.add(appointmentsPanel);
    f.setVisible(true);
}

    private void createUIComponents(Doctor d, Patient P,String date,JPanel p) {
        String labelStr = d.getName()+" "+d.getSurname()+"                 "+P.getName()+" "
                +P.getSurname()+"                   "+date;
        JLabel lbl = new JLabel(labelStr);
        lbl.setFont(new Font("Monospaced", Font.ITALIC, 16));
        p.add(lbl);
    }
}
