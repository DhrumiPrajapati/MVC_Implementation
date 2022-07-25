
import javax.swing.JOptionPane;

public class EMP {
    
    //@NotNull
    private int id;
    
    private String name, dept;
    
    public int getId ()
    {
        //if(id.equals("")){
          //  JOptionPane.showMessageDialog(null, "ID is mandatory!");
        //}
        //else{
        return id;
        //}
    }
    public String getName ()
    {
        return name;
    }
    public String getDept ()
    {
        return dept;
    }
    
    public void setId (int id)
    {
        this.id = id;
    }
    public void setName (String name)
    {
        this.name = name;
    }
    public void setDept (String dept)
    {
        this.dept = dept;
    }
}
