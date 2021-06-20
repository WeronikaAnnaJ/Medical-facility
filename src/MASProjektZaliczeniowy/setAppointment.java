package MASProjektZaliczeniowy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class setAppointment extends JFrame{
    private JPanel appointmentPanel;
    private JButton umówWizytęLekarskąButton;
    private JButton odwołajWizytęLekarskąButton;
    private JLabel jLabelPowitanie;
    private JLabel JLabelGraphic;

    public  setAppointment(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(appointmentPanel);
        this.pack();

        umówWizytęLekarskąButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Umów wizytę");
            }
        });

        odwołajWizytęLekarskąButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Odwołaj wizytę");
            }
        });



        Icon icon = new ImageIcon("src/MASProjektZaliczeniowy/GraphicDoctor.jpg");
        JLabelGraphic.setIcon(icon);





}}
