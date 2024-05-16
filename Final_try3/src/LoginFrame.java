import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private User user = new User();
    private HomeFrame frame;
    private JTextField tfUserName, tfPassword;
    private JButton btnEnroll, btnLogin;
    private JPanel panel;

    public LoginFrame() {
        setTitle("Login");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        tfUserName = new JTextField(20);
        tfUserName.setBounds(163, 5, 250, 26);
        tfPassword = new JTextField(20);
        tfPassword.setBounds(163, 5, 250, 26);

        btnLogin = new JButton("Login");
        btnEnroll = new JButton("Enroll");

        getContentPane().add(panel);
        setVisible(true);
        createLayout();

        Enroll();
        Login();
    }

    private void createLayout() {
        JPanel tPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String text = "Menstrual Care";
                Font font = new Font("Arial", Font.BOLD, 20);
                g.setFont(font);

                FontMetrics fontMetrics = g.getFontMetrics(font);
                int textWidth = fontMetrics.stringWidth(text);
                int textHeight = fontMetrics.getHeight();

                int x = (getWidth() - textWidth) / 2;
                int y = (getHeight() - textHeight) / 2 + fontMetrics.getAscent();

                g.setColor(new Color(176, 23, 31));
                g.drawString(text, x, y);
            }

            
            public Dimension getPreferredSize() {
                return new Dimension(400, 50); // Adjust height as needed
            }
        };

        JPanel uPanel = new JPanel();
        uPanel.setLayout(null);
        JLabel label = new JLabel("UserID:");
        label.setBounds(90, 10, 46, 16);
        uPanel.add(label);
        uPanel.add(tfUserName);

        JPanel pPanel = new JPanel();
        pPanel.setLayout(null);
        JLabel label_1 = new JLabel("Password:");
        label_1.setBounds(90, 10, 63, 16);
        pPanel.add(label_1);
        pPanel.add(tfPassword);

        JPanel bPanel = new JPanel();
        bPanel.add(btnEnroll);
        bPanel.add(btnLogin);

        panel.add(tPanel);
        panel.add(uPanel);
        panel.add(pPanel);
        panel.add(bPanel);
    }

    private void Enroll() {
        btnEnroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String username = tfUserName.getText();
                String password = tfPassword.getText();

                try {
                    user.add(username, password);

                } catch (UserError e1) {
                    JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.INFORMATION_MESSAGE);
                    e1.printStackTrace();
                } catch (PasswordError e1) {
                    JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.INFORMATION_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });
    }

    private void Login() {
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String username = tfUserName.getText();
                String password = tfPassword.getText();

                try {
                    user.checkUserExist(username);
                    user.checkPassword(username, password);
                    frame = new HomeFrame();
                    frame.showLabel(username);
                    frame.setVisible(true);
                    setVisible(false);
                } catch (UserError e2) {
                    JOptionPane.showMessageDialog(null, e2, "error", JOptionPane.INFORMATION_MESSAGE);
                    e2.printStackTrace();
                } catch (PasswordError e2) {
                    JOptionPane.showMessageDialog(null, e2, "error", JOptionPane.INFORMATION_MESSAGE);
                    e2.printStackTrace();
                }

            }
        });
    }
}
