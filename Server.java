import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Server extends JFrame implements ActionListener
{
  // Creating required objects for gui
    JPanel panel;
    JTextField textfield;
    JButton button;
    static JTextArea textarea;
    //JPanel a1;

  // creating socket and server socket object
    static ServerSocket skt;
    static Socket s;
    static DataInputStream dip;
    static DataOutputStream dop;

// creating constructor
    Server()
    {
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(20,50,32));
        panel.setBounds(0,0,450,60);
        add(panel);
        
      // creating label for heading
        JLabel label=new JLabel("Gowthami");
        label.setFont(new Font("SAN_SERIF" ,Font.BOLD,20));
        label.setForeground(Color.WHITE);
        label.setBounds(130,3,400,40);
        panel.add(label);

      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/arrow.png"));
      Image i2= i1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel back=new JLabel(i3);
      back.setBounds(10,15,40,40);
      panel.add(back);

      back.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae)
        {
           System.exit(0);
        }
      });

      ImageIcon i12=new ImageIcon(ClassLoader.getSystemResource("icons/clear.png"));
      Image i13= i12.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
      ImageIcon i14=new ImageIcon(i13);
      JLabel clear=new JLabel(i14);
      clear.setBounds(300,0,80,80);
      panel.add(clear);

      clear.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae)
        {
           //System.exit(0);
           textarea.setText("");
        }
      });

      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/dots.png"));
      Image i5= i4.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
      ImageIcon i6=new ImageIcon(i5);
      JLabel dot=new JLabel(i6);
      dot.setBounds(400,10,35,35);
      panel.add(dot);

        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/msg.png"));
        Image i8= i7.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel msg=new JLabel(i9);
        msg.setBounds(65,5,50,50);
        panel.add(msg);

      JLabel status=new JLabel("Online");
      status.setBounds(130,35,100,18);
      status.setForeground(Color.WHITE);
      status.setFont(new Font("SAN_SERIF",Font.BOLD,14));
      panel.add(status);

      //text area where we can see our previous messages
        textarea=new JTextArea();
        textarea.setBounds(3,60,444,490);
        textarea.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
       textarea.setBackground(new Color(211,211,211));
        textarea.setEditable(false);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        add(textarea);

       /* a1=new JPanel();
        a1.setLayout(null);
        //a1.setBackground(new Color(20,50,32));
        a1.setBounds(0,5,461,576);
        add(a1);*/
      
     /*  JLabel background;
      ImageIcon img= new ImageIcon("icons/background.jpeg");
      Image i10= img.getImage().getScaledInstance(450,570,Image.SCALE_DEFAULT);
      ImageIcon i11=new ImageIcon(i10);
      // background=new JLabel("",i11,JLabel.CENTER);
      background=new JLabel(i11);
      background.setBounds(0,5,460,575);
      textarea.add(background);*/

      // Text field in which we will type our messages
        textfield=new JTextField();
        textfield.setBounds(10,555,325,40);
        textfield.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(textfield);

      // creating send button
        button=new JButton("SEND");
        button.setBounds(355,555,90,40);
        button.setBackground(new Color(20,50,32));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        button.addActionListener(this);
        add(button);

        setLayout(null);
        setSize(470,640);
        setLocation(50,50);
        setVisible(true);
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

      // defining action performed method ..it start executing when send button is clicked
       public void actionPerformed(ActionEvent ae)
       {
        try{
            String out = textfield.getText();
            textarea.setText(textarea.getText()+"\n\t\t\t"+" Gowthami :- "+out);
            dop.writeUTF(out);
            textfield.setText("");
        }catch( Exception e)
        { }
       } 

 // creating main
  public static void main(String []args)
  {
    new Server().setVisible(true);
    String msg="";
    try{
        skt=new ServerSocket(4321);
        s=skt.accept();
        dip=new DataInputStream(s.getInputStream());
        dop=new DataOutputStream(s.getOutputStream());
        while(true)
        {
            msg=dip.readUTF();
            textarea.setText(textarea.getText()+"\n"+"Priya :- "+msg);
        }
    }catch(Exception e)
    { }
  }
}