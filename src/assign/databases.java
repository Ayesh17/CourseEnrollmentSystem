/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayesh
 */
public class databases {
    
                //String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/assign";
                String username="root";
                String password="";
               // Class.forName(driver);
               Connection con=null;
                PreparedStatement pst=null;
                PreparedStatement pst2=null;
                PreparedStatement pst3=null;
                PreparedStatement pstq=null;
                ResultSet rs=null;
                int UserId;
                
    boolean addUndergraduateStudent(UndergraduateStudent sd){
                    
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password); //get the connection
                        String query1="INSERT INTO  user(UserId,Name,DateOfBirth,Address,email) VALUES(?,?,?,?,?)";
                        String query2="INSERT INTO  undergraduateregister(UndergraduateId,Rank,CourseCode,UserId,intake) VALUES(?,?,?,?,?)";
                        String query3="INSERT INTO  alresults(StudentId,ALSubject1Name,ALSubject1Result,ALSubject2Name,ALSubject2Result,ALSubject3Name,ALSubject3Result,ALSubject4Name,ALSubject4Result) VALUES(?,?,?,?,?,?,?,?,?)";
                        
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                        
                         pst.setInt(1, sd.getUserId());
                        pst.setString(2, sd.getName());                  //add values to the sql querry
                        pst.setString(3, sd.getDateOfBirth());      //add values to the sql querry
                        pst.setString(4, sd.getAddress());            //add values to the sql querry
                        pst.setString(5,sd.getEmail());            //add values to the sql querry
                        
                        pst.executeUpdate();              //execute the sql querry and insert the values to the db table
                        ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        
                        
                        pst2.setString(1, sd.getUndergraduateId());         //add values to the sql querry
                        //pst2.setString(2, sd.getALResults());         //add values to the sql querry                      
                        pst2.setInt(2, sd.getRank());                     //add values to the sql querry
                        pst2.setInt(3,sd.getCourseCode());         //add values to the sql querry
                       pst2.setInt(4,id);    
                       pst2.setString(5, sd.getIntake());
                           
                        pst2.executeUpdate();
                       
                        pst3.setString(1, sd.getUndergraduateId());         //add values to the sql querry
                        pst3.setString(2, sd.getSubject1Name());         //add values to the sql querry
                        pst3.setString(3, sd.getSubject1Result());         //add values to the sql querry
                        pst3.setString(4, sd.getSubject2Name());         //add values to the sql querry
                        pst3.setString(5, sd.getSubject2Result());         //add values to the sql querry
                        pst3.setString(6, sd.getSubject3Name());         //add values to the sql querry
                        pst3.setString(7, sd.getSubject3Result());         //add values to the sql querry
                        pst3.setString(8, sd.getSubject4Name());         //add values to the sql querry
                        pst3.setString(9, sd.getSubject4Result());         //add values to the sql querry
                        
                        pst3.executeUpdate();
                        
                        return true;
                        
                    } catch (Exception ex) {
                         System.out.println(ex);   
                         return false;
                         
                    }finally{                                     //release the resources which we used
                        try {
                            if(pst != null){                           
                                    pst.close();             //if not closed closing the prepared Statement
                                } 

                            if(con != null){
                                con.close();                //if not closed closing the connection
                            }

                            }catch (Exception ex) {                             
                              }
                    }
                    
    }
    
       boolean searchUndergraduateStudent(UndergraduateStudent sd1){
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query2="SELECT * FROM undergraduateregister WHERE undergraduateId= "+sd1.getUndergraduateId();
                         pst2=(PreparedStatement)con.prepareStatement(query2);
                        
                          ResultSet rs2 = pst2.executeQuery();
                        if(rs2.next()){
                            String undergraduateId = rs2.getString("UndergraduateId");
                            int rank=rs2.getInt("Rank");
                            int courseCode=rs2.getInt("CourseCode");
                            int userId=rs2.getInt("userId");

                            sd1.setUndergraduateId(undergraduateId);
                            sd1.setRank(rank);
                            sd1.setCourseCode(courseCode);
                            sd1.setUserId(userId);
                        }
                         
               
                        String query1="SELECT * FROM user  WHERE UserId= "+sd1.getUserId();
                         pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                         
                       ResultSet rs = pst.executeQuery();
                        if(rs.next()){
                           
                            String name = rs.getString("Name");
                            String dob=rs.getString("DateOfBirth");
                            String address=rs.getString("Address");
                            
                            sd1.setName(name);
                            sd1.setDateOfBirth(dob);
                            sd1.setAddress(address);
                        }

          
                        String query3="SELECT * FROM alresults  WHERE StudentId= "+sd1.getUndergraduateId();//+sd1.getUndergraduateId();
      
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                        ResultSet rs3 = pst3.executeQuery();
                        if(rs3.next()){
                         
                            String s1Name = rs3.getString("ALSubject1Name");
                            String s1Result = rs3.getString("ALSubject1Result");
                             String s2Name = rs3.getString("ALSubject2Name");
                            String s2Result = rs3.getString("ALSubject2Result");
                             String s3Name = rs3.getString("ALSubject3Name");
                            String s3Result = rs3.getString("ALSubject3Result");
                             String s4Name = rs3.getString("ALSubject4Name");
                            String s4Result = rs3.getString("ALSubject4Result");
                   
                            sd1.setSubject1Name(s1Name);
                            sd1.setSubject1Result(s1Result);
                            sd1.setSubject2Name(s2Name);
                            sd1.setSubject2Result(s2Result);
                            sd1.setSubject3Name(s3Name);
                            sd1.setSubject3Result(s3Result);
                            sd1.setSubject4Name(s4Name);
                            sd1.setSubject4Result(s4Result);
                        }

                        System.out.println("Searched");
                             
                        return true;
                        
                    } catch (Exception ex) {
                        //System.out.println(ex);      
                        
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
        
    }
       
    boolean updateUndergraduateStudent(UndergraduateStudent sd1){
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="UPDATE user SET Name=?,DateOfBirth=?,Address=?  WHERE UserId= ?";
                        String query2="UPDATE undergraduateregister SET UserId=?,Rank=?,CourseCode=? WHERE UndergraduateId= ?";
                        String query3="UPDATE alresults SET ALSubject1Name=?,ALSubject1Result=?,ALSubject2Name=?,ALSubject2Result=?,ALSubject3Name=?,ALSubject3Result=?,ALSubject4Name=?,ALSubject4Result=? WHERE StudentId= ?";
                  
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                        
                        pst.setString(1, sd1.getName());                  //add values to the sql querry
                        pst.setString(2, sd1.getDateOfBirth());      //add values to the sql querry
                        pst.setString(3, sd1.getAddress());            //add values to the sql querry
                        pst.setInt(4, sd1.getUserId());
                       
                        pst.executeUpdate();              //execute the sql querry and insert the values to the db table
                        ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        pst2.setString(1, sd1.getUserId()+"");         //add values to the sql querry              
                        pst2.setInt(2, sd1.getRank());                     //add values to the sql querry
                        pst2.setInt(3,sd1.getCourseCode());         //add values to the sql querry
                       pst2.setString(4,sd1.getUndergraduateId()+"");    
       
                        pst2.executeUpdate();
                   
                        
                       
                        pst3.setString(1, sd1.getSubject1Name());         //add values to the sql querry
                        pst3.setString(2, sd1.getSubject1Result());         //add values to the sql querry
                        pst3.setString(3, sd1.getSubject2Name());         //add values to the sql querry
                        pst3.setString(4, sd1.getSubject2Result());         //add values to the sql querry
                        pst3.setString(5, sd1.getSubject3Name());         //add values to the sql querry
                        pst3.setString(6, sd1.getSubject3Result());         //add values to the sql querry
                        pst3.setString(7, sd1.getSubject4Name());         //add values to the sql querry
                        pst3.setString(8, sd1.getSubject4Result());         //add values to the sql querry
                        pst3.setString(9,sd1.getUndergraduateId());    
                        
                        pst3.executeUpdate();
                        
                        
              
                        System.out.println("Updated");
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
        
    }
    
           boolean deleteUndergraduateStudent(UndergraduateStudent sd1){
          try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="DELETE FROM user WHERE UserId= "+sd1.getUserId();
                        String query2="DELETE FROM undergraduateregister WHERE UserId= "+sd1.getUserId();
                        String query3="DELETE FROM alresults WHERE StudentId= "+sd1.getUndergraduateId();
                    
                        pst=(PreparedStatement)con.prepareStatement(query1);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                        
                        pst.executeUpdate();
                        pst2.executeUpdate();
                        pst3.executeUpdate();
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
    }
    
    boolean addPostgraduateStudent(PostgraduateStudent ps1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  user(Name,DateOfBirth,Address,email) VALUES(?,?,?,?)";
                        String query2="INSERT INTO  postgraduateregister(PostgraduateId,CourseCode,UserId,intake) VALUES(?,?,?,?)";
                        String query3="INSERT INTO qualification(PostgraduateId,qualificationType,undergraduateDegree,University,YearOfGraduation) VALUES(?,?,?,?,?)";
                         
                        
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                        
                        //pst2.setInt(1, ps1.getUserId());                                             //add values to the sql querry
                        pst.setString(1, ps1.getName());                                    //add values to the sql querry
                        pst.setString(2,ps1.getDateOfBirth());                          //add values to the sql querry
                        pst.setString(3, ps1.getAddress());
                        pst.setString(4, ps1.getEmail());
                        
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                         ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        
                       pst2.setString(1, ps1.getPostgraduateId());                //add values to the sql querry
                       pst2.setInt(2, ps1.getCourseCode());     //add values to the sql querry
                       // pst2.setString(2, ps1.getUndergraduateDegree());     //add values to the sql querry
                       // pst2.setString(3, ps1.getUniversity());                           //add values to the sql querry
                       // pst2.setInt(4, ps1.getYearOfGraduation());                 //add values to the sql querry
                        pst2.setInt(3, id);                 //add values to the sql querry
                        pst2.setString(4, ps1.getIntake());
                        
                        pst2.executeUpdate();     //execute the sql querry and insert the values to the db table
                        
                       pst3.setString(1, ps1.getPostgraduateId());                //add values to the sql querry
                       //pst3.setInt(2, ps1.getCourseCode());     //add values to the sql querry
                       pst3.setString(2, ps1.getQualificationType());     //add values to the sql querry
                       pst3.setString(3, ps1.getUndergraduateDegree());     //add values to the sql querry
                       pst3.setString(4, ps1.getUniversity());                           //add values to the sql querry
                       pst3.setInt(5, ps1.getYearOfGraduation());                 //add values to the sql querry
                        
                        pst3.executeUpdate();     //execute the sql querry and insert the values to the db table
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
    }
    
     boolean searchPostgraduateStudent(PostgraduateStudent sd1){
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        
                        String query2="SELECT * FROM postgraduateregister WHERE postgraduateId= "+sd1.getPostgraduateId();
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        
                        ResultSet rs2 = pst2.executeQuery();
                        if(rs2.next()){
                            String postgraduateId = rs2.getString("postgraduateId");
                            int courseCode=rs2.getInt("CourseCode");
                            int userId=rs2.getInt("userId");
                            
                            sd1.setPostgraduateId(postgraduateId);
                            sd1.setUserId(userId);
                            sd1.setCourseCode(courseCode);
                        }
                             
                        String query1="SELECT * FROM user  WHERE UserId= "+sd1.getUserId();
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                        ResultSet rs = pst.executeQuery();
                        if(rs.next()){
                            String name = rs.getString("Name");
                            String dob=rs.getString("DateOfBirth");
                            String address=rs.getString("Address");
                            String email=rs.getString("email");
                            
                            sd1.setName(name);
                            sd1.setDateOfBirth(dob);
                            sd1.setAddress(address);
                            sd1.setEmail(email);
                        }
                                     
                                     
                        String query3="SELECT * FROM qualification  WHERE postgraduateId= "+sd1.getPostgraduateId();
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                    
                        ResultSet rs3 = pst3.executeQuery();
                           
                        if(rs3.next()){
                            String QualificationType = rs3.getString("QualificationType");
                            String University = rs3.getString("University");
                            int YearOfGrduation = rs3.getInt("YearOfGraduation");
                            String degree=rs3.getString("UndergraduateDegree");
           
                            sd1.setUniversity(University);
                            sd1.setQualificationType(QualificationType);
                            sd1.setYearOfGraduation(YearOfGrduation);
                            sd1.setUndergraduateDegree(degree);
                           
                        }

                        System.out.println("Searched");
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
        
    }
     
    
     boolean updatePostgraduateStudent(PostgraduateStudent sd1){
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="UPDATE user SET Name=?,DateOfBirth=?,Address=?  WHERE UserId= ?";
                        String query2="UPDATE postgraduateregister SET PostgraduateId=?,CourseCode=? WHERE UserId= ?";
                        String query3="UPDATE qualification SET  QualificationType=?,University=?,YearOfGraduation=? WHERE PostgraduateId= ?";
                   
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                        
                        pst.setString(1, sd1.getName());                  //add values to the sql querry
                        pst.setString(2, sd1.getDateOfBirth());      //add values to the sql querry
                        pst.setString(3, sd1.getAddress());            //add values to the sql querry
                        pst.setInt(4, sd1.getUserId());
                       
                        pst.executeUpdate();              //execute the sql querry and insert the values to the db table
                        ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        pst2.setString(1, sd1.getPostgraduateId());         //add values to the sql querry              
                        pst2.setInt(2,sd1.getCourseCode());         //add values to the sql querry
                       pst2.setInt(3,sd1.getUserId());    
                           
                        pst2.executeUpdate();

                        pst3.setString(1, sd1.getQualificationType());         //add values to the sql querry
                        pst3.setString(2, sd1.getUniversity());         //add values to the sql querry
                        pst3.setInt(3, sd1.getYearOfGraduation());         //add values to the sql querry
                        pst3.setString(4, sd1.getPostgraduateId());         //add values to the sql querry   
                        
                        pst3.executeUpdate();
                        
                        
              
                        System.out.println("Updated");
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
        
    }
    
      
       boolean deletePostgraduateStudent(PostgraduateStudent sd1){
          try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="DELETE FROM user WHERE UserId= "+sd1.getUserId();
                        String query2="DELETE FROM postgraduateregister WHERE UserId= "+sd1.getUserId();
                        String query3="DELETE FROM qualification WHERE PostgraduateId= "+sd1.getPostgraduateId();
                    
                        pst=(PreparedStatement)con.prepareStatement(query1);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        pst3=(PreparedStatement)con.prepareStatement(query3);
                        
                        pst.executeUpdate();
                        pst2.executeUpdate();
                        pst3.executeUpdate();
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
    }
    
    
    boolean addLecturer(Lecturer lec1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  user(Name,DateOfBirth,Address) VALUES(?,?,?)";
                        String query2="INSERT INTO  lecturer(LecturerId,RoomNo,FacultyId,UserId) VALUES(?,?,?,?)";
                         
                        
                        
                       pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                                                               
                       // pst.setInt(1, lec1.getUserId());                                             //add values to the sql querry
                        pst.setString(1, lec1.getName());                                    //add values to the sql querry
                        pst.setString(2,lec1.getDateOfBirth());                          //add values to the sql querry
                        pst.setString(3, lec1.getAddress());                                //add values to the sql querry
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                        
                        ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        
                       pst2.setInt(1, lec1.getLecId());                                             //add values to the sql querry
                        pst2.setInt(2, lec1.getRoomNo());                                             //add values to the sql querry
                        pst2.setInt(3, lec1.getFacultyId());                                             //add values to the sql querry
                        pst2.setInt(4,id);                                             //add values to the sql querry
                       
                        pst2.executeUpdate();     //execute the sql querry and insert the values to the db table
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
                        
    }
    
    boolean searchLecturer(Lecturer lec1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                  
                         String query1="SELECT * FROM lecturer WHERE  lecturerId="+lec1.getLecId();
                         pst2=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                         ResultSet rs2 = pst2.executeQuery();
                        if(rs2.next()){
                        int lecId=rs2.getInt("lecturerId");
                        int roomNo=rs2.getInt("roomNo");
                        int facId=rs2.getInt("facultyId");
                       int userId=rs2.getInt("userId");
                        
                        lec1.setLecId(lecId);
                        lec1.setRoomNo(roomNo);
                        lec1.setFacultyId(facId);
                        lec1.setUserId(userId);
                        
                        } 
                       
                        String query2="SELECT * FROM user WHERE userID="+lec1.getUserId();
                        pst=(PreparedStatement)con.prepareStatement(query2);
                        
                        ResultSet rs = pst.executeQuery();
                        if(rs.next()){
                        String name=rs.getString("Name");
                        String Address=rs.getString("Address");
                        String dob=rs.getString("dateOfBirth"); 
                     
                        
                        lec1.setName(name);
                        lec1.setAddress(Address);
                        lec1.setDateOfBirth(dob);
                       
                        }
                        
                        return true;
                        
                    }catch (Exception ex) {
                        ex.printStackTrace();
                        return false;
                        
                    }
                        
    }
    
     boolean updateLecturer(Lecturer lec1){
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="UPDATE user SET Name=?,DateOfBirth=?,Address=?  WHERE UserId= ?";
                        String query2="UPDATE lecturer SET LecturerId=?,RoomNo=?,FacultyId=? WHERE UserId= ?";
                    
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        
                        pst.setString(1, lec1.getName());                  //add values to the sql querry
                        pst.setString(2, lec1.getDateOfBirth());      //add values to the sql querry
                        pst.setString(3, lec1.getAddress());            //add values to the sql querry
                        pst.setInt(4, lec1.getUserId());
                       
                        pst.executeUpdate();              //execute the sql querry and insert the values to the db table
                        ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        pst2.setInt(1, lec1.getLecId());         //add values to the sql querry              
                        pst2.setInt(2,lec1.getRoomNo());         //add values to the sql querry
                       pst2.setInt(3,lec1.getFacultyId());    
                       pst2.setInt(4,lec1.getUserId());    
                           
                        pst2.executeUpdate();
              
                        System.out.println("Updated");
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
     }
    
     boolean deleteLecturer(Lecturer lec1){
          try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="DELETE FROM user WHERE UserId= "+lec1.getUserId();
                        String query2="DELETE FROM lecturer WHERE UserId= "+lec1.getUserId();
             
                    
                        pst=(PreparedStatement)con.prepareStatement(query1);
                        pst2=(PreparedStatement)con.prepareStatement(query2);

                        
                        pst.executeUpdate();
                        pst2.executeUpdate();
     
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
    }
    
    
    boolean addInstructor(Instructor ins1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  user(userId,Name,DateOfBirth,Address) VALUES(?,?,?,?)";
                        String query2="INSERT INTO  instructor(InstructorId,UserId) VALUES(?,?)";
                         
                        
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        
                        //pst.setInt(1, ins1.getUserId());                           //add values to the sql querry
                        pst.setInt(1,ins1.getUserId());
                        pst.setString(2,ins1.getName());                       //add values to the sql querry
                        pst.setString(3,ins1.getDateOfBirth());           //add values to the sql querry
                        pst.setString(4, ins1.getAddress());                 //add values to the sql querry
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                        
                        ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        
                       pst2.setInt(1, ins1.getInstructorId());                //add values to the sql querry
                       pst2.setInt(2,ins1.getUserId());                         //add values to the sql querry
                                   
                        pst2.executeUpdate();     //execute the sql querry and insert the values to the db table
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
    
      boolean searchInstructor(Instructor ins1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                         String query2="SELECT * FROM instructor WHERE  instructorID="+ins1.getInstructorId();
                          pst2=(PreparedStatement)con.prepareStatement(query2);
                          
                       ResultSet rs2 = pst2.executeQuery();
                        if(rs2.next()){
                        int insId=rs2.getInt("InstructorId");
                        int userId=rs2.getInt("userId");
            
                        ins1.setInstructorId(insId);
                        ins1.setUserId(userId);
      
                        } 
                        
                        String query1="SELECT * FROM user WHERE userID="+ins1.getUserId();
                       pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                       
     
                        ResultSet rs = pst.executeQuery();
                        if(rs.next()){
                        String name=rs.getString("Name");
                        String Address=rs.getString("Address");
                        String dob=rs.getString("dateOfBirth");             
                        
                        ins1.setName(name);
                        ins1.setAddress(Address);
                        ins1.setDateOfBirth(dob);
                          
                        }
                       
                         System.out.println("2");
                        return true;
                        
                    }catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
                        
    }
      
        boolean updateInstructor(Instructor ins1){
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="UPDATE user SET Name=?,DateOfBirth=?,Address=?  WHERE UserId= ?";
                        String query2="UPDATE instructor SET instructorId=? WHERE UserId= ?";
                    
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        pst2=(PreparedStatement)con.prepareStatement(query2);
                        
                        pst.setString(1, ins1.getName());                  //add values to the sql querry
                        pst.setString(2, ins1.getDateOfBirth());      //add values to the sql querry
                        pst.setString(3, ins1.getAddress());            //add values to the sql querry
                        pst.setInt(4, ins1.getUserId());
                       
                        pst.executeUpdate();              //execute the sql querry and insert the values to the db table
                        ResultSet rs = pst.getGeneratedKeys();
                        int id = 0;
                        if(rs.next()){
                            id = rs.getInt(1);
                        }
                        pst2.setInt(1, ins1.getInstructorId());         //add values to the sql querry              
                       pst2.setInt(2,id);    
                           
                        pst2.executeUpdate();
              
                        System.out.println("Updated");
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
     }
      
       boolean deleteInstructor(Instructor ins1){
          try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="DELETE FROM user WHERE UserId= "+ins1.getUserId();
                        String query2="DELETE FROM instructor WHERE UserId= "+ins1.getUserId();
             
                    
                        pst=(PreparedStatement)con.prepareStatement(query1);
                        pst2=(PreparedStatement)con.prepareStatement(query2);

                        
                        pst.executeUpdate();
                        pst2.executeUpdate();
     
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }finally{
                        try{
                            
                                if(pst != null){
                                    pst.close();
                                }

                                if(con != null){
                                    con.close();
                                }
                            
                        }catch(Exception ex){
                                   
                        }
                    }
    }
    
    boolean addCourse(Course course1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  course(CourseTitle,FacultyId) VALUES(?,?)";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                        
                        //pst.setInt(1, ins1.getUserId());                           //add values to the sql querry
                        pst.setString(1,course1.getCourseTitle());                       //add values to the sql querry
                        pst.setInt(2,course1.getFacultyId());           //add values to the sql querry            
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
    
         boolean searchCourse(Course crs1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="SELECT * FROM course WHERE courseCode="+crs1.getCourseCode();
          
                       pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                     
                        ResultSet rs = pst.executeQuery();
                        if(rs.next()){
                        String title=rs.getString("courseTitle");
                        int facId=rs.getInt("facultyId");
                     
                        crs1.setCourseTitle(title);
                        crs1.setFacultyId(facId);
                        }
          
                        return true;
                        
                    }catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
                        
    }
         
         boolean updateCourse(Course course1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="UPDATE course SET courseTitle=?,FacultyId=? WHERE courseCode=?";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        

                        pst.setString(1, course1.getCourseTitle());                           //add values to the sql querry
                        pst.setInt(2,course1.getFacultyId());                    //add values to the sql querry
                        pst.setInt(3,course1.getCourseCode());                                  //add values to the sql querry
       
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
    
        boolean deleteCourse(Course crs1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="DELETE FROM Course WHERE courseCode="+crs1.getCourseCode();
                        
                        pst=(PreparedStatement)con.prepareStatement(query1);
    
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
 
    
    boolean addSubject(Subject subject1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  subject(SubjectCode,CourseCode,SubjectName,Fee,IsMandatory,AssignedLecturers,AssignedInstructors) VALUES(?,?,?,?,?,?,?)";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                        
                        pst.setInt(1, subject1.getSubjectCode());                           //add values to the sql querry
                        pst.setInt(2, subject1.getCourseCode());                           //add values to the sql querry
                        pst.setString(3,subject1.getSubjectName());                    //add values to the sql querry
                        pst.setDouble(4,subject1.getFee());                                  //add values to the sql querry
                        pst.setBoolean(5, subject1.isIsMandatory());                 //add values to the sql querry
                        pst.setString(6,subject1.getLecturers());                               //add values to the sql querry
                        pst.setString(7,subject1.getInstructors());                       //add values to the sql querry
                     
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
   
  
        boolean searchSubject(Subject subject1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="SELECT * FROM subject WHERE subjectCode="+subject1.getSubjectCode();
                     //   String query1="UPDATE subject SET CourseCode=?,SubjectName=?,Fee=?,IsMandatory=?,AssignedLecturers=?,AssignedInstructors=? WHERE SubjectCode=?";
                        
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                
                        ResultSet rs1=pst.executeQuery();   //
                                
                        if(rs1.next()){
                            int subjectCode=rs1.getInt("subjectCode");
                            int courseCode=rs1.getInt("courseCode");
                            String subjectName=rs1.getString("subjectName");
                            int fee=rs1.getInt("Fee");
                            Boolean isMandatory=rs1.getBoolean("isMandatory");
                            String assignedLecturers=rs1.getString("assignedLecturers");
                            String assignedInstructors=rs1.getString("assignedInstructors");
                            
                            subject1.setSubjectCode(subjectCode);
                            subject1.setCourseCode(courseCode);
                            subject1.setSubjectName(subjectName);
                            subject1.setIsMandatory(isMandatory);
                            subject1.setFee(fee);
                            subject1.setLecturers(assignedLecturers);
                            subject1.setInstructors(assignedInstructors);
                        }
                        
                        
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
     
    

   boolean updateSubject(Subject subject1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="UPDATE subject SET CourseCode=?,SubjectName=?,Fee=?,IsMandatory=?,AssignedLecturers=?,AssignedInstructors=? WHERE SubjectCode=?";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        

                        pst.setInt(1, subject1.getCourseCode());                           //add values to the sql querry
                        pst.setString(2,subject1.getSubjectName());                    //add values to the sql querry
                        pst.setDouble(3,subject1.getFee());                                  //add values to the sql querry
                        pst.setBoolean(4, subject1.isIsMandatory());                 //add values to the sql querry
                        pst.setString(5,subject1.getLecturers());                               //add values to the sql querry
                        pst.setString(6,subject1.getInstructors());                       //add values to the sql querry
                        pst.setInt(7, subject1.getSubjectCode());                           //add values to the sql querry
                     
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
      

   
     boolean deleteSubject(Subject sub1){
                    try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="DELETE FROM subject WHERE SubjectCode="+sub1.getSubjectCode();
                        
                        pst=(PreparedStatement)con.prepareStatement(query1);
    
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
          
    }
 
     
     boolean addAssignment(UndergraduateAssignments assign1){
     
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  undergraduateAssignment(SubjectCode,AssignmentId,Semester,StudentId,marks) VALUES(?,?,?,?,?)";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                        
                        pst.setInt(1, assign1.getSubjectCode());                           //add values to the sql querry
                        pst.setInt(2, assign1.getAssignmentId());                           //add values to the sql querry
                        pst.setInt(3, assign1.getSemester());                           //add values to the sql querry
                        pst.setString(4, assign1.getUndergraduateId()+"");                           //add values to the sql querry
                        pst.setInt(5, assign1.getMarks());                           //add values to the sql querry
                     
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
         
     }
    
     boolean addAssignment(PostgraduateAssignments assign1){
     
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  postgraduateAssignment(AssignmentId,SubjectCode,Semester,StudentId,marks) VALUES(?,?,?,?,?)";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                        
                        pst.setInt(1, assign1.getAssignmentId());                           //add values to the sql querry
                        pst.setInt(2, assign1.getSubjectCode());                           //add values to the sql querry
                        pst.setInt(3, assign1.getSemester());                           //add values to the sql querry
                        pst.setString(4, assign1.getPostgraduateID()+"");                           //add values to the sql querry
                        pst.setInt(5, assign1.getMarks());                           //add values to the sql querry
                     
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
         
     }
    
      boolean addExam(UndergraduateExam assign1){
     
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  undergraduateExam(SubjectCode,Semester,StudentId,marks,percentage) VALUES(?,?,?,?,?)";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                        
                        pst.setInt(1, assign1.getSubjectCode());                           //add values to the sql querry
                        pst.setInt(2, assign1.getSemester());                           //add values to the sql querry
                        pst.setString(3, assign1.getUndergraduateId()+"");                           //add values to the sql querry
                        pst.setInt(4, assign1.getMarks());                           //add values to the sql querry
                        pst.setDouble(5, assign1.getExamPercentage());
                     
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
         
     }
      
       boolean addPostgraduateExam(PostgraduateExam assign1){
     
           try {
                        con=(Connection)DriverManager.getConnection(url, username, password);
                        String query1="INSERT INTO  postgraduateExam(SubjectCode,Semester,StudentId,marks,percentage) VALUES(?,?,?,?,?)";
                        
                        pst=(PreparedStatement)con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                        
                        
                        pst.setInt(1, assign1.getSubjectCode());                           //add values to the sql querry
                        pst.setInt(2, assign1.getSemester());                           //add values to the sql querry
                        pst.setString(3, assign1.getPostgraduateId()+"");                           //add values to the sql querry
                        pst.setInt(4, assign1.getMarks());                           //add values to the sql querry
                        pst.setDouble(5, assign1.getExamPercentage());
                     
                         
                        pst.executeUpdate();     //execute the sql querry and insert the values to the db table
                             
                        return true;
                        
                    } catch (Exception ex) {
                        System.out.println(ex);      
                        return false;
                        
                    }
         
     }

}
