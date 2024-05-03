package Task06_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class SimpleGUI extends JFrame {

    public JButton updateBtn;
    public JTextField textfield;
    public JLabel textLabel;

    public SimpleGUI() {

        textfield = new JTextField(20);
        textfield.setText("I LOVE PDC :) !");
        textLabel = new JLabel("GUI Tutorial");
        updateBtn = new JButton("Update");
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText(textfield.getText().trim());
            }
        });

        //Center Panel
        BGPanel centerPanel = new BGPanel();
        centerPanel.add(this.textLabel);
        this.add(centerPanel, BorderLayout.CENTER);

        //South Panel
        JPanel southPanel = new JPanel();
        southPanel.add(this.textfield);
        southPanel.add(updateBtn);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SimpleGUI cf = new SimpleGUI();
        cf.setVisible(true);
    }
}
