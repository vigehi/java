import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student {
    private JTextField textID;
    private JTextField textName;
    private JTextField textCourse;
    private JTextArea textGrade;
    private JButton saveButton;
    private JButton readButton;
    private JPanel panel1;


    public Student() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String Student_ID = textID.getText();
                String Student_Name = textName.getText();
                String Course = textCourse.getText();
                String Grade = textGrade.getText();

                Connect S02 = new Connect();
                S02.connect();
                S02.saveData(Student_ID, Student_Name, Course, Grade);

            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stud S04 = new stud();
                S04.init(false);

            }
        });
    }
    public static void main(String[] args) {
        Student S01 = new Student();
        S01.init();
    }

    public void init() {

        JFrame frame = new JFrame("Student");
        frame.setContentPane(new Student().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}



