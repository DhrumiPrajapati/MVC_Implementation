import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/reportservlet")
public class ReportServlet extends HttpServlet
{
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        try (PrintWriter out = response.getWriter ()) {
            int id=Integer.parseInt(request.getParameter("ID"));
            String name = request.getParameter ("NAME");
            String dept = request.getParameter ("DEPT");
            EMP e = new EMP ();
            e.setId(id);
            e.setName(name);
            e.setDept(dept);
            
            int status = empDBHandler.save (e);
            if (status > 0)
            {
                out.print ("<p>Record saved successfully!</p>");
                out.print("<a href=\"viewservlet\">View Employee Details</a>");
                //request.getRequestDispatcher ("index.html").include(request, response);  
            }
            else
            {
                out.println ("Sorry! unable to save record");
            }
        }
    }
}
