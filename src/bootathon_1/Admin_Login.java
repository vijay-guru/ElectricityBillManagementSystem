
package bootathon_1;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Admin_Login {
    JTextField userName,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JLabel user,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,sd;
    JButton getUnit = new JButton("Get units");
    JButton b=new JButton("Submit");
    JButton c=new JButton("Logout");
    int uJan,uFeb,uMarch,uApril,uMay,uJune,uJuly,uAugust,uSep,uOct,uNov,uDec;
    public Admin_Login()
    {
        JFrame f=new JFrame("Admin Form");
       
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                f.dispose();
            }
        });
       
        user = new JLabel("User Name");
        sd=new JLabel("SYSTEM ADMIN");
        l1=new JLabel("January");
        l2=new JLabel("February");
        l3=new JLabel("March");
        l4=new JLabel("April");
        l5=new JLabel("May");
        l6=new JLabel("June");
        l7=new JLabel("July");
        l8=new JLabel("August");
        l9=new JLabel("September");
        l10=new JLabel("October");
        l11=new JLabel("November");
        l12=new JLabel("December");
       
        sd.setBounds(200,15,100,20);
        user.setBounds(50,50,100,30);
        l1.setBounds(50,100,100,30);
        l2.setBounds(50, 150, 100, 30);
        l3.setBounds(50, 200, 100, 30);
        l4.setBounds(50,250,100,30);
        l5.setBounds(50,300,100,30);
        l6.setBounds(50,350,100,30);
        l7.setBounds(50,400,100,30);
        l8.setBounds(50,450,100,30);
        l9.setBounds(50,500,100,30);
        l10.setBounds(50,550,100,30);
        l11.setBounds(50,600,100,30);
        l12.setBounds(50,650,100,30);
       
        userName =new JTextField();
        userName.setBounds(150, 50, 170, 30);
        getUnit.setBounds(350, 50, 100, 30);
        t1=new JTextField();
        t1.setBounds(200, 100, 200, 30);
        t2=new JTextField();
        t2.setBounds(200, 150, 200, 30);
        t3=new JTextField();
        t3.setBounds(200, 200, 200, 30);
        t4=new JTextField();
        t4.setBounds(200, 250, 200, 30);
        t5=new JTextField();
        t5.setBounds(200, 300, 200, 30);
        t6=new JTextField();
        t6.setBounds (200,350,200,30);
        t7=new JTextField();
        t7.setBounds (200, 400, 200, 30);
        t8=new JTextField();
        t8.setBounds (200, 450, 200, 30);
        t9=new JTextField();
        t9.setBounds (200, 500, 200, 30);
        t10=new JTextField();
        t10.setBounds (200, 550, 200, 30);
        t11=new JTextField();
        t11.setBounds (200, 600, 200, 30);
        t12=new JTextField();
        t12.setBounds (200, 650, 200, 30);
       


        getUnit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                try{
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
                    String sql = "select * from units where userName = '"+userName.getText()+"'";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    if(rs.next()){
                           t1.setText(Integer.toString(rs.getInt(2)));
                           t2.setText(Integer.toString(rs.getInt(3)));
                           t3.setText(Integer.toString(rs.getInt(4)));
                           t4.setText(Integer.toString(rs.getInt(5)));
                           t5.setText(Integer.toString(rs.getInt(6)));
                           t6.setText(Integer.toString(rs.getInt(7)));
                           t7.setText(Integer.toString(rs.getInt(8)));
                           t8.setText(Integer.toString(rs.getInt(9)));
                           t9.setText(Integer.toString(rs.getInt(10)));
                           t10.setText(Integer.toString(rs.getInt(11)));
                           t11.setText(Integer.toString(rs.getInt(12)));
                           t12.setText(Integer.toString(rs.getInt(13)));
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid Username");
                    }

                }catch(Exception el){
                    System.out.println(el);
                }
            }  
        });
       
        b.setBounds(150,700,100,30);
        c.setBounds(250,700,100,30);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
                        Statement st = con.createStatement();
                           int update = st.executeUpdate("update units set unit_1 = '"+t1.getText()+"',unit_2 = '"+t2.getText()+"',unit_3 = '"+t3.getText()+"',unit_4 = '"+t4.getText()+"',unit_5 = '"+t5.getText()+"',unit_6 = '"+t6.getText()+"',unit_7 = '"+t7.getText()+"',unit_8 = '"+t8.getText()+"',unit_9 = '"+t9.getText()+"',unit_10 = '"+t10.getText()+"',unit_11 = '"+t11.getText()+"',unit_12 = '"+t12.getText()+"' where userName = '"+userName.getText()+"' ");
                        System.out.println(update + " rows inserted");
                        JOptionPane.showMessageDialog(null,"Updated Account!!");
                       
                    }catch(Exception ex){System.out.println(ex);}
            }
           
        });
        c.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null,"Loggedout Successfully");
                       f.dispose();  
                        new Admin_Log();
                        
            }
           
        });
        f.add(sd);f.add(user);f.add(userName);
        f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);f.add(t7);f.add(t8);f.add(t9);f.add(t10);f.add(t11);f.add(t12);
        f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);f.add(l9);f.add(l10);f.add(l11);f.add(l12);
        f.add(b);f.add(c);
        f.add(getUnit);
        f.setBounds(480,30,500,780);
        f.setLayout(null);
        f.setVisible(true);
     
       
       
    }
    public static void main(String s[])
    {
        new Admin_Login();
    }
}
