import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
  
public class ValidateEmailAndCode 
{  
public static String validate(String email,String code,String password,String position)
{  
 
try
{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","sys");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from employee where email=? and securitycode=? and position=?");  
ps.setString(1,email);  
ps.setString(2,code);  
ps.setString(3, position);
ResultSet rs=ps.executeQuery();
boolean status=rs.next();
if(status)
{
	PreparedStatement ps1=con.prepareStatement(  
			"update employee set password=? where email=?");  
			ps1.setString(1,password);
			ps1.setString(2,email);
			ps1.executeUpdate();
	return "1";
}
else
{
	return "0";
}

}

catch(Exception e)
{
	System.out.println(e);
	
}
return "";
}
}
