/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.swing.*;
public class View_Updation_Form extends JFrame{
    JLabel name,Title1,Title,First_name,Last_name,Contact_No,Email_id,Phase,State,District,Taluk,City,House_No,Street_name,pincode;
    JTextField T_First_name,T_Last_name,T_Contact_No,T_Email_id,T_Taluk,T_city,T_house_No,T_Street_name,T_pincode;
    JComboBox C_phase,C_state,C_District;
    JButton update,go_back,Password;
View_Updation_Form(String username)
{
   
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

    Title=new JLabel("Updation Form");
    Title1=new JLabel("Krishna Electricity Generating and Distribution corporation");
    First_name=new JLabel("First Name");
    Last_name=new JLabel("Last Name");
    Contact_No=new JLabel("Contact No");
    Email_id=new JLabel("Email Id");
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

    C_phase=new JComboBox(phase);
    C_state=new JComboBox(state);
    C_District=new JComboBox(district);
    T_Taluk=new JTextField();
    T_city=new JTextField();
    T_house_No=new JTextField();
    T_Street_name=new JTextField();
    T_pincode=new JTextField();
    Password=new JButton("Change Password");
    update=new JButton("Update");
    go_back=new JButton("Go Back");

    setTitle("Updation Form");
    setLocation(150, 150);
    setBounds(220,120,750,550);
        //getContentPane().setBackground(Color.white);
    setLayout(null);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    String str=username;
    name = new JLabel("Hi  "+str+"!!");
    name.setFont(new Font("Arial",Font.BOLD,18));
    name.setBounds(85,105,260,30);
    add(name);
       
    Title1.setBounds(180,30,420,30);
    add(Title1);
    run(Title1);
    Title1.setFont(new Font("Arial", Font.BOLD, 15));
    Title.setBounds(330,70,200,20);
    add(Title);
    Title.setFont(new Font("Arial", Font.BOLD, 15));


    First_name.setBounds(85,150,70,20);add(First_name);
    T_First_name.setBounds(195,150,150,20);add(T_First_name);

    Last_name.setBounds(85,190,70,20);add(Last_name);
    T_Last_name.setBounds(195,190,150,20);add(T_Last_name);

    Contact_No.setBounds(85,230,70,20);add(Contact_No);
    T_Contact_No.setBounds(195,230,150,20);add(T_Contact_No);

    Email_id.setBounds(85,270,70,20);add(Email_id);
    T_Email_id.setBounds(195,270,150,20);add(T_Email_id);

    Phase.setBounds(85,310,70,20);add(Phase);
    C_phase.setBounds(195,310,150,20);add(C_phase);

    State.setBounds(85,350,70,20);add(State);
    C_state.setBounds(195,350,150,20);add(C_state);

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

    Password.setBounds(150,440,150,30);add(Password);
   
    update.setBounds(330,440,100,30);add(update);
   
    go_back.setBounds(450,440,100,30);add(go_back);
    setValues(username);
    String copy = "<html>" + " Copyright © 2021. Krishna Electricity Generation and Distribution Corporation Limited"+"</html>";
    JLabel copy_right = new JLabel(copy);
    copy_right.setBounds(150,480,500,30);
    copy_right.setFont(new Font("Arial", Font.PLAIN, 12));
    add(copy_right);
     
    update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String F_name,L_name,c_no,mail,taluk,city,h_no,Street,pincode,state,phase,district;
                F_name=T_First_name.getText();
                L_name=T_Last_name.getText();
                c_no=T_Contact_No.getText();
                mail=T_Email_id.getText();
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
                        String query="update ebProject set FirstName='"+F_name+"',LastName='"+L_name+"',ContactNo='"+c_no+"',EmailId='"+mail+"',Phase='"+phase+"',State='"+state+"',District='"+district+"',Taluk='"+taluk+"',City='"+city+"',HouseNo='"+h_no+"',StreetName='"+Street+"',pincode='"+pincode+"' where userName='"+username+"'";
                        PreparedStatement pst=con.prepareStatement(query);
                        pst.executeUpdate();
                        con.setAutoCommit(true);
                        con.close();
                        JOptionPane.showMessageDialog(null,"Update Successful");
                    } catch (SQLException ex) {
                        Logger.getLogger(View_Updation_Form.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(View_Updation_Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
               
            }
   });
   Password.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
        new Change_Password(username);
        dispose();
        }
    });
    go_back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
        //Homepage Connection
        new HomePage(username);
        dispose();
        }
    });
           
}
    public void setValues(String username)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmi");
            String query="select * from ebProject where userName='"+username+"' ";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
            String s = rs.getString(1);
            String s1 = rs.getString(2);
            String s2 = rs.getString(3);
            String s3 = rs.getString(4);
            String s4 = rs.getString(5);
            String s5 = rs.getString(6);
            String s6 = rs.getString(7);
            String s7 = rs.getString(8);
            String s8 = rs.getString(9);
            String s9 = rs.getString(10);
            String s10 = rs.getString(11);
            String s11 = rs.getString(12);
            String s12= rs.getString(13);
            String s13 = rs.getString(14);
            //Sets Records in TextFields.
            T_First_name.setText(s);
            T_Last_name.setText(s1);
            T_Contact_No.setText(s2);
            T_Email_id.setText(s3);
            T_Taluk.setText(s9);
            T_city.setText(s10);
            T_house_No.setText(s11);
            T_Street_name.setText(s12);
            T_pincode.setText(s13);
            C_phase.setSelectedItem(s6);
            C_state.setSelectedItem(s7);
            C_District.setSelectedItem(s8);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public void run(JLabel Name) {
        Name.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
    }
    public static void main(String agrs[])
    {
       
    }

}

 