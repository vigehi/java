import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeSalary {
    private JPanel panel1;
    private JTextField textName;
    private JTextField textSalary;
    private JTextField textTax;
    private JTextField textNet;
    private JButton okButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("EmployeeSalary");
        frame.setContentPane(new EmployeeSalary().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public EmployeeSalary() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String name = textName.getText();
                String salary = textSalary.getText();
                String tax = textTax.getText();
                String netSalary = textNet.getText();

                Connection connection = null;
                String host = "localhost";
                String port = "5432";
                String db_name = "postgres";
                String username = "postgres";
                String password = "100ee20gg";
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
                    if (connection != null) {

                        String sql = "insert into employee values ('" + name + "','" + salary + "','" + tax + "','" + netSalary + "')";
                        Statement statement = connection.createStatement();
                        int x = statement.executeUpdate(sql);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(okButton, "user exists");

                        } else {
                            JOptionPane.showMessageDialog(okButton, "insert succesful");
                        }

                        connection.close();


                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                double Salary = Double.parseDouble(textSalary.getText());
                double Tax, net;

                if (Salary > 50000) {
                    Tax = Salary * 10 / 100;
                } else if (Salary > 35000) {
                    Tax = Salary * 5 / 100;
                } else {
                    Tax = 0.00;

                }

                textTax.setText(String.valueOf(Tax));
                net = Salary - Tax;
                textNet.setText(String.valueOf(net));
            }
        });
    }
}




