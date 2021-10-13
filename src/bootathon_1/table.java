/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;

public class table extends JFrame{
    JFrame f;
    table(){
       
        JLabel title = new JLabel("Region Code");
        title.setBounds(300,10,150,30);
        title.setFont(new Font("Verdana", Font.BOLD, 20));
       
        String s1 = "<html>" + "Thiruvotriyur, Manali, Madhavaram, Tondiyarpet, Royapuram, Thiru Vi-Ka Nagar, Teynampet, Ambattur Zones and part of Tiruvallur Dist" + "</html>";
        String s2 = "<html>" + "Ambattur, Anna Nagar, Kodambakkam, Valasaravakkam, Alandur, Adyar, Perungudi, Sholinganallur Zones, Chengalpattu Dist, Part of Kanchipuram and Tiruvallur Dist" + "</html>";
        String s3 = "<html>" + "Ariyalur, Karur, Mayiladuthurai, Nagapattinam, Perambalur,Pudukottal, Thanjavur, Thiruvarur, Tiruchirapalli" + "</html>";
        String s4 = "<html>" + "Dharmapuri, Krishnagiri, Tirupathur, Ranipet, Vellore, Kanchipuram and part of Tiruvallur Dist" + "</html>";
        DefaultTableCellRenderer cellRenderer;
        String data[][]={ {"01","Chennai North",s1},    
                          {"09","Chennai South",s2},    
                          {"03","Coimbatore","Coimbatore, Tiruppur, Nilgiris"},
                          {"04","Erode","Erode, Namakkal, Salem"},
                          {"05","Madurai","Madurai, Dindigul, Ramanathapuram, Sivagangal, Theni"},
                          {"06","Trichy",s3},
                          {"07","Tirunelveli","Kanniyaumari, Thoothukudi, Tirunelveli, Tenkasi, Virudhunagar"},
                          {"08","Vellore",s4},
                          {"02","Villupuram","Cuddalore, Kallakurichi, Tiruvannalamai, Villupuram"}
                        };    
        String column[]={"Region Code","Region Name","District/Zone"};        
        JTable jt=new JTable(data,column);    
        jt.setBounds(30,40,200,300);          
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jt);
        scrollPane.setBounds(36, 50, 680, 305);
       
        jt.setRowHeight(0, 50);
        jt.setRowHeight(1, 50);
        jt.setRowHeight(5, 50);
        jt.setRowHeight(7, 50);
        jt.getColumnModel().getColumn(0).setPreferredWidth(10);
        jt.getColumnModel().getColumn(1).setPreferredWidth(50);
        jt.getColumnModel().getColumn(2).setPreferredWidth(410);
        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
       
        JButton b1=new JButton("OK");  
        b1.setBounds(580,370,100,30);
       
        add(scrollPane);
        add(b1);add(title);
        setBounds(400,200,750,450);    
        setLayout(null);  
        setVisible(true);
         b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
          
            }
        });
    }
   
    public static void main(String []args){
        new table();
    }
}

