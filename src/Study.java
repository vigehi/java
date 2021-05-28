import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Study {
    private JTextField textID;
    private JTextField textName;
    private JTextField textUnit;
    private JTextField textGrade;
    private JPanel Main;
    private JButton insertButton;
    private JButton newButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JPanel main;

    public static void main(String[] args) {
        JFrame frame =  new JFrame("Main");
        frame.setContentPane(new Study().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setVisible(true);

    }

    public Study() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = textID.getText();
                String Name = textName.getText();
                String Unit = textUnit.getText();
                String Grade = textGrade.getText();

                Scanner sc = new Scanner(System.in);

                Connection connection = null;
                String host = "localhost";
                String port = "5432";
                String db_name = "studies";
                String username = "postgres";
                String password = "100ee20gg";

                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");

                    if (connection != null) {

                        String sql = "insert into study values ('" + ID + "','" + Name + "','" + Unit + "','" + Grade + "')";
                        Statement statement = connection.createStatement();
                        int x = statement.executeUpdate(sql);
                        if (x == x) {
                            JOptionPane.showMessageDialog(insertButton, "user exists");

                        }
                        else{
                            JOptionPane.showMessageDialog(insertButton,"insert succesful");
                        }


                        connection.close();


                    }

                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
