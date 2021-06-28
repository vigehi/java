import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.SystemColor;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

    private JFrame frame;
    private JTextField textName;
    private JTextField textMajor;
    private static JTextField textComp;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Student window = new Student();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Connection connection = null;
    private JTextField textStudentID;
    private static JTextField textAlgebra;

    public Student() {
        connection = Data.dbConnector();
        initialize();
    }


    public class my_update {

        void my_db_update(String str1, String str2, String str3, String str4, double str5) {
            try {
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/studies", "postgres", "100ee20gg");
                Statement st = con.createStatement();
                String query1 = "INSERT INTO students"
                        + " (student_name, registration_number, course, marks , average)"
                        + "VALUES('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + computeAverage() + "')";
                st.executeUpdate(query1); 
                con.close();

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }


    public static double computeAverage() {

        String subject1 = textComp.getText();
        String subject2 = textAlgebra.getText();
        double result = 0;
        double str1 = Double.parseDouble(subject1);
        double str2 = Double.parseDouble(subject2);
        double sum = 0.0;
        double avg = 0.0;

        sum = str1 + str2;
        result = sum / 2;


        return result;
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.GRAY);
        frame.getContentPane().setForeground(Color.LIGHT_GRAY);
        frame.setBounds(0, 0, 1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) Color.GRAY));
        panel.setBounds(0, 0, 2000, 1700);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
        panel_1_1_1.setLayout(null);
        panel_1_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) SystemColor.inactiveCaptionText));
        panel_1_1_1.setBounds(48, 307, 908, 342);
        panel.add(panel_1_1_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.addMouseListener(new MouseAdapter() {

        });
        scrollPane.setBounds(12, 12, 854, 318);
        panel_1_1_1.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int index = table.getSelectedRow();
                TableModel model = table.getModel();
                textName.setText(model.getValueAt(index, 0).toString());
                textStudentID.setText(model.getValueAt(index, 1).toString());
                textMajor.setText(model.getValueAt(index, 2).toString());
                textComp.setText(model.getValueAt(index, 3).toString());

            }
        });
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "STUDENT NAME", "STUDENT ID", "COURSE", "MARKS", "AVERAGE"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(162);
        table.getColumnModel().getColumn(2).setPreferredWidth(158);
        table.getColumnModel().getColumn(3).setPreferredWidth(268);
        scrollPane.setViewportView(table);

        JPanel jtxtBool = new JPanel();
        jtxtBool.setForeground(SystemColor.scrollbar);
        jtxtBool.setBackground(Color.GRAY);
        jtxtBool.setLayout(null);
        jtxtBool.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(0, 0, 0)));
        jtxtBool.setBounds(62, 29, 346, 286);
        panel.add(jtxtBool);

        JLabel lblNewLabel = new JLabel("STUDENT NAME");
        lblNewLabel.setBounds(23, 21, 117, 32);
        jtxtBool.add(lblNewLabel);

        JLabel lblMajor = new JLabel("STUDENT ID");
        lblMajor.setBounds(23, 53, 117, 32);
        jtxtBool.add(lblMajor);

        JLabel lblMajor_1 = new JLabel("COURSE");
        lblMajor_1.setBounds(23, 93, 117, 32);
        jtxtBool.add(lblMajor_1);

        JLabel lblMajor_1_1 = new JLabel("MARKS");
        lblMajor_1_1.setBounds(23, 170, 117, 32);
        jtxtBool.add(lblMajor_1_1);

        textName = new JTextField();
        textName.setBounds(141, 25, 178, 24);
        jtxtBool.add(textName);
        textName.setColumns(10);

        textMajor= new JTextField();
        textMajor.setColumns(10);
        textMajor.setBounds(141, 97, 178, 24);
        jtxtBool.add(textMajor);

        textComp = new JTextField();
        textComp.setColumns(10);
        textComp.setBounds(111, 174, 64, 24);
        jtxtBool.add(textComp);

        textStudentID = new JTextField();
        textStudentID.setColumns(10);
        textStudentID.setBounds(141, 57, 178, 24);
        jtxtBool.add(textStudentID);

        JLabel lblMajor_1_1_1 = new JLabel("CAT 1");
        lblMajor_1_1_1.setBounds(111, 137, 64, 32);
        jtxtBool.add(lblMajor_1_1_1);

        textAlgebra = new JTextField();
        textAlgebra.setBounds(219, 176, 64, 19);
        jtxtBool.add(textAlgebra);
        textAlgebra.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("CAT 2");
        lblNewLabel_1.setBounds(219, 146, 132, 15);
        jtxtBool.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("ADD STUDENT");
        btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
        btnNewButton.setBounds(23, 224, 84, 46);
        jtxtBool.add(btnNewButton);

        JButton btnLoad = new JButton("DISPLAY");
        btnLoad.setBounds(114, 222, 96, 46);
        jtxtBool.add(btnLoad);


        JButton btnClear = new JButton("REFRESH");
        btnClear.setBounds(219, 222, 104, 46);
        jtxtBool.add(btnClear);
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DefaultTableModel) table.getModel()).setRowCount(0);
            }
        });
        btnLoad.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent arg0) {


                                          try {
                                              Class.forName("org.postgresql.Driver");
                                              String url = "jdbc:postgresql://localhost:5432/studies";
                                              Connection con = DriverManager.getConnection(url, "postgres", "100ee20gg");
                                              Statement st = con.createStatement();
                                              String sql = "select * from students";
                                              ResultSet rs = st.executeQuery(sql);

                                              while (rs.next()) {

                                                  String student_name = rs.getString("student_name");
                                                  String student_id = rs.getString("registration_number");
                                                  String major = rs.getString("course");
                                                  String marks = rs.getString("marks");
                                                  String average = rs.getString("average");


                                                  String tbData[] = {student_name, student_id, major, marks, average};
                                                  DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

                                                  tblModel.addRow(tbData);
                                              }


                                              con.close();

                                          } catch (Exception e) {
                                              System.out.println(e.getMessage());
                                          }


                                      }
                                  }
        );
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String student_name = textName.getText();
                String reg_no = textStudentID.getText();
                String major = textMajor.getText();
                String grade = textComp.getText();
                double average = computeAverage();
                my_update obj = new my_update();
                obj.my_db_update(student_name, reg_no, major, grade, average);
                textName.setText("");
                textStudentID.setText("");
                textMajor.setText("");
                textComp.setText("");
                textAlgebra.setText("");

            }


        });

        JLabel lblNewLabel_3 = new JLabel("Student Management System" +
                "");
        lblNewLabel_3.setBounds(70, 6, 301, 27);
        panel.add(lblNewLabel_3);
    }

    private static class __Tmp {
        private static void __tmp() {
            javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
        }

    }
}
