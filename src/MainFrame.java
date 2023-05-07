import javax.swing.*;

public class MainFrame extends JFrame {

    private int[] frameSize = {1000, 800};

    public MainFrame(){
        // Settings for frame
        setTitle("SKKU New Student Enrollment");
        setSize(frameSize[0], frameSize[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
