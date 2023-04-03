import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class WebsiteOpener extends JFrame implements ActionListener {
    private JButton button;
    private JLabel label;
    
    public WebsiteOpener() {
        super("Website Opener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a button and add it to the frame
        button = new JButton("Open Google");
        button.addActionListener(this);
        getContentPane().add(button, BorderLayout.CENTER);
        
        // Create a label and add it to the frame
        label = new JLabel("Click the button to open Google.");
        getContentPane().add(label, BorderLayout.NORTH);
        
        // Set the size and make the frame visible
        setSize(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Open the website in the default browser when the button is clicked
        try {
            URI uri = new URI("https://www.google.com");
            Desktop.getDesktop().browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        WebsiteOpener frame = new WebsiteOpener();
    }
}
