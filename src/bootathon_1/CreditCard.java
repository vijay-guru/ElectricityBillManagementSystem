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
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CreditCard extends JFrame {
   
    public CreditCard(String to,String userName,String namel,String consnum,long receiptnumber){
       
        setBounds(520,300,500,365);  
        setLayout(null);  
        setVisible(true);
        setTitle(" Credit Card Payment ");
        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");
        setIconImage(icon);
       
        JLabel cc=new JLabel("Via Credit Card");
        JLabel ccno,expirydate,ccv,name;
        JLabel line1=new JLabel("______________________________________________________________________________________________________________");
        JLabel line2=new JLabel("______________________________________________________________________________________________________________");
        JButton back=new JButton("Back");
        JButton pay=new JButton("Pay");
        JTextField ccno1,expirydate1,ccv1,name1;
       
        ccno=new JLabel("Card Number : ");
        expirydate=new JLabel("Expiry Date : ");
        ccv=new JLabel("CCV : ");
        name=new JLabel("Enter Card Holder Name : ");
        ccno1=new JTextField();
        expirydate1=new JTextField();
        ccv1=new JTextField();
        name1=new JTextField();
       
        cc.setBounds(170, 20, 250, 27);add(cc);
        line1.setBounds(1, 40, 500, 20);
        line2.setBounds(1, 250, 500, 20);
        back.setBounds(360,285,70,20);
        ccno.setBounds(30,90,120,20);add(ccno);
        expirydate.setBounds(30,130,80,20);add(expirydate);
        ccv.setBounds(310,130,50,20);add(ccv);
        name.setBounds(30,170,150,20);add(name);
        pay.setBounds(200,215,70,20);
        ccno1.setBounds(125,90,190,20);add(ccno1);
        expirydate1.setBounds(115,130,170,20);add(expirydate1);
        ccv1.setBounds(350,130,70,20);add(ccv1);
        name1.setBounds(180,170,190,20);add(name1);
       
        cc.setFont(new Font("Italic", Font.BOLD, 18));
       
        add(line1);add(line2);add(back);add(pay);
       
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new payment(to,userName,namel,consnum,receiptnumber);
                dispose();
            }
        });
        pay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String regexCardNumber,regexCvv,regexDate,regexEmail;
                regexCardNumber=ccno1.getText();
                regexCvv=ccv1.getText();
                regexDate=expirydate1.getText();
                regexEmail=name1.getText();
                String z="";
                if(regexCardNumber.equals(z)  || regexCvv.equals(z) || regexDate.equals(z) || regexEmail.equals(z)){
                    JOptionPane.showMessageDialog(null,"Fill all the details","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[0-9]{16}",regexCardNumber)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid Card Number","Error",JOptionPane.WARNING_MESSAGE);
                }
                 else if(Pattern.matches("^[0-9]{3,4}$",regexCvv)==false)
                {
                    JOptionPane.showMessageDialog(null,"Invalid CVV number","Error",JOptionPane.WARNING_MESSAGE);
                }
                 else if(Pattern.matches("(0[1-9]|1[0-2])\\/?(([0-9]{4})|[0-9]{2}$)",regexDate)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid date","Error",JOptionPane.WARNING_MESSAGE);
                }
                 else{
                ThreadLocalRandom random = ThreadLocalRandom.current();
                long rand = random.nextLong(100000, 999999);
                System.out.println(rand);
                new Otp(to,userName,rand);
                //new Password(rand,userName);
            }
            }
        });
    }
    public static void main(String[] args) {
       
    }
}

