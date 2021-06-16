import java.sql.*;
import java.util.Vector;

public class Connect {
    Connection conn = null;

    public void connect() {
        String url = "jdbc:postgresql://localhost/student";
        String username = "postgres";
        String password = "100ee20gg";






        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveData(String Student_ID, String Student_Name, String Course, String Grade) {
        String strSql = "INSERT INTO study (student_ID, student_Name, Course, Grade) "
                + " VALUES ('" + Student_ID
                + "', '" +  Student_Name
                + "', '" + Course
                + "', '" + Grade + "');";
        System.out.println(strSql);

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(strSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Vector readStudent() {
        Vector<Vector<String>> vData = new Vector<Vector<String>>();
        try  {
            String sqlStr = "SELECT Student_ID, Student_Name, Course, Grade "
                    + "FROM study ORDER BY Student_ID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                Vector<String> vRow = new Vector<String>();
                vRow.add(rs.getString("Student_ID"));
                vRow.add(rs.getString("Student_Name"));
                vRow.add(rs.getString("Course"));
                vRow.add(rs.getString("Grade"));


                System.out.println(rs.getString("Student_ID"));

                vData.add(vRow);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vData;
    }

    public void close() {
        try {
            if(conn != null) conn.close();
            System.out.println("Closed the PostgreSQL server connection.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saySomething() {
        System.out.println("Something ...");
    }

}
