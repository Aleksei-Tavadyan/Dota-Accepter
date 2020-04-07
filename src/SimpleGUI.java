import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField output = new JTextField("", 5);
    private JLabel label = new JLabel("Output:");
    private JLabel label1 = new JLabel("ExtraOut");

    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that");
    private JCheckBox check = new JCheckBox("Check", false);
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public void sendOutputMessage (String text)
    {
        JOptionPane.showMessageDialog(this.getOutput(),text);
    }


    public JTextField getOutput()
    {
        return this.output;
    }
    public void setLabelText(String text)
    {
        this.label.setText(text);
    }
    public void setExtraLabelText(String text)
    {
        this.label1.updateUI();
        this.label1.setText(text);

    }


    public SimpleGUI() {
        super("Simple Example");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(label1);
        //container.add(output);



       /* ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);

        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);*/


    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is " + output.getText() + "\n";
            message += (radio1.isSelected()?"Radio #1":"Radio #2")
                    + " is selected\n";
            message += "CheckBox is " + ((check.isSelected())
                    ?"checked":"unchecked");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }




}