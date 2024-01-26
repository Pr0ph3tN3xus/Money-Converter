import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    // set up GUI and variables
    final int FRAME_WIDTH = 300;
    final int FRAME_HEIGHT = 150;

    JLabel heading;
    JLabel moneyPrompt;
    JTextField moneyField;
    JButton button;
    JLabel response;

    public Main() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        heading = new JLabel("Super Duper Money Converter");
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

        moneyPrompt = new JLabel("Enter an Amount");
        moneyField = new JTextField(12);

        button = new JButton("Click to Calculate");
        response = new JLabel("");

        setLayout(new FlowLayout());
        add(heading);
        add(moneyPrompt);
        add(moneyField);
        add(button);
        add(response);

        // Register ActionListener for the button
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Use double to handle decimal values
            double dosh = Double.parseDouble(moneyField.getText());

            // money conversion logic
            double quarters = (dosh - (dosh % .25))/.25;
            String amount = (int)Math.round(quarters) + " quarter(s)";
            if ((dosh % .25) >= .10) {
                double dimes = (dosh % .25) / .10;
                amount += ", " + (int)Math.round(dimes) + " dime(s)";
            }
            if ((dosh % .25) < .10) {
                double nickels = (dosh % .25) / .05;
                amount += ", " + (int)Math.round(nickels) + " nickel(s)";

            }


            // display the entered amount
            response.setText(amount);
        } catch (NumberFormatException ex) {
            // Handle the case where the entered value is not a valid number
            response.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        // Create an instance of Main class and make it visible
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}