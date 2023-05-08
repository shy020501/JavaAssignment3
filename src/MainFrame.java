import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFrame extends JFrame {

    private int[] frameSize = {1100, 900};

    private boolean isGraduate = false;

    public boolean isValidName(String name)
    {
        boolean valid = false;
        String regex = "^[a-zA-Z]+\s[a-zA-Z]+$"; // Format of name (xxxxx xxxxx)
        Pattern namePattern = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher nameMatcher = namePattern.matcher(name); // Check if name pattern matches name
        if(nameMatcher.matches()) // If so, change valid to true
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidBirth(String birth)
    {
        boolean valid = false;
        String regex = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])/(\\d{4})$"; // Format of birth (mm/dd/yyyy)
        Pattern birthPattern = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher birthMatcher = birthPattern.matcher(birth); // Check if birth pattern matches birthdate
        if(birthMatcher.matches()) // If so, change valid to true
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidNumber(String number)
    {
        boolean valid = false;
        String regex = "^\\d{3}-\\d{3,4}-\\d{4}$"; // Format of phone number (xxx"^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";"^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";-xxxx-xxxx)
        Pattern numberPattern = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher numberMatcher = numberPattern.matcher(number); // Check if name pattern matches phone number
        if(numberMatcher.matches()) // If so, change valid to true
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidEmail(String email)
    {
        boolean valid = false;
        String regex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$"; // Format of email(xxxxx@xxxx.xxx)
        Pattern emailPattern = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher emailMatcher = emailPattern.matcher(email); // Check if name pattern matches phone number
        if(emailMatcher.matches()) // If so, change valid to true
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidDegree(String degree)
    {
        boolean valid = false;
        // Check if correct degree is inputted
        if(degree.toLowerCase().equals("bachelor") || degree.toLowerCase().equals("master") || degree.toLowerCase().equals("ph.d"))
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidUni(String uni)
    {
        boolean valid = false;
        String regex = "^[a-zA-Z\\s]+$"; // Format of university (xxxx University)
        Pattern uniPattern = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher uniMatcher = uniPattern.matcher(uni); // Check if name pattern matches university
        if(uniMatcher.matches()) // If so, change valid to true
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidGPA(String gpa)
    {
        boolean valid = false;
        double gpaDouble = 0;
        try {
            gpaDouble = Double.parseDouble(gpa); // Try converting gpa(String) to double
        } catch (NumberFormatException e) {} // If it is not convertible, throw exception

        if(gpaDouble >= 0 && gpaDouble <= 4.5) // Check if gpa is in correct boundary
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidLab(String lab)
    {
        boolean valid = false;
        String regex = "^[a-zA-Z\\s]+$"; // Format of laboratory (xxxx Laboratory)
        Pattern labPattern = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher labMatcher = labPattern.matcher(lab); // Check if name pattern matches laboratory
        if(labMatcher.matches()) // If so, change valid to true
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidPS(String ps)
    {
        boolean valid = false;
        int wordCnt = ps.split("\\s").length; // Get length of personal statement
        if(wordCnt >= 100) // If it is above 100 words return true
        {
            valid = true;
        }
        return valid;
    }

    public boolean isValidAddress(String address)
    {
        boolean valid = false;
        String regex = "^[0-9]+(\\,)\\s[a-zA-Z0-9\\s\\-]+(\\,)\\s[a-zA-Z\\-]+(\\,)\\s[a-zA-Z]+$"; // Format of home address (number, street, district, city)
        Pattern addressPattern = Pattern.compile(regex); // Compile regular expression to pattern
        Matcher addressMatcher = addressPattern.matcher(address); // Check if name pattern matches home address
        if(addressMatcher.matches()) // If so, change valid to true
        {
            valid = true;
        }
        return valid;
    }

    public void checkException(JTextField[] userInfo, JTextArea psField)
    {
        int errorCnt = 0; // Store number of errors that the user makes
        String errorMsg = ""; // Store error message that would be shown on JOptionPane
        try {
            // Check if all the inputs are valid
            if(isValidName(userInfo[0].getText()) && isValidBirth(userInfo[1].getText())
                    && isValidNumber(userInfo[2].getText()) && isValidEmail(userInfo[3].getText())
                    && isValidDegree(userInfo[4].getText()) && isValidPS(psField.getText()) && isValidAddress(userInfo[8].getText()))
            {
                if(userInfo[4].getText().toLowerCase().equals("bachelor")) // If degree is bachelor
                {
                    if(userInfo[5].getText().equals("") && userInfo[6].getText().equals("") && userInfo[7].getText().equals("")) // Check if options for graduates are empty
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success Message\n", JOptionPane.PLAIN_MESSAGE);
                        for(int i = 0; i < userInfo.length; i++)
                        {
                            userInfo[i].setForeground(Color.black);
                        }
                        psField.setForeground(Color.black);
                    }
                    else
                    {
                        if(!userInfo[5].getText().equals("")) // If attended university column is not empty
                        {
                            errorCnt += 1; // Increase error count by one
                            errorMsg += (errorCnt + ". For undergraduate, attended university should be empty\n");
                            userInfo[5].setForeground(Color.red); // Set text in corresponding text field to red
                        }
                        if(!userInfo[6].getText().equals("")) // If GPA column is not empty
                        {
                            errorCnt += 1; // Increase error count by one
                            errorMsg += (errorCnt + ". For undergraduate, GPA should be empty\n");
                            userInfo[6].setForeground(Color.red); // Set text in corresponding text field to red
                        }
                        if(!userInfo[7].getText().equals("")) // If laboratory column is not empty
                        {
                            errorCnt += 1; // Increase error count by one
                            errorMsg += (errorCnt + ". For undergraduate, laboratory should be empty\n");
                            userInfo[7].setForeground(Color.red); // Set text in corresponding text field to red
                        }
                        JOptionPane.showMessageDialog(null, errorMsg, "You have following problems:", JOptionPane.ERROR_MESSAGE); // Show error messages
                    }
                }
                else if(userInfo[4].getText().toLowerCase().equals("master") || userInfo[4].getText().toLowerCase().equals("ph.d")) // If degree is master or ph.d
                {
                    if(isValidUni(userInfo[5].getText()) && isValidGPA(userInfo[6].getText()) && isValidLab(userInfo[7].getText())) // Check if options for graduates are not empty
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success Message\n", JOptionPane.PLAIN_MESSAGE);
                        for(int i = 0; i < userInfo.length; i++)
                        {
                            userInfo[i].setForeground(Color.black);
                        }
                        psField.setForeground(Color.black);
                    }
                    else
                    {
                        if(userInfo[5].getText().equals("") || userInfo[6].getText().equals("") || userInfo[7].getText().equals("")) // If any of columns for graduates is empty
                        {
                            errorCnt += 1; // Increase error count by one
                            errorMsg += (errorCnt + ". For graduate, you have to enter previous university, GPA, and laboratory name\n");
                            userInfo[4].setForeground(Color.red); // Set text in corresponding text field to red
                        }
                        else
                        {
                            userInfo[4].setForeground(Color.black);
                            if(!isValidUni(userInfo[5].getText())) // If attended university column is not in proper format
                            {
                                errorCnt += 1; // Increase error count by one
                                errorMsg += (errorCnt + ". Your university name must not be empty\n");
                                userInfo[5].setForeground(Color.red); // Set text in corresponding text field to red
                            }
                            else
                            {
                                userInfo[5].setForeground(Color.black); // Set text in corresponding text field to black
                            }
                            if(!isValidUni(userInfo[6].getText())) // If GPA column is not in proper format
                            {
                                errorCnt += 1; // Increase error count by one
                                errorMsg += (errorCnt + ". Your GPA must be between 0 and 4.5\n");
                                userInfo[6].setForeground(Color.red); // Set text in corresponding text field to red
                            }
                            else
                            {
                                userInfo[6].setForeground(Color.black); // Set text in corresponding text field to black
                            }
                            if(!isValidUni(userInfo[7].getText())) // If laboratory column is not in proper format
                            {
                                errorCnt += 1; // Increase error count by one
                                errorMsg += (errorCnt + ". Your laboratory name must not be empty\n");
                                userInfo[7].setForeground(Color.red); // Set text in corresponding text field to red
                            }
                            else
                            {
                                userInfo[7].setForeground(Color.black); // Set text in corresponding text field to black
                            }
                        }
                        JOptionPane.showMessageDialog(null, errorMsg, "You have following problems:", JOptionPane.ERROR_MESSAGE); // Show error messages
                    }
                }
            }
            else
            {
                throw new Exception();
            }
        }
        catch (Exception e1)
        {
            if(!isValidName(userInfo[0].getText())) // If applicant name column is not in proper format
            {
                errorCnt += 1; // Increase error count by one
                errorMsg += (errorCnt + ". You forgot to write your name or surname.\n");
                userInfo[0].setForeground(Color.red); // Set text in corresponding text field to red
            }
            else
            {
                userInfo[0].setForeground(Color.black); // Set text in corresponding text field to black
            }
            if(!isValidBirth(userInfo[1].getText())) // If birthdate column is not in proper format
            {
                errorCnt += 1; // Increase error count by one
                errorMsg += (errorCnt + ". Birth date must be in 'dd/mm/yyyy' format.\n");
                userInfo[1].setForeground(Color.red); // Set text in corresponding text field to red
            }
            else
            {
                userInfo[1].setForeground(Color.black); // Set text in corresponding text field to black
            }
            if(!isValidNumber(userInfo[2].getText())) // If phone number column is not in proper format
            {
                errorCnt += 1; // Increase error count by one
                errorMsg += (errorCnt + ". Phone number must be 'xxx-xxx-xxxx' or 'xxx-xxxx-xxxx' format.\n");
                userInfo[2].setForeground(Color.red); // Set text in corresponding text field to red
            }
            else
            {
                userInfo[2].setForeground(Color.black); // Set text in corresponding text field to black
            }
            if(!isValidEmail(userInfo[3].getText())) // If email column is not in proper format
            {
                errorCnt += 1; // Increase error count by one
                errorMsg += (errorCnt + ". Email must be 'example@xxxx.xxx' format.\n");
                userInfo[3].setForeground(Color.red); // Set text in corresponding text field to red
            }
            else
            {
                userInfo[3].setForeground(Color.black); // Set text in corresponding text field to black
            }
            if(!isValidDegree(userInfo[4].getText())) // If degree column is not in proper format
            {
                errorCnt += 1; // Increase error count by one
                errorMsg += (errorCnt + ". Your degree should be 'Bachelor' or 'Master' or 'Ph.D'.\n");
                userInfo[4].setForeground(Color.red); // Set text in corresponding text field to red
            }
            else
            {
                userInfo[4].setForeground(Color.black); // Set text in corresponding text field to black
                if(userInfo[4].getText().toLowerCase().equals("master") || userInfo[4].getText().toLowerCase().equals("ph.d"))
                {
                    if(userInfo[5].getText().equals("") || userInfo[6].getText().equals("") || userInfo[7].getText().equals("")) // If any of columns for graduates is empty
                    {
                        errorCnt += 1; // Increase error count by one
                        errorMsg += (errorCnt + ". For graduate, you have to enter previous university, GPA, and laboratory name\n");
                        userInfo[4].setForeground(Color.red); // Set text in corresponding text field to red
                    }
                    else
                    {
                        userInfo[4].setForeground(Color.black);
                        if(!isValidUni(userInfo[5].getText())) // If attended university column is not in proper format
                        {
                            errorCnt += 1; // Increase error count by one
                            errorMsg += (errorCnt + ". Your university name must not be empty\n");
                            userInfo[5].setForeground(Color.red); // Set text in corresponding text field to red
                        }
                        else
                        {
                            userInfo[5].setForeground(Color.black); // Set text in corresponding text field to black
                        }
                        if(!isValidUni(userInfo[6].getText())) // If GPA column is not in proper format
                        {
                            errorCnt += 1; // Increase error count by one
                            errorMsg += (errorCnt + ". Your GPA must be between 0 and 4.5\n");
                            userInfo[6].setForeground(Color.red); // Set text in corresponding text field to red
                        }
                        else
                        {
                            userInfo[6].setForeground(Color.black); // Set text in corresponding text field to black
                        }
                        if(!isValidUni(userInfo[7].getText())) // If laboratory column is not in proper format
                        {
                            errorCnt += 1; // Increase error count by one
                            errorMsg += (errorCnt + ". Your laboratory name must not be empty\n");
                            userInfo[7].setForeground(Color.red); // Set text in corresponding text field to red
                        }
                        else
                        {
                            userInfo[7].setForeground(Color.black); // Set text in corresponding text field to black
                        }
                    }
                }
            }
            if(!isValidPS(psField.getText())) // If personal statement column is not in proper format
            {
                errorCnt += 1; // Increase error count by one
                errorMsg += (errorCnt + ". Your personal statement must be at least 100 words.\n");
                psField.setForeground(Color.red); // Set text in corresponding text field to red
            }
            else
            {
                psField.setForeground(Color.black); // Set text in corresponding text field to black
            }
            if(!isValidAddress(userInfo[8].getText())) // If home address column is not in proper format
            {
                errorCnt += 1; // Increase error count by one
                errorMsg += (errorCnt + ". Your address must be in 'number, street, district, city' format.\n");
                userInfo[8].setForeground(Color.red); // Set text in corresponding text field to red
            }
            else
            {
                userInfo[8].setForeground(Color.black); // Set text in corresponding text field to black
            }
            JOptionPane.showMessageDialog(null, errorMsg, "You have following problems:", JOptionPane.ERROR_MESSAGE); // Show error messages
        }
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
                JTextField[] userInfo = {
                        nameField,
                        birthField,
                        phoneField,
                        emailField,
                        degreeField,
                        universityField,
                        gpaField,
                        labField,
                        addressField
                };

                checkException(userInfo, psField);
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
