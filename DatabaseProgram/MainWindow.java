import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class HashyWindow {
    JFrame window = new JFrame();
    JPanel panel = new JPanel(null);

    public void removePanel() {
        this.panel.removeAll();
        this.window.setVisible(false);
    }
}

public class MainWindow extends HashyWindow {
    MainWindow() {
        // Add action for closing the window
        this.window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Window settings
        this.window.setTitle("Hashy");
        this.window.setSize(1280, 720);
        this.window.setLayout(null);
        this.window.setLocationRelativeTo(null);
    }

    /* Function for showing the main window */
    public void showHome(MainWindow h) {
        // Panel Elements
        panel.setBounds(0, 0, 1280, 720);

        Font titleFont = new Font("Sans_Serif", Font.BOLD, 96);
        Font subtitleFont = new Font("Sans_Serif", Font.PLAIN, 14);
        Font smallFont = new Font("Sans_Serif", Font.PLAIN, 18);
        Font tweetFont = new Font("Sans_Serif", Font.BOLD, 24);

        JLabel title = new JLabel("HASHY");
        title.setBounds(480, 40, 340, 200);
        title.setFont(titleFont);
        panel.add(title);

        JLabel subtitle = new JLabel("A tweet analysis system");
        subtitle.setBounds(570, 150, 150, 100);
        subtitle.setFont(subtitleFont);
        panel.add(subtitle);

        JLabel inputTitle = new JLabel("Enter a hashtag to get started!");
        inputTitle.setBounds(520, 250, 250, 100);
        inputTitle.setFont(smallFont);
        panel.add(inputTitle);

        JTextField inputTweet = new JTextField();
        inputTweet.setBounds(320, 320, 650, 60);
        inputTweet.setHorizontalAlignment(JTextField.CENTER);
        inputTweet.setFont(tweetFont);
        // Show the tweet analysis and result window when user inputs data and presses enter
        inputTweet.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        Action analyzeHashtag = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputTweet.getText().equals("")) JOptionPane.showMessageDialog(null, "Please enter a valid hashtag!", "Error", JOptionPane.ERROR_MESSAGE);
                else {
                    // Get string from user input
                    String input = inputTweet.getText();
                    input = input.replaceAll("#", "");

                    // Create the analysis object, will automatically analyze the hashtag
                    AnalysisWindow load = new AnalysisWindow(input);
                    
                    // Remove the main window and show the result window
                    removePanel();
                    new ResultWindow(h, load.data, window, panel, input);
                    window.setVisible(true);
                    load.window.setVisible(false);
                    load.window.setVisible(true);
                    
                }
            }
        };
        inputTweet.getActionMap().put("Enter", analyzeHashtag);
        inputTweet.addActionListener(analyzeHashtag);
        panel.add(inputTweet);

        // Add panel to window and display
        this.window.add(panel);
        this.window.setVisible(true);
    }
    
    public static void main(String[] args) throws IOException { 
        MainWindow hashy = new MainWindow();
        hashy.showHome(hashy);
    }
}