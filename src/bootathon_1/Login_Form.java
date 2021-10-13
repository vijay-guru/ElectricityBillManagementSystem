/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.awt.Color;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JPasswordField;

import javax.swing.JTextField;

public class Login_Form extends JFrame

{

    String loginuser;

    JTextField t_userName;

    JPasswordField t_password;

    JLabel l_userName,l_password,label;

    JButton b_login,b_fPassword,b_admin,b_register;

    public Login_Form()

    {

        setBounds(400,200,750,420);  

        setTitle(" Login Form ");

        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");

        setIconImage(icon);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ebName=new JLabel("Krishna Electricity Generating and Distribution Corporation");

        ebName.setBounds(120, 20, 520, 27);

        ebName.setFont(new Font("Verdana", Font.BOLD, 15));

        add(ebName);run(ebName);

       

         JLabel line1=new JLabel("____________________________________________________________________________________________________________________________");

        line1.setBounds(1, 300, 800, 20);add(line1);

         JLabel line2=new JLabel("____________________________________________________________________________________________________________________________");

        line2.setBounds(1, 50, 800, 20);add(line2);

        JLabel cpy=new JLabel("© 2021.Krishna Electricity Generating and Distribution Corporation");

        cpy.setBounds(180, 350, 500, 12);add(cpy);

       

        l_userName=new JLabel("User Name:");

        l_userName.setBounds(200, 90, 200, 30);

        l_password=new JLabel("Password:");

        l_password.setBounds(200, 140, 200, 30);

        label=new JLabel("New user register :");

        t_userName=new JTextField();

        t_userName.setBounds(350, 90, 200, 30);

        t_password=new JPasswordField();

        t_password.setBounds(350, 140, 200, 30);

       

        b_login=new JButton("Login");

        b_login.setBounds(200, 180, 100, 30);

        b_fPassword=new JButton("Forgot Password");

        b_fPassword.setBounds(350, 180, 200, 30);

        b_admin=new JButton("Login as Admin");

        b_admin.setBounds(250,230,200,30);

        b_register=new JButton("Register");

       

        label.setBounds(200, 270, 300, 30);

        b_register.setBounds(350, 270, 100, 30);

        b_login.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e)

            {

                String loginpassword,temp;

                loginuser=t_userName.getText();

                loginpassword=t_password.getText();

                try

                {

                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmi");

                    String query="select * from ebProject where userName=? and Password=?";

                    PreparedStatement pst=con.prepareStatement(query);

                    pst.setString(1, loginuser);

                    pst.setString(2, loginpassword);

                    ResultSet rst=pst.executeQuery();

                    if(rst.next())

                    {

                        dispose();

                        new HomePage(loginuser);

                    }

                    else

                    {

                        JOptionPane.showMessageDialog(null,"Enter valid Username and Password","Error",JOptionPane.WARNING_MESSAGE);

                    }

                }

                catch (ClassNotFoundException ex) {

                    System.out.println(ex);

                }

                catch (SQLException ex) {

                    System.out.println(ex);

                }

            }

        });

        b_fPassword.addActionListener(new ActionListener() {//Forgot Passworrd

            @Override

            public void actionPerformed(ActionEvent e)

            {

                dispose();

                new Forgot_Password();

            }

        });

        b_admin.addActionListener(new ActionListener() {//Login as Admin

            @Override

            public void actionPerformed(ActionEvent e)

            {

                new Admin_Log();
                dispose();

            }

        });

        b_register.addActionListener(new ActionListener() {//Register

            @Override

            public void actionPerformed(ActionEvent e)

            {

                dispose();
            String Guide12 = "<html>" +"GUIDELINES :: "+"<br>"+"<br>"+ " ==>New users can sign up through this Web Page for payment of CC charges through Credit / Debit cards or through Net Banking."+"<br>"+"</t>"+"The consumer "
    + "has to sign up once for registration.This requires a valid Consumer ID and an e-mail account."+"<br>"+ " ==> On completion of registration requirements, an e-mail is generated to the consumer for successful"
    + " validation of e-mail ID."+"<br>"+"</t>"+" A click on the link in the e-mail will lead to user login screen."+"<br>" + " ==>The user shall login and key in his authenticated password for making payments through"
    + " web site."+"<br>" + " ==>Consumer number/User Id for which registration has been made cannot be modified and if required, "+"<br>"+"</t>"+"the user can be deleted through the support link and a fresh registration "
    + "can be made."+"<br>" + " ==>One user can add 24 Consumer Numbers using Add Consumer No button in his user account and shall pay during the "+"<br>"+"</t>"+"corresponding collection cycle for the respective consumer.Every "
    + "consumer number has to be individually selected "+"<br>"+"</t>"+"for making payment."+"<br>"+ " ==>A print of the e-receipt could be generated"+"<br>"+ " ==>The changes in consumer number and e-mail ID and other personal "
    + "particulars could be carried out using Update Profile button.."+"<br>"+ " ==>The user shall change his passwords frequently for security purposes using Change Password button."+"<br>"+ " ==>A Forget password link is available "
    + "for generating e-mail to the registered mail-id which shall furnish the current password."+"</html>";
    JOptionPane.showMessageDialog(null,Guide12);
                new Registration_Form();

            }

        });

       

        add(l_userName);add(l_password);add(t_userName);add(t_password);add(b_login);add(b_fPassword);add(b_admin);add(b_register);add(label);

        setLayout(null);

        setVisible(true);

}

    public void run(JLabel ebName) {

    ebName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

    }

    public static void main(String[] args) {

        new Login_Form();

    }

}

