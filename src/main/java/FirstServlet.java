import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class FirstServlet extends HttpServlet 
{  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException 
{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter(); 
    String email=request.getParameter("email");  
    String password=request.getParameter("password");
    String position=request.getParameter("position");
    String result=LoginDao.validate(email, password,position);
    if(result.equals("1"))
    {  
    	
    	RequestDispatcher rd;
        if(position.equals("principal"))
        {
        	rd=request.getRequestDispatcher("Principal.html");
        	rd.forward(request,response);
        }
        if(position.equals("hod"))
        {
        	rd=request.getRequestDispatcher("HOD.html");
        	rd.forward(request,response);
        }
        if(position.equals("faculty"))
        {
        	
        	rd=request.getRequestDispatcher("Faculty.html");
        	rd.forward(request,response);
        }
        
    }  
    else
    {
    	out.print("<head><style> dialog{ color:red; left:460px; margin-top:20px; }</style></head>");
    	out.print("<body><dialog open><h3>  Invalid credentials  </h3></dialog></body>");
        RequestDispatcher rd=request.getRequestDispatcher("LoginPage.html");
        rd.include(request,response);
        
    }  
          
    out.close();  
    }  
}