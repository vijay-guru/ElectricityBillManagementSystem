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

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPasswordField;

import javax.swing.JTextField;

 

/**

 *

 * @author Acer-nitro5

 */

public class Change_Password extends JFrame{

    String loginuser;

    JPasswordField t_newPassword;

    JPasswordField t_confirmPassword;

    JLabel l_newPassword,l_confirmPassword;

    JButton b_changePassword;

    public Change_Password(String loginuser)

    {

        setBounds(400,200,750,420);   

        setTitle(" Change Password ");

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

       

        l_newPassword=new JLabel("New Password:");

        l_newPassword.setBounds(200, 90, 200, 30);

        l_confirmPassword=new JLabel("Confirm Password:");

        l_confirmPassword.setBounds(200, 140, 200, 30);

        t_newPassword=new JPasswordField();

        t_newPassword.setBounds(350, 90, 200, 30);

        t_confirmPassword=new JPasswordField();

        t_confirmPassword.setBounds(350, 140, 200, 30);

       

        b_changePassword=new JButton("Change Password");

        b_changePassword.setBounds(250,230,200,30);

       

        b_changePassword.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e)

            {

                String p=t_newPassword.getText();

                String p1=t_confirmPassword.getText();

                try

                {

                    if(p.equals(p1))

                    {

                        Class.forName("oracle.jdbc.driver.OracleDriver");

                        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmi");

                        String query="update ebProject set Password=? where userName=?";

                        PreparedStatement pst=con.prepareStatement(query);

                        pst.setString(1, p);

                        pst.setString(2, loginuser);

                        pst.executeUpdate();

                        con.setAutoCommit(true);

                        con.close();

                        JOptionPane.showMessageDialog(null,"Password Changed");

                        dispose();

                        new Login_Form();

                    }

                    else

                    {

                        JOptionPane.showMessageDialog(null,"Password does not match","Error",JOptionPane.WARNING_MESSAGE);

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

       

        add(l_newPassword);add(l_confirmPassword);add(t_newPassword);add(t_confirmPassword);add(b_changePassword);

        setLayout(null);

        setVisible(true);

    }

    public void run(JLabel ebName) {

        ebName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

    }

    public static void main(String[] args) {

        new Change_Password("vjguru18");

    }

}
