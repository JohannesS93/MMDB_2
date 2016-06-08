import java.io.*;
import java.net.URL;

import oracle.sql.*;
import java.sql.*; 
import java.util.*; 
public class StorePicture 
{ 
    public static void test(Connection con, File file, int id) throws Exception 
    { 
        Statement s; 
        FileInputStream fis; 
        PreparedStatement ps; 
       
        try 
        { 
            fis=new FileInputStream(file); 

             
            
            String str="insert into Image values(?, BFILENAME(?, 'name'))"; 
            ps=con.prepareStatement(str); 
            ps.setInt(1, id);
            ps.setString(2, file.getAbsolutePath());
            ps.execute(); 

            ps.close(); 
             
        } 
            catch(SQLException e) 
        { 
            e.printStackTrace(); 
        } 
    } 
} 