/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Password extends JFrame{
    public Password(long otpNo,String userName){
        
        setBounds(630,400,300,200);  
        setLayout(null);  
        setVisible(true); 
        setTitle(" Safe & Secure ");
        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");
        setIconImage(icon);
        
        JLabel enter=new JLabel("Enter OTP : ");
        JTextField enterotp=new JTextField();
        JButton cp=new JButton("Confirm");
        JLabel line1=new JLabel("______________________________________________________________________________________________________________");
        JLabel line2=new JLabel("______________________________________________________________________________________________________________");
       
        enter.setBounds(30,40,300,30);add(enter);
        enterotp.setBounds(140,45,130,20);add(enterotp);
        cp.setBounds(80,90,140,20);add(cp);
        line1.setBounds(1, 10, 300, 20);
        line2.setBounds(1, 120, 300, 20);
        
        add(line2);add(line1);
        cp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       String s=enterotp.getText();
                       long l=Long.parseLong(s);
                       try { 
                       if(l==otpNo){
                          
                              System.out.println("database fetching");
                              Class.forName("oracle.jdbc.driver.OracleDriver");
                              Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmi");
                              String query="update paid set paid_9=1 where userName='"+userName+"'";
                              PreparedStatement pst=con.prepareStatement(query);
                              pst.executeUpdate();
                              con.setAutoCommit(true);
                              System.out.println("database fetced");
                          
                    
                           JOptionPane.showMessageDialog(null,"!.....Payment Successful.....!");
                           dispose();
                      }
                       else{
                           JOptionPane.showMessageDialog(null,"!.....Payment Failed.....!");
                           
                       }
                       }catch (Exception ee){
                        System.out.println(ee);
                    }
            }
        });
    }
    public static void main(String[] args) {
    }
}

