import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBot {

    public static void main(String[] args) {
        // Create a new JFrame (window) for the chatbot
        JFrame frame = new JFrame("ChatBot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);  // Set the window size

        // Set a custom background color for the window (Green background)
        frame.getContentPane().setBackground(new Color(144, 238, 144)); // Light green background

        // Set up the layout for the window
        frame.setLayout(new BorderLayout());

        // Create a JTextArea to show the conversation
        JTextArea conversationArea = new JTextArea();
        conversationArea.setEditable(false);  // Make it non-editable
        conversationArea.setText("Welcome to the ChatBot!\nHello! I am your friendly chatbot.\n");

        // Set a custom font and color for the conversation area
        conversationArea.setFont(new Font("Arial", Font.PLAIN, 14));  // Set font style and size
        conversationArea.setForeground(Color.WHITE);  // Set text color to white
        conversationArea.setBackground(new Color(255, 182, 193)); // Light pink background
        conversationArea.setBorder(BorderFactory.createLineBorder(new Color(255, 69, 0), 2));

        // Create a JTextField for the user to input text
        JTextField userInputField = new JTextField();
        userInputField.setFont(new Font("Arial", Font.PLAIN, 14));
        userInputField.setBackground(new Color(255, 228, 225)); // Light pink background for input field
        userInputField.setForeground(Color.WHITE); // White text color for user input
        userInputField.setBorder(BorderFactory.createLineBorder(new Color(255, 69, 0), 2)); // Custom border color

        // Custom label for "ChatBot" message at the top with a different color and font
        JLabel titleLabel = new JLabel("ChatBot", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));  // Font style and size for title
        titleLabel.setForeground(new Color(255, 69, 0));  // Set text color to red-orange
        titleLabel.setBackground(new Color(240, 240, 240));  // Set background to match window color
        titleLabel.setOpaque(true);  // Make the label background visible
        frame.add(titleLabel, BorderLayout.NORTH);

        // Create a JPanel to hold both the conversation area and input field
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a JScrollPane for the conversation area and add it to the panel
        JScrollPane conversationScrollPane = new JScrollPane(conversationArea);
        panel.add(conversationScrollPane, BorderLayout.CENTER);

        // Create a JPanel to hold the input field and add it to the panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(userInputField, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        // Add the entire panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Show the window
        frame.setVisible(true);

        // Listen for when the user presses 'Enter' in the input field
        userInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = userInputField.getText();
                conversationArea.append("\nYou: " + userInput + "\n");

                if (userInput.equalsIgnoreCase("exit")) {
                    conversationArea.append("Chatbot: Goodbye! Have a great day!\n");
                    System.exit(0);  // Close the program
                } else {
                    // Generate chatbot response
                    String response = generateResponse(userInput);
                    conversationArea.append("Chatbot: " + response + "\n");
                }

                // Scroll to the bottom of the conversation after each user input
                conversationArea.setCaretPosition(conversationArea.getDocument().getLength());

                // Clear the text field for the next input
                userInputField.setText("");
            }
        });
    }

    // Function to generate chatbot's response based on user input
    private static String generateResponse(String userInput) {
        if (userInput.contains("hello") || userInput.contains("hi")) {
            return "Hello! How can I assist you today?";
        } else if (userInput.contains("how are you")) {
            return "I'm just a bot, but I'm doing fine, thank you!";
        } else if (userInput.contains("name")) {
            return "I am ChatBot, your virtual assistant.";
        } else if (userInput.contains("bye") || userInput.contains("exit")) {
            return "Goodbye! It was nice chatting with you.";
        } else if (userInput.contains("weather")) {
            return "I can't check the weather, but I hope it's sunny where you are!";
        } else if (userInput.contains("favorite color")) {
            return "I don't have a favorite color, but I do like bright colors!";
        } else if (userInput.contains("time")) {
            return "I don't have access to the current time, but I hope you're enjoying your day!";
        } else if (userInput.contains("how old are you")) {
            return "I am timeless, just a program created to help you!";
        } else if (userInput.contains("joke")) {
            return "Why don't skeletons fight each other? They don't have the guts!";
        } else if (userInput.contains("good morning")) {
            return "Good morning! Hope you have a fantastic day ahead!";
        } else if (userInput.contains("good evening")) {
            return "Good evening! How's your day been so far?";
        } else {
            return "Sorry, I didn't quite understand that. Can you please rephrase?";
        }
    }
}
