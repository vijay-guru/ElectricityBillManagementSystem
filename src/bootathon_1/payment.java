/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class payment extends JFrame{
   
    public payment(String email,String userName,String namel,String consnum,long receiptnumber){
       
        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");
        setIconImage(icon);
        setBounds(520,300,470,240);  
        setLayout(null);  
        setVisible(true);
        setTitle(" PAYMENT ");
       
        JLabel select =new JLabel("Select payment method");
        JButton cc=new JButton("Pay via Credit Card");
        JButton dc=new JButton("Pay via Debit Card");
        JButton back=new JButton("Back");
       
        select.setBounds(133,20,220,25);add(select);
        back.setBounds(300,170,90,20);add(back);
        cc.setBounds(40,60,350,30);add(cc);
        dc.setBounds(40,122,350,30);add(dc);
       
        select.setFont(new Font("Verdana", Font.BOLD, 14));
         
         
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new GenerateBill(userName,namel,consnum,receiptnumber);
                       dispose();
            }
        });
        cc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                      new CreditCard(email,userName,namel,consnum,receiptnumber);
                       dispose();
            }
        });
       
        dc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new DebitCard(email,userName,namel,consnum,receiptnumber);
                       dispose();
            }
        });
    }
    public static void main(String[] args) {
       
    }
}
