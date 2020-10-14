
import java.sql.*;
import java.util.Scanner;
public class DBConnect {
private Connection con;
private Statement stat;
private ResultSet resu;
    
public DBConnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            stat = con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("Error found:"+ex);
        }
    }
    
    public void getData()
    {
        int i=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of details to be added:");
        int n = sc.nextInt();
        try
        {
            PreparedStatement ps = con.prepareStatement("insert into persons(name,age,address) values(?,?,?)");
            System.out.println("Enter data:");
            while(n!=0)
            {
                System.out.println("Name:");
                String na = sc.next();
                System.out.println("Age:");
                String a = sc.next();
		System.out.println("Address:");
                String b = sc.next();
                ps.setString(1,na);
                ps.setString(2, a);
		ps.setString(3, b);
                int j = ps.executeUpdate();
                i=i+j;
                n--;
            }
            System.out.println(i+" record(s) updated");
            String query = "Select * from student";
            result = stat.executeQuery(query);
            System.out.println("Records from database: ");
            while(res.next())
            {
                String name = resu.getString("name");
                String age = resu.getString("age");
		String address = resu.getString("address");
                System.out.println("Name: "+name+"\nAge:"+age+"\nAddress"+address);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error found:"+ex);
        }
    }
}
