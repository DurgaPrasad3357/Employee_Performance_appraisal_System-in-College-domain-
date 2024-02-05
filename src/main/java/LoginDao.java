import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

  
public class LoginDao 
{  
public static String validate(String email,String password,String position)
{  
boolean status=false;  
try
{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","sys");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from employee where email=? and password=? and position=?");  
ps.setString(1,email);  
ps.setString(2,password);  
ps.setString(3,position);
ResultSet rs=ps.executeQuery(); 

status=rs.next();
if(status)
{
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