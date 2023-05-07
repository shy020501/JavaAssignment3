import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {

    private int[] frameSize = {1100, 900};

    public MainFrame(){

        ImageIcon skkuWallpaper = new ImageIcon("src/images/skku_wallpaper.png"); // For storing wallpaper image
        Image skkuWallpaperImage = skkuWallpaper.getImage(); // Get image from image icon

        // Resize the image
        skkuWallpaperImage = skkuWallpaperImage.getScaledInstance(
                frameSize[0] * 23 / 60,
                frameSize[1] - frameSize[1] / 8,
                Image.SCALE_SMOOTH
        );
        skkuWallpaper = new ImageIcon(skkuWallpaperImage); // Allocate resized image to skkuWallPaper variable
        JLabel wallPaperLabel = new JLabel(skkuWallpaper); // Create JLabel object to place the wallpaper to screen
        // Set bounds for wall paper label with respect to frame size
        wallPaperLabel.setBounds(
                frameSize[0] / 40,
                -frameSize[1] / 32,
                frameSize[0] / 3,
                frameSize[1] / 1
        );
        add(wallPaperLabel);

        ImageIcon title = new ImageIcon("src/images/title_label.png"); // For storing title image
        Image titleImg = title.getImage(); // Get image from title icon

        // Resize the image
        titleImg = titleImg.getScaledInstance(
                frameSize[0] * 31 / 60,
                frameSize[1] / 11,
                Image.SCALE_SMOOTH
        );
        title = new ImageIcon(titleImg); // Allocate resized image to title variable
        JLabel titleLabel = new JLabel(title); // Create JLabel object to place the title image to screen
        // Set bounds for wall paper label with respect to frame size
        titleLabel.setBounds(
                frameSize[0] * 43 / 120,
                frameSize[1] / 32,
                frameSize[0] * 37 / 60,
                frameSize[1] / 11
        );
        add(titleLabel);

        Border blackLine = BorderFactory.createLineBorder(Color.black); // Store boarder for panels
        Font panelFont = new Font("Arial", Font.BOLD, 15); // Store font for panels

        JPanel mandatoryPanel = new JPanel(); // Panel that includes components that should be filled in by all users (name, birthdate, etc.)
        mandatoryPanel.setBorder(blackLine); // Set boarder of mandatory panel
        // Set bounds for mandatory panel with respect to frame size
        mandatoryPanel.setBounds(
                frameSize[0] * 49 / 120,
                frameSize[1] * 10 / 80,
                frameSize[0] * 31 / 60,
                frameSize[1] / 3
        );
        mandatoryPanel.setLayout(null); // Delete layout of mandatory panel so that components can be placed based on coordinate
        add(mandatoryPanel);

        JLabel mandatoryLabel = new JLabel("* For all students"); // Description for mandatory panel
        mandatoryLabel.setForeground(Color.red); // Change text color to red
        mandatoryLabel.setHorizontalAlignment(JLabel.LEFT); // Set horizontal alignment to left
        mandatoryLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for mandatory label with respect to frame size
        mandatoryLabel.setBounds(
                frameSize[0] / 80,
                0,
                frameSize[0] / 10,
                frameSize[1] / 30
        );
        mandatoryPanel.add(mandatoryLabel);

        JLabel nameLabel = new JLabel("Applicant Name: "); // Store label for applicant name
        nameLabel.setFont(panelFont); // Set font of name label
        nameLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        nameLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for applicant name label with respect to frame size
        nameLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30,
                frameSize[0] / 6,
                frameSize[1] * 3 / 40
                );
        mandatoryPanel.add(nameLabel);

        JLabel birthLabel = new JLabel("Birth Date: "); // Store label for birthdate
        birthLabel.setFont(panelFont); // Set font of name label
        birthLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        birthLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for birthdate label with respect to frame size
        birthLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 3 / 40),
                frameSize[0] / 6,
                frameSize[1] * 3 / 40
        );
        mandatoryPanel.add(birthLabel);

        JLabel emailLabel = new JLabel("Email: "); // Store label for email address
        emailLabel.setFont(panelFont); // Set font of email label
        emailLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        emailLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for email label with respect to frame size
        emailLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 3 / 40) * 2,
                frameSize[0] / 6,
                frameSize[1] * 3 / 40
        );
        mandatoryPanel.add(emailLabel);

        JLabel degreeLabel = new JLabel("Degree: "); // Store label for degree
        degreeLabel.setFont(panelFont); // Set font of degree label
        degreeLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        degreeLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for degree label with respect to frame size
        degreeLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 3 / 40) * 3,
                frameSize[0] / 6,
                frameSize[1] * 3 / 40
        );
        mandatoryPanel.add(degreeLabel);



        JPanel optionalPanel = new JPanel(); // Panel that includes components that only some of the users should fill in (attended university, GPA)
        optionalPanel.setBorder(blackLine); // Set boarder of optional panel
        // Set bounds for optional panel with respect to frame size
        optionalPanel.setBounds(
                frameSize[0] * 49 / 120,
                frameSize[1] * 19 / 40 ,
                frameSize[0] * 31 / 60,
                frameSize[1] / 5
        );
        optionalPanel.setLayout(null); // Delete layout of optional panel so that components can be placed based on coordinate
        add(optionalPanel);

        JLabel optionalLabel = new JLabel("* For graduate students only"); // Description for optional panel
        optionalLabel.setForeground(Color.red); // Change text color to red
        optionalLabel.setHorizontalAlignment(JLabel.LEFT); // Set horizontal alignment to left
        optionalLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        optionalLabel.setBounds(frameSize[0] / 80, 0, frameSize[0] / 6, frameSize[1] / 30); // Set bounds for optional label with respect to frame size
        optionalPanel.add(optionalLabel);

        JLabel universityLabel = new JLabel("Attended University: "); // Store label for university
        universityLabel.setFont(panelFont); // Set font of university label
        universityLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        universityLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for university label with respect to frame size
        universityLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30,
                frameSize[0] / 6,
                frameSize[1] * 3 / 40
        );
        optionalPanel.add(universityLabel);

        JLabel gpaLabel = new JLabel("Birth Date: "); // Store label for GPA
        gpaLabel.setFont(panelFont); // Set font of GPA label
        gpaLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        gpaLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for GPA label with respect to frame size
        gpaLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 3 / 40),
                frameSize[0] / 6,
                frameSize[1] * 3 / 40
        );
        optionalPanel.add(gpaLabel);

//        JPanel extraPanel = new JPanel(); // Panel that includes extra details including personal statement and home address

        // Settings for frame
        setTitle("SKKU New Student Enrollment");
        setSize(frameSize[0], frameSize[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
