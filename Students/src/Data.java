import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Data {
    Connection conn = null;
    public static Connection dbConnector() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/studies",
                            "postgres", "100ee20gg");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);



        }
        return null;




    }
}
