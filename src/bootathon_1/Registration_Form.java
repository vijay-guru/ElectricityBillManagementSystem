/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.*;
import javax.swing.*;
public class Registration_Form extends JFrame{

    Registration_Form()
    {
        JLabel Title1,Title,First_name,Last_name,Contact_No,Email_id,username,Password,Confirm_password,Phase,State,District,Taluk,City,House_No,Street_name,pincode;
        JTextField T_First_name,T_Last_name,T_Contact_No,T_Email_id,T_username,T_Password,T_Confirm_password,T_Taluk,T_city,T_house_No,T_Street_name,T_pincode;
        JComboBox C_phase,C_state,C_District;
        JButton register,go_back;
        String phase[]={"1 phase","3 phase"};
        String state[]={"Tamil Nadu"};
        String district[]={"Ariyalur",
        "Chengalpattu",
        "Chennai",
        "Coimbatore",
        "Cuddalore",
        "Dharmapuri",
        "Dindigul",
        "Erode",
        "Kallakurichi",
        "Kanchipuram",
        "Kanyakumari",
        "Karur",
        "Krishnagiri",
        "Madurai",
        "Nagapattinam",
        "Namakkal",
        "Nilgiris",
        "Perambalur",
        "Pudukkottai",
        "Ramanathapuram",
        "Ranipet",
        "Salem",
        "Sivaganga",
        "Tenkasi",
        "Thanjavur",
        "Theni",
        "Thoothukudi (Tuticorin)",
        "Tiruchirappalli",
        "Tirunelveli",
        "Tirupathur",
        "Tiruppur",
        "Tiruvallur",
        "Tiruvannamalai",
        "Tiruvarur",
        "Vellore",
        "Viluppuram",
        "Virudhunagar"};
        Title=new JLabel("Registration Form");
        Title1=new JLabel("Krishna Electricity Generating and Distribution corporation");
        First_name=new JLabel("First Name");
        Last_name=new JLabel("Last Name");
        Contact_No=new JLabel("Contact No");
        Email_id=new JLabel("Email Id");
        username=new JLabel("Username");
        Password=new JLabel("Password");
        Confirm_password=new JLabel("Confirm Password");
        Phase=new JLabel("Phase");
        State=new JLabel("State");
        District=new JLabel("District");
        Taluk=new JLabel("Taluk");
        City=new JLabel("City");
        House_No=new JLabel("House No");
        Street_name=new JLabel("Street Name");
        pincode=new JLabel("Pincode");

        T_First_name=new JTextField();
        T_Last_name=new JTextField();
        T_Contact_No=new JTextField();
        T_Email_id=new JTextField();
        T_username=new JTextField();
        T_Password=new JTextField();
        T_Confirm_password=new JTextField();
        C_phase=new JComboBox(phase);
        C_state=new JComboBox(state);
        C_District=new JComboBox(district);
        T_Taluk=new JTextField();
        T_city=new JTextField();
        T_house_No=new JTextField();
        T_Street_name=new JTextField();
        T_pincode=new JTextField();

        register=new JButton("Register");
        go_back=new JButton("Go Back");
        go_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login_Form();
            }
        });

        setTitle("Registration Form");
                setBounds(200,70,750,550);
                setLocation(420, 100);
               // getContentPane().setBackground(Color.white);
                setLayout(null);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        Title1.setBounds(180,30,450,30);
        add(Title1);
        run(Title1);
        Title1.setFont(new Font("Arial", Font.BOLD, 15));
        Title.setBounds(330,70,200,20);
        add(Title);
        Title.setFont(new Font("Arial", Font.BOLD, 15));

        First_name.setBounds(85,110,70,20);add(First_name);
        T_First_name.setBounds(195,110,150,20);add(T_First_name);

        Last_name.setBounds(85,150,70,20);add(Last_name);
        T_Last_name.setBounds(195,150,150,20);add(T_Last_name);

        Contact_No.setBounds(85,190,70,20);add(Contact_No);
        T_Contact_No.setBounds(195,190,150,20);add(T_Contact_No);

        Email_id.setBounds(85,230,70,20);add(Email_id);
        T_Email_id.setBounds(195,230,150,20);add(T_Email_id);

        username.setBounds(85,270,70,20);add(username);
        T_username.setBounds(195,270,150,20);add(T_username);

        Password.setBounds(85,310,70,20);add(Password);
        T_Password.setBounds(195,310,150,20);add(T_Password);

        Confirm_password.setBounds(85,350,150,20);add(Confirm_password);
        T_Confirm_password.setBounds(195,350,150,20);add(T_Confirm_password);

        Phase.setBounds(85,390,70,20);add(Phase);
        C_phase.setBounds(195,390,150,20);add(C_phase);

        State.setBounds(450,110,70,20);add(State);
        C_state.setBounds(530,110,150,20);add(C_state);

        District.setBounds(450,150,70,20);add(District);
        C_District.setBounds(530,150,150,20);add(C_District);

        City.setBounds(450,190,70,20);add(City);
        T_city.setBounds(530,190,150,20);add(T_city);

        Taluk.setBounds(450,230,70,20);add(Taluk);
        T_Taluk.setBounds(530,230,150,20);add(T_Taluk);

        House_No.setBounds(450,270,70,20);add(House_No);
        T_house_No.setBounds(530,270,150,20);add(T_house_No);

        Street_name.setBounds(450,310,90,20);add(Street_name);
        T_Street_name.setBounds(530,310,150,20);add(T_Street_name);

        pincode.setBounds(450,350,70,20);add(pincode);
        T_pincode.setBounds(530,350,150,20);add(T_pincode);

        register.setBounds(290,440,100,30);add(register);
        go_back.setBounds(400,440,100,30);add(go_back);

        String copy = "<html>" + " Copyright © 2021. Krishna Electricity Generation and Distribution Corporation Limited"+"</html>";
        JLabel copy_right = new JLabel(copy);
        copy_right.setBounds(150,480,500,30);
        copy_right.setFont(new Font("Arial", Font.PLAIN, 12));
        add(copy_right);

        register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String F_name,L_name,c_no,mail,user_name,password,c_password,taluk,city,h_no,Street,pincode,state,phase,district;
                F_name=T_First_name.getText();
                L_name=T_Last_name.getText();
                c_no=T_Contact_No.getText();
                mail=T_Email_id.getText();
                user_name=T_username.getText();
                password=T_Password.getText();
                c_password=T_Confirm_password.getText();
                taluk=T_Taluk.getText();
                city=T_city.getText();
                h_no=T_house_No.getText();
                Street=T_Street_name.getText();
                pincode=T_pincode.getText();
                state=(String)C_state.getItemAt(C_state.getSelectedIndex());
                phase=(String)C_phase.getItemAt(C_phase.getSelectedIndex());
                district=(String)C_District.getItemAt(C_District.getSelectedIndex());
                if(Pattern.matches("[A-Z][a-zA-Z]*",F_name)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid First name(First Letter should be capital Letter)","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[a-zA-z]+([ '-][a-zA-Z]+)*",L_name)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid last name","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[0-9]{10}", c_no)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid Mobile Number","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[a-zA-Z0-9]*[@][a-z]*[.][a-z.]*", mail)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid mail","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[a-zA-z]{1}[a-z0-9]{0,9}+", user_name)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid username","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[a-zA-Z]{1}[a-zA-Z0-9!@#$%]*", password)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid Password","Error",JOptionPane.WARNING_MESSAGE);
                }  
                else if(Pattern.matches(password, c_password)==false)
                {
                JOptionPane.showMessageDialog(null,"Password mismatch","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[a-zA-z]+([ '-][a-zA-Z]+)*",city)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid city","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[a-zA-z]+([ '-][a-zA-Z]+)*",taluk)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid taluk","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("^[0-9](.*[0-9])?$",h_no)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid House no ","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[a-zA-z]+([ '-][a-zA-Z]+)*",Street)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid street","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(Pattern.matches("[0-9]{6}", pincode)==false)
                {
                    JOptionPane.showMessageDialog(null,"Enter valid Pincode","Error",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    try
                    {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmi");
                        String query_3="select * from ebProject where userName='"+user_name+"'";
                        PreparedStatement pst_3=con.prepareStatement(query_3);
                        ResultSet rs =pst_3.executeQuery();
                        boolean s=rs.next();
                        if(s){
                              JOptionPane.showMessageDialog(null,"UserName Already Exists");
                        }
                        else{
                       
                            String query="insert into ebProject values('"+F_name+"','"+L_name+"','"+c_no+"','"+mail+"','"+user_name+"','"+password+"','"+phase+"','"+state+"','"+district+"','"+taluk+"','"+city+"','"+h_no+"','"+Street+"','"+pincode+"')";
                            PreparedStatement pst=con.prepareStatement(query);
                            pst.executeUpdate();
                            con.setAutoCommit(true);
                            ThreadLocalRandom random = ThreadLocalRandom.current();
                            long rand = random.nextLong(100000000, 999999999);
                            String consumerno= String.valueOf(rand);
                            query="insert into consNo values('"+user_name+"','"+consumerno+"')";
                            pst=con.prepareStatement(query);
                            pst.executeUpdate();
                            con.setAutoCommit(true);
                            query="insert into units values('"+user_name+"',100,190,300,200,450,690,820,475,0,0,0,0)";
                            pst=con.prepareStatement(query);
                            pst.executeUpdate();
                            con.setAutoCommit(true);
                            query="insert into paid values('"+user_name+"',1,1,1,1,1,1,1,1,0,0,0,0)";
                            pst=con.prepareStatement(query);
                            pst.executeUpdate();
                            con.setAutoCommit(true);
                            con.close();
                            JOptionPane.showMessageDialog(null,"Registered Successfully");
                            dispose();
                            new Login_Form();
                       
                        }
                    }
                    catch(Exception ee)
                    {
                        System.out.println(ee);
                    }
                   
                }
               
            }
        });
           
    }
    public void run(JLabel Name) {
            Name.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
    }
    public static void main(String agrs[])
    {
        new Registration_Form();
    }

}
