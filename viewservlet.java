import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewservlet")  
public class viewservlet extends HttpServlet
{
   
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        out.println ("<a href='index.html'>Add Employee</a>");
        out.println ("<h1>Employee Details:</h1>");
        List <EMP> list = empDBHandler.getAllEmployees();

        out.print ("<table border='1' width='50%' ");
        out.print("<tr><th>Id</th><th>Name</th><th>Dept</th></tr>");
        
        for (EMP e:list)
        {
         out.print ("<tr><td>" + e.getId () + "</td><td>" + e.getName () +"</td><td>" + e.getDept () +
      "</td></tr>");
        }
        out.print ("</table>");
        out.close ();
    }
}
