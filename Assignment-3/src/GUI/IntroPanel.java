package GUI;

import javax.swing.*;
import java.awt.*;

public class IntroPanel extends JPanel {
    private JLabel nameLabel;
    private JButton displayBtn;
    private JLabel imageLabel;
    private ImageIcon introImage;

    public IntroPanel() {
        //Set font object
        Font myFont = new Font("Calibri", Font.BOLD, 22);

        //Set panel layout, visibility and background color
        setLayout(null);
        setVisible(true);
        setBackground(new Color(131,151,215));

        // Game title label centered at the top
        nameLabel = new JLabel("Dragons and Dungeons");
        nameLabel.setFont(myFont);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBounds(200, 10, 400, 50);

        // Game image loaded from resources
        introImage = new ImageIcon(this.getClass().getResource("/Images/dd_1400x.jpg"));
        imageLabel = new JLabel(introImage);
        imageLabel.setBounds(150, 50, 500, 500);

        // Button to proceed to character creation screen
        displayBtn = new JButton("Build A Character");
        displayBtn.setFont(myFont);
        displayBtn.setBounds(250, 600, 300, 50);

        //Add all controls to panel
        add(nameLabel);
        add(displayBtn);
        add(imageLabel);
    }

    // Getter for the button so MainFrame can add an action listener
    public JButton getDisplayBtn() {
        return displayBtn;
    }
}
