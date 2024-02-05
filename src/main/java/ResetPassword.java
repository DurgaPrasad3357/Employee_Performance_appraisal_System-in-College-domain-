import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class ResetPassword extends HttpServlet 
{  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException 
{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String email=request.getParameter("email");  
    String code=request.getParameter("code");
    String password=request.getParameter("password");
    String position=request.getParameter("position");
    String result=ValidateEmailAndCode.validate(email, code,password,position);      
    if(result.equals("1"))
    {
    	out.print("<head><style> dialog{ color:green; left:400px; margin-top:20px; }</style></head>");
    	out.print("<body><dialog open><h3>  Password changed successfully  </h3></dialog></body>");
    	RequestDispatcher rd=request.getRequestDispatcher("ForgetPassword.html");
        rd.include(request,response);
    }
    else
    {
    	out.print("<head><style> dialog{ color:red; left:460px;  margin-top:20px;}</style></head>");
    	out.print("<body><dialog open><h3>  Invalid credentials  </h3></dialog></body>");
    	RequestDispatcher rd=request.getRequestDispatcher("ForgetPassword.html");
        rd.include(request,response);
    }
          
    out.close();  
    }  
}  