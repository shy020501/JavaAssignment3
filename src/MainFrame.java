import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private int[] frameSize = {1100, 900};

    public void checkName(String name)
    {

    }

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
        Font panelInputFont = new Font("Arial", Font.PLAIN, 13); // Store font for user input

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
                frameSize[1] * 4 / 75
                );
        mandatoryPanel.add(nameLabel);

        JTextField nameField = new JTextField(); // Store text field for inputting applicant name
        // Set bounds for name field with respect to frame size
        nameField.setFont(panelInputFont); // Set font of name field
        nameField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        mandatoryPanel.add(nameField);

        JLabel birthLabel = new JLabel("Birth Date: "); // Store label for birthdate
        birthLabel.setFont(panelFont); // Set font of name label
        birthLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        birthLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for birthdate label with respect to frame size
        birthLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75),
                frameSize[0] / 6,
                frameSize[1] * 4 / 75
        );
        mandatoryPanel.add(birthLabel);

        JTextField birthField = new JTextField(); // Store text field for inputting birthdate
        // Set bounds for birth field with respect to frame size
        birthField.setFont(panelInputFont); // Set font of birthdate field
        birthField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 4 / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        mandatoryPanel.add(birthField);

        JLabel phoneLabel = new JLabel("Phone Number: "); // Store label for phone number
        phoneLabel.setFont(panelFont); // Set font of phone number label
        phoneLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        phoneLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for phone number label with respect to frame size
        phoneLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 2,
                frameSize[0] / 6,
                frameSize[1] * 4 / 75
        );
        mandatoryPanel.add(phoneLabel);

        JTextField phoneField = new JTextField(); // Store text field for inputting phone number
        phoneField.setFont(panelInputFont); // Set font of phone number field
        // Set bounds for phone number field with respect to frame size
        phoneField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 7 / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        mandatoryPanel.add(phoneField);

        JLabel emailLabel = new JLabel("Email: "); // Store label for email address
        emailLabel.setFont(panelFont); // Set font of email label
        emailLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        emailLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for email label with respect to frame size
        emailLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 3,
                frameSize[0] / 6,
                frameSize[1] * 4 / 75
        );
        mandatoryPanel.add(emailLabel);

        JTextField emailField = new JTextField(); // Store text field for inputting email
        emailField.setFont(panelInputFont); // Set font of email field
        // Set bounds for email field with respect to frame size
        emailField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 10 / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        mandatoryPanel.add(emailField);

        JLabel degreeLabel = new JLabel("Degree: "); // Store label for degree
        degreeLabel.setFont(panelFont); // Set font of degree label
        degreeLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        degreeLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for degree label with respect to frame size
        degreeLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 4,
                frameSize[0] / 6,
                frameSize[1] * 4 / 75
        );
        mandatoryPanel.add(degreeLabel);

        JTextField degreeField = new JTextField(); // Store text field for inputting degree
        degreeField.setFont(panelInputFont); // Set font of degree field
        // Set bounds for degree field with respect to frame size
        degreeField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 13 / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        mandatoryPanel.add(degreeField);

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
                frameSize[1]  * 4 / 75
        );
        optionalPanel.add(universityLabel);

        JTextField universityField = new JTextField(); // Store text field for inputting university
        universityField.setFont(panelInputFont); // Set font of university field
        // Set bounds for university field with respect to frame size
        universityField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        optionalPanel.add(universityField);

        JLabel gpaLabel = new JLabel("GPA: "); // Store label for GPA
        gpaLabel.setFont(panelFont); // Set font of GPA label
        gpaLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        gpaLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for GPA label with respect to frame size
        gpaLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75),
                frameSize[0] / 6,
                frameSize[1]  * 4 / 75
        );
        optionalPanel.add(gpaLabel);

        JTextField gpaField = new JTextField(); // Store text field for inputting GPA
        gpaField.setFont(panelInputFont); // Set font of gpa field
        // Set bounds for GPA field with respect to frame size
        gpaField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 4 / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        optionalPanel.add(gpaField);

        JLabel labLabel = new JLabel("Laboratory: "); // Store label for lab
        labLabel.setFont(panelFont); // Set font of lab label
        labLabel.setHorizontalAlignment(JLabel.RIGHT); // Set horizontal alignment to right
        labLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for lab label with respect to frame size
        labLabel.setBounds(
                frameSize[0] / 80,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 2,
                frameSize[0] / 6,
                frameSize[1]  * 4 / 75
        );
        optionalPanel.add(labLabel);

        JTextField labField = new JTextField(); // Store text field for inputting lab
        labField.setFont(panelInputFont); // Set font of lab field
        // Set bounds for lab field with respect to frame size
        labField.setBounds(
                frameSize[0] / 40 + frameSize[0] / 6,
                frameSize[1] / 30 + (frameSize[1] * 4 / 75) * 7 / 3,
                frameSize[0] * 35 / 120,
                frameSize[1] / 40
        );
        optionalPanel.add(labField);

        Font frameFont = new Font("Arial", Font.BOLD, 17); // Store font for frame

        JLabel psLabel = new JLabel("Personal Statement"); // Store label for personal statement
        psLabel.setFont(frameFont); // Set font of personal statement label
        psLabel.setHorizontalAlignment(JLabel.CENTER); // Set horizontal alignment to center
        psLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for personal statement label with respect to frame size
        psLabel.setBounds(
                frameSize[0] * 49 / 120,
                frameSize[1] * 7 / 10 ,
                frameSize[0] * 31 / 60,
                frameSize[1] / 40
        );
        add(psLabel);

        JTextArea psField = new JTextArea(); // Store text area for inputting personal statement
        psField.setBorder(blackLine); // Set border for personal statement field
        psField.setBackground(new Color(238, 238, 238)); // Set color of text field same as that of panel
        psField.setFont(new Font("Arial", Font.ITALIC, 15)); // Set font for personal statement field
        psField.setLineWrap(true); // When the length of user input exceeds the width of the field, text moves on to the next line
        // Set bounds for personal statement field with respect to frame size
        psField.setBounds(
                frameSize[0] * 49 / 120,
                frameSize[1] * 29 / 40,
                frameSize[0] * 31 / 60,
                frameSize[1] / 12
        );
        add(psField);

        JLabel addressLabel = new JLabel("Home Address: "); // Store label for home address
        addressLabel.setFont(frameFont); // Set font of home address label
        addressLabel.setHorizontalAlignment(JLabel.LEFT); // Set horizontal alignment to left
        addressLabel.setVerticalAlignment(JLabel.CENTER); // Set vertical alignment to center
        // Set bounds for home address label with respect to frame size
        addressLabel.setBounds(
                frameSize[0] * 49 / 120,
                frameSize[1] * 29 / 40 + frameSize[1] / 12,
                frameSize[0] / 6,
                frameSize[1] * 3 / 40
        );
        add(addressLabel);

        JTextField addressField = new JTextField(); // Store text field for inputting home address
        addressField.setFont(panelInputFont); // Set font of home address field
        // Set bounds for home address field with respect to frame size
        addressField.setBounds(
                frameSize[0] * 63 / 120,
                frameSize[1] * 29 / 40 + frameSize[1] / 12 + (frameSize[1] * 3 / 40) / 3,
                frameSize[0] / 4,
                frameSize[1] / 40
        );
        add(addressField);

        JButton submitButton = new JButton("Submit Application"); // Store submission button
        submitButton.setBackground(new Color(54, 117, 238)); // Set background color of submission button
        submitButton.setForeground(Color.white); // Set text color to white
        // Set bounds for submission button with respect to frame size
        submitButton.setBounds(
                frameSize[0] * 65 / 120 + frameSize[0] / 4,
                frameSize[1] * 29 / 40 + frameSize[1] / 12 + (frameSize[1] * 3 / 40) / 3,
                frameSize[0] * 2 / 15,
                frameSize[1] / 40
        );
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

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
