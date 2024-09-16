import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField textField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    public Main() {
        textField.setBounds(113, 247, 374, 55);
        textField.setBackground(new Color(216, 216, 216));
        textField.setFont(new Font(textField.getFont().getName(), textField.getFont().getStyle(), 16));

        passwordField.setBounds(113, 339, 374, 55);
        passwordField.setBackground(new Color(216, 216, 216));
        passwordField.setFont(new Font(textField.getFont().getName(), textField.getFont().getStyle(), 16));

        JButton submitButton;
        submitButton = button("Submit", 435, e -> {
            if (textField.getText().isEmpty() || passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(frame, "Field empty, enter username and password");
            } else {
                JOptionPane.showMessageDialog(frame, "You have logged in!");
                textField.setText("");
                passwordField.setText("");
            }
        });

        JButton helpButton = button("Need Help", 496, e -> {
            panel.add(new HelpPopup());

            submitButton.setForeground(Color.black);
            frame.getRootPane().setDefaultButton(submitButton);
        });

        panel.setLayout(null);
        panel.setBackground(new Color(57, 54, 70));
        panel.add(label("<html><font color='white' size='53'>Login</font></html>", 248, 146, 106, 52));
        panel.add(label("<html><font color='white'>Username</font></html>", 125, 225, 70, 22));
        panel.add(label("<html><font color='white'>Password</font></html>", 125, 317, 80, 22));
        panel.add(textField);
        panel.add(passwordField);
        panel.add(submitButton);
        panel.add(helpButton);

        frame.setPreferredSize(new Dimension(600, 750));
        frame.setResizable(false);
        frame.getRootPane().setDefaultButton(submitButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Page");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private Component label(String label, int x, int y, int width, int height) {
        JLabel jLabel = new JLabel(label);
        jLabel.setBounds(x, y, width, height);
        return jLabel;
    }

    private JButton button(String buttonText, int verticalPosition, ActionListener action) {
        JButton jButton = new JButton(buttonText);
        jButton.setBounds(204, verticalPosition, 193, 41);
        jButton.addActionListener(action);
        return jButton;
    }

    public static void main(String[] args) {
        new Main();
    }
}