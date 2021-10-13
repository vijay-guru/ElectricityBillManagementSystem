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


public class HomePage extends JFrame{
    public HomePage(String loginuser){
        
        setBounds(400,200,750,420);  
        setLayout(null);  
        setVisible(true);
        setTitle(" Home Page ");
        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");
        setIconImage(icon);
        
        JLabel ebName=new JLabel("Krishna Electricity Generating and Distribution Corporation");
        JLabel kind=new JLabel("KIND ATTENTION TO ELECTRICTY CONSUMERS");
        JLabel pt1=new JLabel("==> For KGEDCO transactions done through BBPS (Bharath Bill Payment System), please raise complaints using");
        JLabel pt2=new JLabel("COMPLAINT menu in the respective bank's Internet Banking System in BBPS menu or contact the collecting");
        JLabel pt3=new JLabel("agent using CONTACT menu above.");
        JLabel pt4=new JLabel("==> Make payment of LT Electricity Bills only through KGEDCO Section Office Counters/E-seva centers of GOTN/");
        JLabel pt5=new JLabel("Post Offices/Bank Counters of City Union Bank(CUB), Lakshmi Vilas Bank (LVB) and Tamilnad Mercantile Bank (TMB),");
        JLabel pt6=new JLabel("Indian Bank(INB),ATM of TMB,Federal Bank and through the KGEDCO's official website www.kgedco.org.");
        JLabel pt7=new JLabel("==> Consumers are advised not to make payments through any other unauthorised agents/mobile apps/Websites so as to");
        JLabel pt8=new JLabel(" avoid disconnection of electricity supply for non-payment of EB Bills.");
        JLabel line1=new JLabel("____________________________________________________________________________________________________________________________");
        JLabel line2=new JLabel("____________________________________________________________________________________________________________________________");
        JLabel cpy=new JLabel("© 2021.Krishna Electricity Generating and Distribution Corporation");
        JButton view,vmonthusage,qpay,contact;
        JButton logout=new JButton("Logout");
        view=new JButton("View Details");
        vmonthusage=new JButton("Monthly Usage");
        qpay=new JButton("Quick Pay");
        contact=new JButton("Contact Us");
        
        ebName.setBounds(120, 20, 520, 27);add(ebName);
        view.setBounds(30, 63, 170, 27);add(view);
        vmonthusage.setBounds(200, 63, 170, 27);add(vmonthusage);
        qpay.setBounds(370, 63, 170, 27);add(qpay);
        contact.setBounds(540, 63, 170, 27);add(contact);
        kind.setBounds(200,110,370,27);add(kind);
        pt1.setBounds(25,140,700,20);add(pt1);
        pt2.setBounds(49,155,700,20);add(pt2);
        pt3.setBounds(49,170,700,20);add(pt3);
        pt4.setBounds(25,200,700,20);add(pt4);
        pt5.setBounds(49,215,700,20);add(pt5);
        pt6.setBounds(49,230,700,20);add(pt6);
        pt7.setBounds(25,260,700,20);add(pt7);
        pt8.setBounds(49,275,700,20);add(pt8);
        line1.setBounds(1, 287, 800, 20);add(line1);
        line2.setBounds(1, 92, 800, 20);add(line2);
        logout.setBounds(320, 315, 80, 25);add(logout);
        cpy.setBounds(180, 350, 500, 12);add(cpy);
        
        kind.setFont(new Font("Verdana", Font.BOLD, 13));
        ebName.setFont(new Font("Verdana", Font.BOLD, 15));
        run(ebName);
        
        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new View_Updation_Form(loginuser);
                       dispose();
                       
            }
            
        });
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new Login_Form();
                       dispose();
                       
            }
            
        });
        qpay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new loggedIn(loginuser);
                       dispose();
                       
            }
        });
        
        contact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new ContactUs(loginuser);
                       dispose();
                       
            }
            
        });
        
        vmonthusage.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new MonthlyUsage(loginuser);
            }
        });
}
    public void run(JLabel ebName) {
    ebName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
    }
    public static void main(String[] args) {
        
    }
}
