import java.sql.*;

public class StudentsDbConnection {
    Connection conn=null;

    public  void DbConnect(){
        try {
            String url = "jdbc:postgresql://localhost:5432/studies";
            conn = DriverManager.getConnection(url, "postgres","100ee20gg");


        }catch (SQLException e){
            System.out.println("Sql connection error:"+e);

        }
    }

    public  String getStudentsInfo(){
        String showResponse = "<p><table><colgroup><col span=\"1\" style=\"background-color:red\"><col style=\"background-color:yellow\"><col style=\"background-color:green\"><col style=\"background-color:blue\"><col style=\"background-color:orange\"></colgroup><p><tr><th>STUDENT NAME</th><th>STUDENT ID</th><th>COURSE</th><th>MARKS</th><th>AVERAGE</th></tr></p>";
        String query = "select student_name, registration_number, course, marks, average from students";
        try {
            Statement statement= conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){


               showResponse+= " <tr><td>"+ resultSet.getString("student_name")+"</td><td>"+ resultSet.getString("registration_number")+"</td><td>"+ resultSet.getString("course")+"</td><td>"+ resultSet.getString("marks")+"</td><td>"+ resultSet.getString("average")+"</td></tr>";


            }
            showResponse+= "</table></p>";

        }catch (SQLException ex){
            System.out.println("Sql connection error"+ ex);

        }
        return showResponse;
    }
    public void close() {
        try {
            if(conn!=null)conn.close();
        }catch (SQLException ex){
            System.out.println("SQL connection error");
        }
    }
}
