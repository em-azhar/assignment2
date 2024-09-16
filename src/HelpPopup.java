import javax.swing.*;

public class HelpPopup extends JOptionPane {
    JPanel panel = new JPanel();

    public HelpPopup() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextField fName = new JTextField(15);
        JTextField lName = new JTextField(15);
        JTextField emailID = new JTextField(15);
        JTextArea issue = new JTextArea(5, 15);
        panel.add(new JLabel("First Name:"));
        panel.add(fName);
        panel.add(new JLabel("Last Name:"));
        panel.add(lName);
        panel.add(new JLabel("Email ID:"));
        panel.add(emailID);
        panel.add(new JLabel("Describe your issue:"));
        panel.add(issue);

        Object[] option = {"Submit"};

        int result = JOptionPane.showOptionDialog(
                null, panel,
                "Help", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, option, null);
        if (result == JOptionPane.OK_OPTION &&
                !fName.getText().isEmpty() &&
                !lName.getText().isEmpty() &&
                !emailID.getText().isEmpty() &&
                !issue.getText().isEmpty()
        ) {

            JOptionPane.showMessageDialog(panel,
                    "First Name: " + fName.getText() + "\n" +
                            "Last Name: " + lName.getText() + "\n" +
                            "Email ID: " + emailID.getText() + "\n" +
                            "Issue: " + issue.getText()
            );
            fName.setText("");
            lName.setText("");
            emailID.setText("");
            issue.setText("");
        }
    }

    public static void main(String[] args) {
        new HelpPopup();
    }
}
