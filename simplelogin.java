import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class form extends JFrame
{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b;
    form()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        l1=new JLabel("SIMPLE LOGIN");
        l1.setBounds(80,30,150,30);
        l1.setFont(new Font("Times New Roman",Font.BOLD,20));
        l1.setForeground(Color.BLUE);
        add(l1);

        t1=new JTextField(60);
        t2=new JPasswordField(60);
        t1.setBounds(40,80,200,30);
        add(t1);
        t2.setBounds(40,120,200,30);
        add(t2);

        b=new JButton("login");
        b.setBounds(40,190,70,30);
        add(b);
        
        l2=new JLabel("");
        l2.setBounds(40,220,200,30);
        add(l2);

        b.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent ae)
          {
            l2.setText("successfully registered.......");
            dispose();
            calculatorr c=new calculatorr();
            c.setBounds(400,200,400,350);
            c.setVisible(true);
          }

        } );


    }

}

class simplelogin
{
    public static void main(String[] args)
    {
        form f=new form();
        f.setBounds(400,100,400,350);
        f.setVisible(true);
    }
}