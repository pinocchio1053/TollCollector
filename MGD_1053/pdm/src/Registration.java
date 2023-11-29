import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Registration extends JFrame implements ActionListener {
    static HashMap<String, String> register_info = new HashMap<>();

    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel usernameLabel = new JLabel();

    JLabel passwordLabel = new JLabel();
    JLabel fnameLabel = new JLabel();
    JLabel lnameLabel = new JLabel();


    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    JTextField fnameTextField = new JTextField();
    JTextField lnameTextfield = new JTextField();
    JButton registrationButton = new JButton();
    JButton backButton = new JButton();
    private JLabel userLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;

    private JButton loginLoginButton;
    private JButton loginBackButton;

    public Registration() {
    }


    public void registration(){
        container.setLayout(null);

        usernameLabel.setText("Username");
        usernameLabel.setBounds(70, 20, 100, 50);
        container.add(usernameLabel);

        passwordLabel.setText("Password");
        passwordLabel.setBounds(70, 70, 100, 50);
        container.add(passwordLabel);
        fnameLabel.setText("Fast Name: ");
        fnameLabel.setBounds(70,120,100,50);
        container.add(fnameLabel);
        lnameLabel.setText("Last Name: ");
        lnameLabel.setBounds(70,170,100,50);
        container.add(lnameLabel);


        usernameTextField.setBounds(170, 33, 150, 30);
        container.add(usernameTextField);

        passwordTextField.setBounds(170, 83, 150, 30);
        container.add(passwordTextField);

        fnameTextField.setBounds(170, 133, 150, 30);
        container.add(fnameTextField);

       lnameTextfield.setBounds(170,183,150,30);
       container.add(lnameTextfield);

        registrationButton.setText("Register");
        registrationButton.setBounds(60, 220, 150, 30);
        registrationButton.setFocusable(false);
        registrationButton.addActionListener(this);
        container.add(registrationButton);

        backButton.setText("Back");
        backButton.setBounds(240, 220, 150, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        container.add(backButton);


        frame.add(container);
        frame.setTitle("Registration");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void login(){
        container = getContentPane();
        container.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 20, 100, 30);
        container.add(userLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 70, 100, 30);
        container.add(passwordLabel);



        userTextField = new JTextField();
        userTextField.setBounds(150, 20, 150, 30);
        container.add(userTextField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        container.add(passwordField);

        loginLoginButton = new JButton("Login");
        loginLoginButton.setBounds(50, 120, 100, 30);
        loginLoginButton.addActionListener(this);
        container.add(loginLoginButton);

        loginBackButton = new JButton("Back");
        loginBackButton.setBounds(200, 120, 100, 30);
        loginBackButton.addActionListener(this);
        container.add(loginBackButton);

        setTitle("Login Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registrationButton){
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            if(username.isEmpty()||password.isEmpty()){
                JOptionPane.showMessageDialog(this, "Missing Field");
                usernameTextField.setText("");
                passwordTextField.setText("");
                return;
            }
            if(register_info.containsKey(username)){
                JOptionPane.showMessageDialog(this, "Username Already Exists");
                usernameTextField.setText("");
                passwordTextField.setText("");
                return;
            }
            register_info.put(username,password);
            JOptionPane.showMessageDialog(this, "Registration Complete");
            usernameTextField.setText("");
            passwordTextField.setText("");
            frame.setVisible(false);
            new Menu();
        } else if (e.getSource()==backButton) {
            frame.setVisible(false);
            new Menu();
        }else if(e.getSource()==loginLoginButton){
            String username = userTextField.getText();
            String password = passwordField.getText();
            if(register_info.containsKey(username) && register_info.get(username).equals(password)){
                JOptionPane.showMessageDialog(this, "Login Successful");
                frame.setVisible(false);
                new TollMenu();
            }else {
                JOptionPane.showMessageDialog(this, "Wrong Username or Password");
                userTextField.setText("");
                passwordField.setText("");
            }

        } else if (e.getSource()==loginBackButton) {
            frame.setVisible(false);
            new Menu();
        }

    }
}
