package Task06_2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CodebasedFrame extends JFrame implements ActionListener {

    public JButton update;
    public JTextField textfield;
    public JLabel textLabel;
    public JComboBox<String> fontCombobox;
    public JComboBox sizeCombobox;

    public String font;
    public String size;

    public CodebasedFrame() {
        //initialize all the components
        initComponents();
        initPanels();
        initActionListener();
    }

    public void initComponents() {
        this.update = new JButton("Update");
        this.textfield = new JTextField(20);
        this.textfield.setText("I LOVE PDC :) !");
        this.textLabel = new JLabel("GUI Tutorial");

        this.font = "Arial";
        this.size = "20";
        // Set the font style and size for the content of label.
        this.textLabel.setFont(new Font(this.font, Font.PLAIN, Integer.parseInt(this.size)));

        this.fontCombobox = new JComboBox();
        this.fontCombobox.addItem("Arial");
        this.fontCombobox.addItem("Times New Roman");
        this.fontCombobox.addItem("Calibri");

        this.sizeCombobox = new JComboBox();
        this.sizeCombobox.addItem("20");
        this.sizeCombobox.addItem("30");
        this.sizeCombobox.addItem("40");
        this.sizeCombobox.addItem("50");

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void initPanels() {
        //North Panel
        JPanel northPanel = new JPanel();
        JLabel fontLabel = new JLabel("Font: ");
        JLabel sizeLabel = new JLabel("Size: ");
        northPanel.add(fontLabel);
        northPanel.add(this.fontCombobox);
        northPanel.add(sizeLabel);
        northPanel.add(this.sizeCombobox);
        this.add(northPanel, BorderLayout.NORTH);

        //Center Panel
        BGPanel centerPanel = new BGPanel();
        centerPanel.add(this.textLabel);
        this.add(centerPanel, BorderLayout.CENTER);

        //South Panel
        JPanel southPanel = new JPanel();
        southPanel.add(this.textfield);
        southPanel.add(update);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    public void initActionListener() {
        this.update.addActionListener(this);
        this.fontCombobox.addActionListener(this);
        this.sizeCombobox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.update) {
            this.textLabel.setText(this.textfield.getText());
        }
        if (e.getSource() == this.fontCombobox || e.getSource() == this.sizeCombobox) {
            this.font = this.fontCombobox.getSelectedItem().toString();
            this.size = this.sizeCombobox.getSelectedItem().toString();
            this.textLabel.setFont(new Font(this.font, Font.PLAIN, Integer.parseInt(this.size)));
        }

        this.repaint(); //This line of codes is redundant, please find out the reason... check the source code of setFont() function

    }

    public static void main(String[] args) {
        CodebasedFrame cf = new CodebasedFrame();
        cf.setVisible(true);
    }
}
