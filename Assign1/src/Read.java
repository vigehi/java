import javax.swing.*;
import java.util.Vector;

public class Read {
    private JTable table1;
    private JPanel panel2;
    private JScrollPane scrPane;


    public static void main(String[] args) {
        Read S03= new Read();
        S03.init();
    }

    public void init() {
        Connect S02 = new Connect();
        S02.connect();

        Vector<String> studyTitles = new Vector<String>();
        studyTitles.add("Student_ID");
        studyTitles.add("Student_Name");
        studyTitles.add("Course");
        studyTitles.add("Grade");
        Vector<Vector<String>> vData = S02.readStudent();

        table1 = new JTable(vData, studyTitles);
        scrPane.setViewportView(table1);

        JFrame frame = new JFrame("Read");
        frame.setContentPane(new Read().panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}


