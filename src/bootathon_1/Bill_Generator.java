/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.io.File;  
import java.io.FileOutputStream;  
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.io.FileNotFoundException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;  
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;  
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;  
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

public class Bill_Generator
{  
    float unit;
    int consNo;
    String fName,lName;
    public void setValues(String username,float money)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lakshmi");
            String query="select consumerno from consumerNo where userName=?";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rst=pst.executeQuery();
            if(rst.next())
            consNo=rst.getInt("consumerno");
           
            String query1="select FirstName,LastName from ebProject where username=?";
            PreparedStatement pst1=con.prepareStatement(query1);
            pst1.setString(1, username);
            ResultSet rst1=pst1.executeQuery();
            if(rst1.next())
            fName=rst1.getString("FirstName");
            lName=rst1.getString("LastName");
            //get price and unit from db
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public Bill_Generator(String username,float money,String paid)
    {  
        setValues(username,money);
        XWPFDocument document= new XWPFDocument();  
        try(FileOutputStream out = new FileOutputStream(new File("D:\\EbBill"+username+".docx")))
        {
            XWPFParagraph para = document.createParagraph();
            para.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun xwpfrun = para.createRun();
            xwpfrun.setText("Electricity Bill");
            xwpfrun.setFontSize(18);
            XWPFParagraph para2 = document.createParagraph();
            para2.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun xwpfrun2=para2.createRun();
            xwpfrun2.setText("Name: "+fName+" "+lName);
            xwpfrun2.addCarriageReturn();
            xwpfrun2.setText("Consumer No: "+consNo);
            xwpfrun2.addCarriageReturn();
            xwpfrun2.setText("Payment Status: "+paid);
            xwpfrun2.setFontSize(12);
           
            XWPFTable tab = document.createTable();  
            XWPFTableRow row = tab.getRow(0);
            row.getCell(0).setText("");
            row.addNewTableCell().setText("");
            row.addNewTableCell().setText("");  
           
            row = tab.createRow(); // Second Row  
            row.getCell(0).setText("1.");  
            row.getCell(1).setText("Price");  
            row.getCell(2).setText(String.valueOf(money));  
           
            float gst=money/100;
            row = tab.createRow(); // Third Row  
            row.getCell(0).setText("2.");  
            row.getCell(1).setText("GST");  
            row.getCell(2).setText(String.valueOf(gst));
           
            row = tab.createRow(); // Third Row  
           
            row.getCell(1).setText("Net Price");  
            row.getCell(2).setText(String.valueOf(money+gst));
           
            XWPFTableCell cell = tab.getRow(0).getCell(0);
            XWPFParagraph tempParagraph = cell.getParagraphs().get(0);
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun = tempParagraph.createRun();
            tempRun.setText("S.NO");
            tempRun.setBold(true);
            tempRun.setFontSize(14);
            cell.setVerticalAlignment(XWPFVertAlign.CENTER);
           
            XWPFTableCell cell2 = tab.getRow(0).getCell(1);
            XWPFParagraph tempParagraph2 = cell2.getParagraphs().get(0);
            tempParagraph2.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun1 = tempParagraph2.createRun();
            tempRun1.setText("Charges Details");
            tempRun1.setBold(true);
            tempRun1.setFontSize(14);
            cell2.setVerticalAlignment(XWPFVertAlign.CENTER);
           
            XWPFTableCell cell3 = tab.getRow(0).getCell(2);
            XWPFParagraph tempParagraph3 = cell3.getParagraphs().get(0);
            tempParagraph3.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun2 = tempParagraph3.createRun();
            tempRun2.setText("Amount");
            tempRun2.setBold(true);
            tempRun2.setFontSize(14);
            cell3.setVerticalAlignment(XWPFVertAlign.CENTER);
           
            CTTbl table        = tab.getCTTbl();
            CTTblPr pr         = table.getTblPr();
            CTTblWidth  tblW = pr.getTblW();
            tblW.setW(BigInteger.valueOf(5000));
            tblW.setType(STTblWidth.PCT);
            pr.setTblW(tblW);
            table.setTblPr(pr);
            CTJc jc = pr.addNewJc();        
            jc.setVal(STJc.RIGHT);
            pr.setJc(jc);
           
            XWPFParagraph para3 = document.createParagraph();
            XWPFRun xwpfrun3 = para3.createRun();
            xwpfrun3.setText("Signature         ");
            xwpfrun3.setFontSize(12);
            para3.setAlignment(ParagraphAlignment.RIGHT);
           
            XWPFParagraph para4 = document.createParagraph();
            XWPFRun xwpfrun4 = para4.createRun();
            xwpfrun4.setText("Date :        "+LocalDate.now());
            xwpfrun4.setFontSize(12);
            para4.setAlignment(ParagraphAlignment.LEFT);
           
            XWPFParagraph para5 = document.createParagraph();
            XWPFRun xwpfrun5 = para5.createRun();
            xwpfrun5.setText("Time :        "+LocalTime.now());
            xwpfrun5.setFontSize(12);
            para5.setAlignment(ParagraphAlignment.LEFT);
           
            document.write(out);  
           
        }
        catch(FileNotFoundException fe)
        {  
            JOptionPane.showMessageDialog(null, "Please close the bill and try again");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
    public static void main(String s[])
    {
       
    }
}






