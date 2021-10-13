/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Admin_Log extends JFrame

{

    String loginuser;
    JTextField t_userName;
    JTextField t_password;
    JLabel l_userName,l_password;
    JButton b_login,b_fPassword,b_admin;
    
    public Admin_Log()

    {

        setBounds(400,200,750,370);  

        setTitle(" Admin Login ");

        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");

        setIconImage(icon);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ebName=new JLabel("Krishna Electricity Generating and Distribution Corporation");

        ebName.setBounds(120, 20, 520, 27);

        ebName.setFont(new Font("Verdana", Font.BOLD, 15));

        add(ebName);run(ebName);

       

         JLabel line1=new JLabel("____________________________________________________________________________________________________________________________");

        line1.setBounds(1, 270, 800, 20);add(line1);

         JLabel line2=new JLabel("____________________________________________________________________________________________________________________________");

        line2.setBounds(1, 50, 800, 20);add(line2);

        JLabel cpy=new JLabel("© 2021.Krishna Electricity Generating and Distribution Corporation");

        cpy.setBounds(180, 300, 500, 15);add(cpy);

       

        l_userName=new JLabel("Admin Name:");

        l_userName.setBounds(200, 90, 200, 30);

        l_password=new JLabel("Password:");

        l_password.setBounds(200, 140, 200, 30);

       

        t_userName=new JTextField();

        t_userName.setBounds(350, 90, 200, 30);

        t_password=new JPasswordField();

        t_password.setBounds(350, 140, 200, 30);

       

        b_login=new JButton("Login");

        b_login.setBounds(200, 180, 300, 30);

       

        b_admin=new JButton("Login as User");

        b_admin.setBounds(250,230,200,30);

       

        b_login.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e)

            {
                String user=t_userName.getText();
                String pass=t_password.getText();
                String systemadmin="systemadmin";
                System.out.print(user+" "+systemadmin);
                if(user.equals(systemadmin)){
                    if(pass.equals("admin")){
                       new Admin_Login();
                       dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Enter correct password");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Enter correct username");
                }
            }

        });


        b_admin.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e)

            {

                new Login_Form();

            }

        });

        

       

        add(l_userName);add(l_password);add(t_userName);add(t_password);add(b_login);add(b_admin);

        setLayout(null);

        setVisible(true);

}

    public void run(JLabel ebName) {

    ebName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

    }

    public static void main(String[] args) {

        new Admin_Log();

    }

}

