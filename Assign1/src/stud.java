import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class stud {


    private JTable table1;
    private JPanel panel2;
    private JScrollPane scrPane;

    public static void main(String[] args) {
        stud S04 = new stud();
        S04.init(true);
    }

    public void init(boolean closeOnExit) {
        Connect S02 = new Connect();
        S02.connect();

        Vector<String> studyTitles = new Vector<String>();
        studyTitles.add("Student_ID");
        studyTitles.add("Student_Name");
        studyTitles.add("Course");
        studyTitles.add("Grade");
        Vector<Vector<String>> vData = S02.readStudent();

        panel2 = new JPanel(new BorderLayout());
        table1 = new JTable(vData, studyTitles);
        scrPane = new JScrollPane(table1);

        JLabel lb1Title = new JLabel("Student List");
        panel2.add(lb1Title, BorderLayout.PAGE_START);
        panel2.add(scrPane, BorderLayout.CENTER);

        JFrame frame = new JFrame("stud");
        frame.add(panel2, BorderLayout.CENTER);
        if(closeOnExit) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
