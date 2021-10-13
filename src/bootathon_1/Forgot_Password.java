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

import java.util.concurrent.ThreadLocalRandom;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JPasswordField;

import javax.swing.JTextField;

public class Forgot_Password extends JFrame

{

    String loginuser;

    JTextField t_mail;

    JTextField t_userName;

    JTextField t_code;

    JLabel l_mail,l_userName,l_code;

    JButton b_sendMail,b_verify,b_back;

    public Forgot_Password()

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

        l_mail=new JLabel("Mail-ID:");

        l_mail.setBounds(200, 140, 200, 30);

        l_code=new JLabel("Enter OTP :");

        l_code.setBounds(200, 190, 200, 30);

       

        t_userName=new JTextField();

        t_userName.setBounds(350, 90, 200, 30);

        t_mail=new JTextField();

        t_mail.setBounds(350, 140, 200, 30);

        t_code=new JTextField();

        t_code.setBounds(350, 190, 200, 30);

       

        b_sendMail=new JButton("Send OTP");

        b_sendMail.setBounds(200, 250, 100, 30);

        b_verify=new JButton("Verify");

        b_verify.setBounds(350, 250, 100, 30);

        b_back=new JButton("Back");

        b_back.setBounds(500, 250, 100, 30);

       

        ThreadLocalRandom random = ThreadLocalRandom.current();                            

        long rand = random.nextLong(100000, 999900);

       

        b_sendMail.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String loginuser=t_userName.getText();

                String mail=t_mail.getText();

                try{

                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmi");

                    String query="select * from ebProject where userName=? and EmailId=?";

                    PreparedStatement pst=con.prepareStatement(query);

                    pst.setString(1,loginuser);

                    pst.setString(2,mail);

                    ResultSet rst=pst.executeQuery();

                   

                    if(rst.next())

                    {
                        String msg="Your otp to recover password is:";
                        new Otp(mail,rand,msg);

                        //JOptionPane.showMessageDialog(null, "Mail sent to your Mail adddress");

                    }

                    else

                    {

                        JOptionPane.showMessageDialog(null, "Enter correct Username and Mail address","Warning",JOptionPane.WARNING_MESSAGE);

                    }

                }

                catch(ClassNotFoundException ex)

                {

                    System.out.println(ex);

                }

                catch(SQLException exx)

                {

                    System.out.println(exx);

                }

               

               

               

            }

        });

        b_verify.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                try{

                    loginuser=t_userName.getText();

                    String temp=t_code.getText();

                    long code=Integer.parseInt(temp);

               

                    if(rand==code)

                    {

                        JOptionPane.showMessageDialog(null, "Verification Successfull");

                    }

                    else

                    {

                        JOptionPane.showMessageDialog(null, "OTP incorrect","Error",JOptionPane.WARNING_MESSAGE);

                    }

                    dispose();

                    new Change_Password(loginuser);

                }

                catch(NumberFormatException ne)

                {

                    JOptionPane.showMessageDialog(null, "Enter Valid OTP and try","Error",JOptionPane.WARNING_MESSAGE);

                }

            }

        });

        b_back.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                dispose();

                new Login_Form();

            }

        });

       

       

        add(l_userName);add(l_mail);add(t_userName);add(t_mail);add(b_verify);add(b_sendMail);add(t_code);add(l_code);add(b_back);

        setLayout(null);

        setVisible(true);

}

    public void run(JLabel ebName) {

        ebName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

    }

    public static void main(String[] args) {

        new Forgot_Password();

    }

}

