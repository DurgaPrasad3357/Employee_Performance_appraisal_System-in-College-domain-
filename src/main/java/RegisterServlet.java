import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class RegisterServlet extends HttpServlet 
{  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException 
{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();
    String name=request.getParameter("name");
    String email=request.getParameter("email");  
    String password=request.getParameter("password");
    String qualification=request.getParameter("qualification");
    String designation=request.getParameter("designation");
    String department=request.getParameter("department");
    String code=request.getParameter("code");
    String position="faculty";
    String phd_status="";
    if(qualification.equals("phd"))
    {
    	phd_status="yes";
    }
    else
    {
    	phd_status="no";
    }
    
    try
    {  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection(  
    "jdbc:oracle:thin:@localhost:1521:xe","system","sys"); 
    
    PreparedStatement st = con 
            .prepareStatement("insert into employee values(?, ?,?,?,?,?,?,?,?)"); 

    st.setString(1,name); 
    
     st.setString(2,email); 

     st.setString(3, password); 

     st.setString(4, qualification);
     
     st.setString(5,designation);
     
     st.setString(6,position);
     
     st.setString(7,department);
     
     st.setString(8,phd_status); 
     
     st.setString(9,code);
     
     
     
     st.executeUpdate(); 
     
     out.print("<head><style> dialog{ color:green ; left:430px; margin-top:0px; }</style></head>");
 	out.print("<body><dialog open><h3>  Registered Successfully  </h3></dialog></body>");
     RequestDispatcher rd=request.getRequestDispatcher("RegisterPage.html");
     rd.include(request,response);
     
     st.close(); 
     con.close(); 
    
    }
    catch (Exception e)
    {
    	System.out.println(e);
    }
    out.close();  
    }  
}