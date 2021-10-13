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
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GenerateBill extends JFrame{
   
    public GenerateBill(String userName,String namel,String consnum,long receiptnumber){
        
       
        setBounds(400,200,750,450);  
        setLayout(null);  
        setVisible(true);
        setTitle(" Bill Generation ");
        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");
        setIconImage(icon);
       
        JLabel ebName=new JLabel("Krishna Electricity Generating and Distribution Corporation");
        JLabel mgb=new JLabel("Machine Generated Bill");
        JLabel namell=new JLabel(namel);
        JLabel consNo1=new JLabel(consnum);
        JLabel name=new JLabel("Name             : ");
        JLabel rcptNo=new JLabel("Receipt No : ");
        JLabel rcptNo1=new JLabel();
        JLabel consNo=new JLabel("Consumer No : ");
        JLabel date=new JLabel("Date           : ");
        JLabel date1=new JLabel("");
        JLabel sno=new JLabel("S.No");
        JLabel ccdetails=new JLabel("Charges Details");
        JLabel amount=new JLabel("Amount");
        JLabel paymentdetails=new JLabel("Paymet Details :");
        JLabel cinNo=new JLabel("Krishna.CIN No : U67190TN2009SGC073");
        JLabel gstNo=new JLabel("Krishna.GST No : 33AADCT4784E1ZC");
        JLabel sno1=new JLabel("1.");
        JLabel charge=new JLabel("Current charges + Electricity Tax");
        JLabel amount1=new JLabel();
        JLabel vline1=new JLabel("|");
        JLabel vline2=new JLabel("|");
        JLabel vline3=new JLabel("|");
        JLabel vline4=new JLabel("|");
        JLabel vline5=new JLabel("|");
        JLabel vline6=new JLabel("|");
        JLabel vline7=new JLabel("|");
        JLabel vline8=new JLabel("|");
        JLabel line1=new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________");
        JLabel line2=new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________");
        JLabel line3=new JLabel("___________________________________________________________________________________________________________________________________________________________________________________________________");
        JButton onlinepay=new JButton("Pay");
        JButton home=new JButton("HOME");
        JButton download=new JButton("Download Bill");
       
        Date date2 = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String strDate = formatter.format(date2);
        date1.setText(strDate);
       
        line1.setBounds(1, 124, 750, 30);
        line2.setBounds(1, 154, 750, 30);
        line3.setBounds(1, 274, 750, 30);
        consNo1.setBounds(145,118,150,20);
        consNo.setBounds(40,118, 110, 20);
        date.setBounds(520,118, 120, 20);
        date1.setBounds(616,118,100,20);
        name.setBounds(40,90, 110, 20);
        rcptNo.setBounds(520, 90, 170, 20);
        rcptNo1.setBounds(616,90,130,20);
        namell.setBounds(145,90, 100, 20);
        mgb.setBounds(280, 43, 400, 27);
        ebName.setBounds(130, 20, 518, 27);
        vline1.setBounds(130, 133, 10, 30);add(vline1);
        vline2.setBounds(130, 137, 10, 30);add(vline2);
        vline3.setBounds(130, 141, 10, 30);add(vline3);
        vline4.setBounds(130, 152, 10, 30);add(vline4);
        vline5.setBounds(480, 133, 10, 30);add(vline5);
        vline6.setBounds(480, 137, 10, 30);add(vline6);
        vline7.setBounds(480, 141, 10, 30);add(vline7);
        vline8.setBounds(480, 152, 10, 30);add(vline8);
        sno.setBounds(50, 149, 40, 20);add(sno);
        ccdetails.setBounds(250, 149, 140, 20);add(ccdetails);
        amount.setBounds(580, 149, 70, 20);add(amount);
        paymentdetails.setBounds(25, 300, 150, 20);add(paymentdetails);
        cinNo.setBounds(25, 330, 235, 20);add(cinNo);
        gstNo.setBounds(25, 350, 210, 20);add(gstNo);
        onlinepay.setBounds( 450, 330, 60, 20);add(onlinepay);
        home.setBounds( 450, 362, 210, 20);add(home);
        amount1.setBounds(580, 187, 70, 20);add(amount1);
        sno1.setBounds(55,187,20,20);add(sno1);
        charge.setBounds(207,187,200,20);add(charge);
        download.setBounds( 530, 330, 130, 20);add(download);
     
        String rcptno2= String.valueOf(receiptnumber);
        rcptNo1.setText(rcptno2);
       
        consNo.setFont(new Font("Verdana", Font.BOLD, 12));
        date.setFont(new Font("Verdana", Font.BOLD, 12));
        name.setFont(new Font("Verdana", Font.BOLD, 12));rcptNo.setFont(new Font("Verdana", Font.BOLD, 12));
        mgb.setFont(new Font("Ariel", Font.ITALIC, 16));
        ebName.setFont(new Font("Verdana", Font.BOLD, 15));
       
        add(ebName);add(mgb);add(name);add(consNo);add(rcptNo);add(date);add(line1);add(line2);add(line3); add(rcptNo1);add(consNo1);add(date1);add(namell);
       
        LocalDate currentdate = LocalDate.now();
        Month currentMonth = currentdate.getMonth();
        formatter = new SimpleDateFormat("MM");
        strDate = formatter.format(date2);
       
        if(strDate.charAt(0)=='0'){
            strDate=strDate.substring(1);
        }
        int month=Integer.parseInt(strDate);
        int unit=0;
        float money=0,z=0;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
            String k="select * from units where userName='"+userName+"'";
            PreparedStatement stm=con.prepareStatement(k);
            ResultSet  rs =stm.executeQuery();
            if(rs.next())
            {
                unit=rs.getInt(month+1);
                if(unit>=0 && unit<=100){
                    money=0;
                }
                else if(unit>100 && unit<=200){
                    z=unit-100;
                    money=(float)1.5 * z;
                }
                else if(unit>200 && unit<=500){
                    money=200;
                    unit=unit-200;
                    unit=unit*3;
                    money +=unit;
                }
                else if(unit>500){
                    money+=1730;
                    unit=unit-500;
                    z=unit;
                    z=(float)6.6*z;
                    money+=z;
                    }
            }
        }
        catch(Exception ex){
                 System.out.println(ex);
        }
        String money1=String.valueOf(money);
        final float price=money;
        amount1.setText(money1);
       
        String paid;
        int flag=0;
               
        try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
                    String k2="select * from paid where userName='"+userName+"'";
                    PreparedStatement stm2=con1.prepareStatement(k2);
                    ResultSet  rs2 =stm2.executeQuery();
                    if(rs2.next())
                    {
                        flag=rs2.getInt(month+1);
                    }
                    con1.close();
            }
        catch(Exception ex)
        {
                    System.out.println(ex);
        }        
        if(flag==0)
        {
            paid="Not Paid";
        }
        else
        {
            paid="Paid";
        }
        JLabel paymentstatus=new JLabel(paid);
        paymentstatus.setBounds(150, 300, 100, 20);add(paymentstatus);
        if(flag==0)
        {
            paymentstatus.setForeground(Color.RED);
        }
        else
        {
            paymentstatus.setForeground(Color.GREEN);
        }
       
        
        onlinepay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                int flag=0;
               
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
                    String k2="select * from paid where userName='"+userName+"'";
                    PreparedStatement stm2=con1.prepareStatement(k2);
                    ResultSet  rs2 =stm2.executeQuery();
                    if(rs2.next())
                    {
                        flag=rs2.getInt(month+1);
                    }
                    con1.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                if(flag==1)
                {
                    JOptionPane.showMessageDialog(null, "Bill for this month was paid ");
                }
                else
                {
                    String email="";
                    try
                    {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
                        String k="select EmailId from ebProject where userName='"+userName+"'";
                        PreparedStatement stm=con.prepareStatement(k);
                        ResultSet  rs =stm.executeQuery();
                        if(rs.next()){
                          email=rs.getString(1);
                        }
                        new payment(email,userName,namel,consnum,receiptnumber);
                        dispose();
                        con.close();
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                }
            }
        });
        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new HomePage(userName);
                       dispose();
            }
        });
        download.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.out.println(paid);
                       new Bill_Generator(userName,price,paid);
                       JOptionPane.showMessageDialog(null, "Downloaded Successfully");
            }
        });
        run(ebName);
    }
     public void run(JLabel ebName) {
           ebName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
    }
    public static void main(String[] args) {
       
    }
}

