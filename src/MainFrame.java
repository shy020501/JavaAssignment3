import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private int[] frameSize = {1000, 800};

    public MainFrame(){

        ImageIcon skkuWallpaper = new ImageIcon("src/images/skku_wallpaper.png"); // Wallpaper of the program
        Image skkuWallpaperImage = skkuWallpaper.getImage(); // Get image from image icon

        // Resize the image
        skkuWallpaperImage = skkuWallpaperImage.getScaledInstance(
                (frameSize[0] / 3) + frameSize[0] / 20,
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
