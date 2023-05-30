package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalUI {

    private static  HospitalUI instance = new HospitalUI();
    private JPanel Main;
    private JButton doctorsButton;
    private JButton patientsButton;
    private JButton appointmentsButton;
    private JButton advance1ShiftButton;
    private JButton advance1HourButton;
    private JButton generatePatientsButton;

    private HospitalUI()
    {
        System s = System.getInstance();
        JFrame m = new JFrame();
        m.add(Main);
        m.setSize(900,300);
        m.setName("DEUHAS Main Menu");
        m.setVisible(true);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    doctorsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            java.lang.System.out.println("Doctor button Test.");
            DoctorUI docUI = new DoctorUI(s.doctorList);
        }
    });
        patientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.lang.System.out.println("Patient button Test.");
                PatientsUI pat = new PatientsUI(s.patients,s);
            }
        });
        appointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.lang.System.out.println("Appointments button Test.");
                AppointmentsUI appointmentsUI = new AppointmentsUI(s.getAppointments());
            }
        });

        advance1ShiftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.lang.System.out.println("Advance 1 shift button Test.");
                s.EndWorkingShift();
                String advanceStr = "Advanced 1 shift(20 minutes).\nShifts left: "+(3-s.hourRepeatCount);
                JOptionPane.showMessageDialog(m,advanceStr);
            }
        });

        advance1HourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.lang.System.out.println("Advance 1 hour button Test.");
                s.EndWorkingHour();
                String advanceStr = "Advanced 1 hour with 4 shifts.\n\tTotal Hour: "+(s.shiftHour-10);
                JOptionPane.showMessageDialog(m,advanceStr);
            }
        });
        generatePatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.patients = s.CreatePatients(30);
                s.CreateAppointments();
                JOptionPane.showMessageDialog(null,"Generated new Patients.");
            }
        });
    }


    public static HospitalUI getInstance()
    {
        //Singleton pattern usage.
        return instance;
    }
}
