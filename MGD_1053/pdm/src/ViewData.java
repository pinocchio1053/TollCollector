import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewData extends JFrame implements ActionListener {

    SubmitData submitData = new SubmitData();
    JFrame frame = new JFrame();
    Container container = new Container();
    JButton backButton = new JButton("Back");

    public void  viewDatareport(){
        container.setLayout(null);
        String[] column={"Serial","Name","Point","Amount","Collectors Name"};
        if(submitData.carserial.isEmpty()){
            JOptionPane.showMessageDialog(this,"No Report");
            new TollMenu();
            return;
        }
        DefaultTableModel model = new DefaultTableModel(column, 0);
        for (int i = 0; i < submitData.carserial.size(); i++) {
            String serial = submitData.carserial.get(i);
            String name = submitData.carname.get(i);
            String point = submitData.tollpoint.get(i);
            String amount = submitData.tollamount.get(i);
            String collectorsname = submitData.tollcollectorsName.get(i);
            model.addRow(new Object[]{serial, name,point,amount,collectorsname});
        }

        backButton.setFocusable(false);
        backButton.addActionListener(this);
        JTable table = new JTable(model);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);


        frame.setTitle("View toll Rate");
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            frame.setVisible(false);
            new TollMenu();
        }
    }
}
