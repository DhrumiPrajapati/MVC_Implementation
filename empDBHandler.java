import java.util.*;
import java.sql.*;
public class empDBHandler
{
    public static Connection getConnection ()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
        } 
        catch (Exception e)
        {
            System.out.println (e);
        }
        return con;
    }
    
    public static int save(EMP e)
    {
        int status = 0;
        try
        {
            Connection con = empDBHandler.getConnection ();
            PreparedStatement ps =con.prepareStatement ("insert into emp values (?,?,?)");
            ps.setInt(1, e.getId());
            ps.setString (2, e.getName());
            ps.setString (3, e.getDept());
            status = ps.executeUpdate();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }
    
    public static List < EMP > getAllEmployees ()
    {
        List<EMP> list = new ArrayList<EMP>();
        try
        {
            Connection con = empDBHandler.getConnection ();
            PreparedStatement ps = con.prepareStatement ("select * from emp");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ())
         {
             EMP e = new EMP ();
             e.setId (rs.getInt (1));
             e.setName (rs.getString (2));
             e.setDept (rs.getString (3));

             list.add (e);
         }
            con.close ();
        }
        catch (Exception e) 
        {
            e.printStackTrace ();
        }
        return list;
    }
}
