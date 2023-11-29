import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SubmitData extends JFrame implements ActionListener {
    static ArrayList<String> carname = new ArrayList<>();
    static ArrayList<String> carserial = new ArrayList<>();
    static ArrayList<String> tollpoint = new ArrayList<>();
    static ArrayList<String> tollamount = new ArrayList<>();
    static ArrayList<String> tollcollectorsName = new ArrayList<>();
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel serialLabel = new JLabel();
    JLabel nameLabel = new JLabel();
    JLabel pointLabel = new JLabel();
    JLabel amountLabel = new JLabel();
    JLabel collectorsNameLabel = new JLabel();
    JTextField serialTextField = new JTextField();
    JTextField nameTextField = new JTextField();

    JTextField pointTextField = new JTextField();
    JTextField amountTextField = new JTextField();
    JTextField collectorsNameTextField = new JTextField();
    JButton saveButton = new JButton();
    JButton resetButton = new JButton();

    public void submitData(){
        container.setLayout(null);
        serialLabel.setText("Serial ");
        serialLabel.setBounds(70, 20, 100, 50);
        container.add(serialLabel);

        nameLabel.setText("Car Name");
        nameLabel.setBounds(70, 70, 100, 50);
        container.add(nameLabel);

        pointLabel.setText("Point");
        pointLabel.setBounds(70, 120, 100, 50);
        container.add(pointLabel);

        amountLabel.setText("Amount");
        amountLabel.setBounds(70, 170, 100, 50);
        container.add(amountLabel);

        collectorsNameLabel.setText("Collectors Name");
        collectorsNameLabel.setBounds(70, 220, 100, 50);
        container.add(collectorsNameLabel);

        serialTextField.setBounds(170, 33, 150, 30);
        container.add(serialTextField);

        nameTextField.setBounds(170, 83, 150, 30);
        container.add(nameTextField);

        pointTextField.setBounds(170, 133, 150, 30);
        container.add(pointTextField);

        amountTextField.setBounds(170, 183, 150, 30);
        container.add(amountTextField);

        collectorsNameTextField.setBounds(170, 233, 150, 30);
        container.add(collectorsNameTextField);

        saveButton.setText("Save");
        saveButton.setBounds(60, 275, 150, 30);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        container.add(saveButton);

        resetButton.setText("Back");
        resetButton.setBounds(240, 275, 150, 30);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        container.add(resetButton);



        frame.add(container);
        frame.setTitle("Set Candidate");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveButton){
            String serial = serialTextField.getText();
            String name = nameTextField.getText();
            String point = pointTextField.getText();
            String amount = amountTextField.getText();
            String collectorsName = collectorsNameTextField.getText();
            carname.add(name);
            carserial.add(serial);
            tollpoint.add(point);
            tollamount.add(amount);
            tollcollectorsName.add(collectorsName);
            JOptionPane.showMessageDialog(this,"Submit Successful");
            frame.setVisible(false);
            new TollMenu();
        } else if (e.getSource()==resetButton) {
            frame.setVisible(false);
            new TollMenu();
        }
    }
}
