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
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ContactUs extends JFrame {
    
    public ContactUs(String username){
        setBounds(520,220,426,434);  
        setLayout(null);  
        setVisible(true);
        setTitle(" Contact Us ");
        Image icon=Toolkit.getDefaultToolkit().getImage("D:\\icon.png");
        setIconImage(icon);
        
        JLabel from,subject,text,heading;
        JTextField frm,sub;
        JTextArea msg;
        JButton send,back;
        
        heading=new JLabel("   Reach Us ");
        from=new JLabel("From");
        subject=new JLabel("Subject");
        text=new JLabel("Message :");
        frm=new JTextField();
        sub=new JTextField();
        send=new JButton("Send");
        back=new JButton("Back");
        msg=new JTextArea();
        
        heading.setBounds(167,23,100,25);add(heading);
        from.setBounds(22,54,70,25);add(from);
        subject.setBounds(22,105,70,25);add(subject);
        text.setBounds(22,165,90,25);add(text);
        frm.setBounds(22,82,370,25);add(frm);
        sub.setBounds(22,135,370,25);add(sub);
        msg.setBounds(22, 195, 370, 130);add(msg);
        send.setBounds(130,360,80,20);add(send);
        back.setBounds(215,360,80,20);add(back);
        
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                       new HomePage(username);
                       dispose();
            }
        });
        send.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                    String s1=frm.getText();
                    String s2=sub.getText();
                    String s3=msg.getText();
                    new Otp(s1,s2,s3);
            }
        });
        heading.setFont(new Font("Ariel", Font.BOLD, 16));
        from.setFont(new Font("Verdana", Font.BOLD, 14));
        subject.setFont(new Font("Verdana", Font.BOLD, 14));
        text.setFont(new Font("Verdana", Font.BOLD, 14));
        run(heading);
    }
     public void run(JLabel Name) {
             Name.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE));
    }
    public static void main(String[] args) {
        new ContactUs("vjguru");
    }
    
}

