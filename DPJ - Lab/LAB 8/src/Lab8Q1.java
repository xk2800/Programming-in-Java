// CHAN LIN CHEE 1191202546
// TT6V
// Lab 8 - Question 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class Lab8Q1 extends JFrame implements ActionListener {
    private JLabel lb1, lb2, lb3;
    private JRadioButton rb1, rb2;
    private JTextField tf1, tf2;
    private JButton btn;
    private JPanel p1, p2, p3;

    public static void main(String [] args){
        Lab8Q1 f = new Lab8Q1();
        f.setSize(520,160);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Lab 7 - Q1");
    }

    public Lab8Q1() {
        setLayout(new BorderLayout());

        p1 = new JPanel();
        lb1 = new JLabel("Types of flowers : ");
        rb1 = new JRadioButton("Roses bouquet $30");
        rb2 = new JRadioButton("Carnations bouquet $38");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);   bg.add(rb2);
        p1.add(lb1);   p1.add(rb1);   p1.add(rb2);

        p2 = new JPanel(new GridBagLayout());
        lb2 = new JLabel("Quantity : ");
        tf1 = new JTextField(10);
        p2.add(lb2);   p2.add(tf1);

        p3 = new JPanel();
        btn = new JButton("Calculate");
        lb3 = new JLabel("Total Payment Amount : ");
        tf2 = new JTextField(18);
        tf2.setEditable(false);
        p3.add(btn);   p3.add(lb3);   p3.add(tf2);

        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);

        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat df = new DecimalFormat("0.00");
        double pay = 0;

        if(e.getSource() == btn){
            try{
                int qty = Integer.parseInt(tf1.getText());

                if(rb1.isSelected())        pay = (qty * 30) + 5;
                else if(rb2.isSelected())   pay = (qty * 38) + 5;

                tf2.setText("$" + String.valueOf(df.format(pay)));
            }catch (NumberFormatException exc){
                tf2.setText("Please insert integer for quantity! ");
            }
        }
    }
}
