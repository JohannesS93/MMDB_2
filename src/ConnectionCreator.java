import javax.*;

import oracle.jdbc.OracleResultSet;
import oracle.sql.BFILE;

import java.sql.*;  
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;  
public class ConnectionCreator {  
public static int id = 1;
public static Connection getConnection() throws SQLException, ClassNotFoundException{

Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:orcl","sys as SYSDBA","zorro135");   
return con;
}

public static void init (Connection con) throws IOException{
	
	Files.walk(Paths.get("C:/Users/Johannes/workspaceMDB/MMDB/WebContent/Data/Pictures")).forEach(filePath -> {
	    if (Files.isRegularFile(filePath)) {
	    	
	    	File file = new File(filePath.toString());
	    	try {
				StorePicture.test(con,file,id);
				id++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	});
}
}
