import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingNumberGameSwing {

    private int number;
    private int attempts;
    private static final int MAX_ATTEMPTS = 5;

    public GuessingNumberGameSwing() {
        number = 1 + (int)(100 * Math.random());
        attempts = 0;

        JFrame frame = new JFrame("Guessing Number Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        JLabel messageLabel = new JLabel("Guess the number between 1 to 100 within 5 trials:");
        messageLabel.setBounds(10, 10, 280, 30);
        frame.add(messageLabel);

        JTextField guessField = new JTextField();
        guessField.setBounds(10, 50, 100, 30);
        frame.add(guessField);

        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(120, 50, 100, 30);
        frame.add(guessButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 90, 250, 30);
        frame.add(resultLabel);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess;
                try {
                    guess = Integer.parseInt(guessField.getText());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                    return;
                }

                attempts++;

                if (number == guess) {
                    resultLabel.setText("Congratulations! You guessed the number.");
                    guessButton.setEnabled(false);
                } else if (attempts < MAX_ATTEMPTS) {
                    if (number > guess) {
                        resultLabel.setText("The number is greater than " + guess);
                    } else {
                        resultLabel.setText("The number is less than " + guess);
                    }
                } else {
                    resultLabel.setText("You have exhausted 5 trials. The number was " + number);
                    guessButton.setEnabled(false);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessingNumberGameSwing::new);
    }
}
