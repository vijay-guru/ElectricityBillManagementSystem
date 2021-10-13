/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import javax.swing.*;
import java.sql.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loggedIn extends JFrame{
    JFrame f;
   
   public loggedIn(String userName){
        String lbl = "<html>" + "Know your" + "<br>" + "consumer id"+ "</html>";
        String lb2 = "<html>" + "Know your" + "<br>" + "   "+"region"+ "</html>";
        String lb3 = "<html>" + "   Consumers can make payment with the consumer number comprising 2 digit regioncode, 3 digit section code," + "<br>" + " 3 digit distribution code and service connection number with 1-4 digits.  Please provide Payee mobile number/"+ "<br>" +"email id. for future notifications from EB Board."+ "</html>";
        JLabel title = new JLabel("Quick Pay");
        title.setBounds(300,20,150,30);
        title.setFont(new Font("Verdana", Font.BOLD, 20));
       
        JLabel line1=new JLabel("____________________________________________________________________________________________________________________________________");
        line1.setBounds(1,50, 900, 30);
       
        JLabel l1 = new JLabel("Enter Consumer No with region code:");
        l1.setBounds(50,50+10,250,100);
       
        JTextField t1=new JTextField();  
        t1.setBounds(270,90+10, 180,20);  
       
        JLabel l2 = new JLabel("Enter your Mobile Number:");
        l2.setBounds(50,110+10,250,100);
       
        JTextField t2=new JTextField();  
        t2.setBounds(270,150+10, 180,20);
       
        JLabel la2 = new JLabel("( optional )");
        la2.setBounds(480,110+10,250,100);
       
        JLabel l3 = new JLabel("Enter your Email Id:");
        l3.setBounds(50,160+10,250,100);
       
        JTextField t3=new JTextField();  
        t3.setBounds(270,200+10, 180,20);
       
        JLabel la3 = new JLabel("( optional )");
        la3.setBounds(480,160+10,250,100);
       
        JButton b1=new JButton(lbl);  
        b1.setBounds(470,80+10,110,40);
       
        JButton b2=new JButton(lb2);  
        b2.setBounds(600,80+10,110,40);
       
        JButton b3=new JButton("Generate Bill");
        b3.setFont(new Font("Arial", Font.PLAIN, 20));
        b3.setBounds(250,260,200,50);
       
        JLabel line2=new JLabel("_________________________________________________________________________________________________________________________________");
        line2.setBounds(1,310, 900, 30);
       
        JLabel la4 = new JLabel("EB Board's Quick Pay bill payment facility:");
        la4.setBounds(50,295,270,100);
        la4.setFont(new Font("Arial", Font.BOLD, 13));

        JLabel la5 = new JLabel(lb3);
        la5.setBounds(80,318,800,120);
        la5.setFont(new Font("Arial", Font.PLAIN, 12));
       
        JButton back=new JButton("Back");  
        back.setBounds(580,295,100,30);
        String ans = "rishi";
        b1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
             try{
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
                    String k="select consumerno from consNo where userName ='"+userName+"'";
                    PreparedStatement stm=con.prepareStatement(k);
                    ResultSet  rs =stm.executeQuery();
                    if(rs.next()){
                        System.out.println(rs.getString(1));
                        JOptionPane.showMessageDialog(null,"Your "+ "consumer No is "+rs.getString(1));
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"vijay guru");
                    }
                    con.close();
                }catch(Exception ex){
                    System.out.println(ex);
                 }
            }
        });
       
        b3.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              
               String z="";
               if(t1.getText().equals(z)){
                   JOptionPane.showMessageDialog(null,"Enter your consumer number");
               }
               else{
               String cNo = t1.getText();
               cNo = cNo.substring(2);
              
             try{
                 
                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
                 Statement stmt=con.createStatement();
                 ResultSet rs=stmt.executeQuery("select * from consNo where CONSUMERNO = '"+cNo+"'");
                 if(rs.next()){
                    String fname="",lname="",consNum="";
                    long recieptnumber=0;
                    String k="select * from ebProject where userName='"+userName+"'";
                    PreparedStatement stm=con.prepareStatement(k);
                    rs =stm.executeQuery();
                    while(rs.next()){
                        fname=rs.getString(1);
                        lname=rs.getString(2);
                    }
                    k="select recieptNum from receiptNo";
                    stm=con.prepareStatement(k);
                    rs =stm.executeQuery();
                    while(rs.next()){
                        recieptnumber=rs.getLong(1);
                    }
                    long increment_rcpt_no=recieptnumber+1;
                    k="UPDATE receiptNo SET recieptNum = '"+increment_rcpt_no+"' ";
                    stm=con.prepareStatement(k);
                    rs =stm.executeQuery();
                    con.setAutoCommit(true);
                    String name=fname+" "+lname;
                    new GenerateBill(userName,name,cNo,recieptnumber);
                    dispose();
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Invalid Consumer Number");
                 }
                 con.close();
             }catch(Exception ex){
                 System.out.println(ex);
             }
               }    
           }
        });
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new HomePage(userName);
          
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new table();
          
            }
        });
       
        add(title);
        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(b1);
        add(b2);
        add(b3);
        add(la2);add(la3);
        add(la4);add(la5);
        add(line1);add(line2);
        add(back);
        setBounds(400,200,750,450);    
        setLayout(null);  
        setVisible(true);  
    }
   
    public static void main(String []args){
    }
}



