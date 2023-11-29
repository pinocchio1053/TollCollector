import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TollMenu implements ActionListener {
    SubmitData submitData = new SubmitData();
    ViewData viewData = new ViewData();
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel labelText = new JLabel();
    JButton setCandidate = new JButton();
    JButton removeCandidate = new JButton();
    JButton viewCandidate = new JButton();
    JButton setWinner = new JButton();
    JButton viewVote = new JButton();
    JButton backButton = new JButton();

    public  TollMenu(){
        container.setLayout(null);
        labelText.setText("Welcome");
        labelText.setBounds(210, 20, 100, 50);
        container.add(labelText);

        setCandidate.setText("View Toll Rate");
        setCandidate.setBounds(180, 70, 150, 30);
        setCandidate.setFocusable(false);
        setCandidate.addActionListener(this);
        container.add(setCandidate);

        removeCandidate.setText("Toll Entry");
        removeCandidate.setBounds(180, 120, 150, 30);
        removeCandidate.setFocusable(false);
        removeCandidate.addActionListener(this);
        container.add(removeCandidate);

        viewCandidate.setText("Day Report");
        viewCandidate.setBounds(180, 170, 150, 30);
        viewCandidate.setFocusable(false);
        viewCandidate.addActionListener(this);
        container.add(viewCandidate);

        setWinner.setText("Back");
        setWinner.setBounds(180, 220, 150, 30);
        setWinner.setFocusable(false);
        setWinner.addActionListener(this);
        container.add(setWinner);

        frame.add(container);
        frame.setTitle("Admin Menu");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            frame.setVisible(false);
            new Menu();

        } else if (e.getSource()==setCandidate) {
            frame.setVisible(false);
            new TollRate();

        } else if (e.getSource()==viewCandidate) {
            frame.setVisible(false);
            viewData.viewDatareport();

        } else if (e.getSource()==removeCandidate) {
            frame.setVisible(false);
            submitData.submitData();

        } else if (e.getSource()==setWinner) {
            frame.setVisible(false);
            new Menu();
        }

    }

}
