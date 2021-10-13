/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MonthlyUsage extends ApplicationFrame {
       String userName="";
    
   public MonthlyUsage(String userNam){ 
       
       super("Monthly Electricty Usage");
       this.userName=userNam;
       String chartTitle="Monthly Electricty Usage";
      
       JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Months","Units",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
     
         ChartPanel chartPanel = new ChartPanel( lineChart );
         chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
         setContentPane( chartPanel );
         pack( );
         RefineryUtilities.centerFrameOnScreen( this);
         setVisible( true );
      
   }
   
   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      int n1=0;
      try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lakshmi");
            String k="select * from units where userName='"+userName+"'";      //"+userName+"
            PreparedStatement stm=con.prepareStatement(k);
            ResultSet  rs =stm.executeQuery();
             if(rs.next()){
                 for(int i=2;i<=13;i++){
                    n1=rs.getInt(i);
                    if(n1==0)
                        break;
                    String s= String.valueOf(i-1);
                    dataset.addValue( n1,"units",s ); 
                 }
             }
            con.close();
        }catch(Exception ex){
            System.out.println(ex);
             }
      return dataset;
   }
  
   
   public static void main( String[ ] args ) {
   }
}
