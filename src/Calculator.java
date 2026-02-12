import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import net.miginfocom.swing.MigLayout;


public class Calculator extends JFrame {

    private JLabel lblPrompt;
    // private JTextField txtInput;
    private JTextArea txtOutput;

    // Store totals per seat type
    private static class SeatStats {
        int ticketsSold = 0;
        double price = 0.0;     // last entered price for display
        double total = 0.0;     // ticketsSold * price summed over entries
    }
  
    public Calculator() {
        this.setSize(500, 600);
        this.setLocation(100, 100);
        this.setTitle("Concert Ticket Calculator");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // setting up top panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("debug"));  
        mainPanel.setBorder(new TitledBorder("Enter Seat Data"));
        this.add(mainPanel);
        setVisible(true);

        // JLabel Object
        lblPrompt = new JLabel("Enter for seat:");
        mainPanel.add(lblPrompt);

        // JTextField Object
        JTextField txtType = new JTextField(10);
        mainPanel.add(txtType, "growx");

        // Second JTextField Object
        JTextField txtCount = new JTextField(10);
        mainPanel.add(txtCount, "growx");

        JTextField txtPrice = new JTextField(10);
        mainPanel.add(txtPrice, "growx, wrap");

        // JTextArea Object
        txtOutput = new JTextArea();
        txtOutput = new JTextArea(8, 30);
        txtOutput.setLineWrap(true);
        txtOutput.setWrapStyleWord(true);
        txtOutput.setEditable(false);
        txtOutput.setBackground(Color.WHITE);
        mainPanel.add(txtOutput, "span 3, grow,");
    }

    //public TopPanelBuild() {
    //    
    //}

    public static void main(String[] args) throws Exception {
        new Calculator();   
    }

}
