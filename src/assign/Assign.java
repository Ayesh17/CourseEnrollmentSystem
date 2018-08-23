/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Ayesh
 */
public class Assign {
//"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998""1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Login log=new Login();
        log.setVisible(true);
        
      
        //createTable();
    }
    
  /*public static void createTable() throws Exception{
    try{
        Connection con=getConnection();
        PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS UndergraduateRegister1(Id int,Name varchar(255),DOB varchar(255),Address varchar(255),ALResults varchar(255) ,Rank  int,PRIMARY KEY(Id)");
        create.executeUpdate();                                
        PreparedStatement created=con.prepareStatement("CREATE TABLE IF NOT EXISTS PostgraduateRegister1(Id int,Name varchar(255),DOB varchar(255),Address varchar(255),UndergraduateDegree varchar(255) ,University varchar(255),year int,PRIMARY KEY(Id)");
        created.executeUpdate();
    }catch(Exception ex){
        System.out.println("Created table");
    }finally{ 
        System.out.println("Table created");
     }
    
}
    
    public static Connection getConnection() throws Exception{
        try{
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/db";
                String username="root";
                String password="";
                Class.forName(driver);
                        
                Connection con=DriverManager.getConnection(url, username, password);
                System.out.println("Yup connected");
                return con;
        }
        
        catch(Exception e){
            System.out.println("Exception occured");
        }
        
        return null;
    }*/
    
    
}
