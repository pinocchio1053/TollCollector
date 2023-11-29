import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu extends JFrame implements ActionListener{

    Registration registration = new Registration();
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel menuLabel = new JLabel();
    JButton registrationButton= new JButton();
    JButton loginButton = new JButton();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registrationButton){
            registration.registration();
            frame.setVisible(false);
        } else if (e.getSource()==loginButton) {
            registration.login();
            frame.setVisible(false);
        }
    }
    public Menu(){
        container.setLayout(null);
        menuLabel.setText("Main Menu");
        menuLabel.setBounds(200, 20, 100, 50);
        container.add(menuLabel);


        registrationButton.setText("Registration");
        registrationButton.setBounds(180, 70, 150, 30);
        registrationButton.setFocusable(false);
        registrationButton.addActionListener(this);
        container.add(registrationButton);

        loginButton.setText("Login");
        loginButton.setBounds(180, 120, 150, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        container.add(loginButton);


        frame.add(container);
        frame.setTitle("Online Voting System");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}