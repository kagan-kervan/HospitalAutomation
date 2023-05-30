package src;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoctorUI
{
    private JPanel doctorPanel;
    private JLabel menuLabel;

    public DoctorUI(ArrayList<Doctor> list)
    {
        doctorPanel.setLayout(new BoxLayout(doctorPanel,BoxLayout.PAGE_AXIS));
        menuLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
        for (int i = 0; i < list.size(); i++) {
            AddDoctorsToPanel(i,list.get(i),doctorPanel);
        }
        JButton docSelectButton = new JButton("Get Patient Queue");
        docSelectButton.setHorizontalAlignment(SwingConstants.CENTER);
        docSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(JOptionPane.showInputDialog("Please enter index(0-9)"));
                if(index>9 || index<0)
                    JOptionPane.showMessageDialog(doctorPanel,"Error! Wrong index.");
                else
                {
                    DoctorInfoUI docinfo = new DoctorInfoUI(list.get(index));
                }
            }
        });
        doctorPanel.add(docSelectButton);
        JFrame f = new JFrame();
        f.add(doctorPanel);
        f.setSize(1000,600);
        f.setVisible(true);
    }

    private void AddDoctorsToPanel(int index, Doctor d,JPanel pn)
    {
        Font font = new Font("Monospaced", Font.ITALIC, 18);
        String attributeStr = Integer.toString(index)+" "+d.getName()+" "+d.getSurname()+"                "+
                d.getGender()+"              "+d.getAge() +"                     "+d.getProfession();
        JLabel attrLabel = new JLabel(attributeStr);
        attrLabel.setFont(font);
        pn.add(attrLabel);
    }
}
