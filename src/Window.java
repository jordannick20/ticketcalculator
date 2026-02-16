import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private JTextField txtType;
    private JTextField txtCount;
    private JTextField txtPrice;

    private JTextArea txtOutput;

    private JButton btnSubmit;
    private JButton btnSalesReport;
    private JButton btnTicketsReport;
    private JButton btnReset;

    // Data storage with array arrays only
    private static final int MAX_SEATS = 5;
    private Seat[] seats = new Seat[MAX_SEATS];
    // how many seats stored
    private int seatSize = 0; 

    public Window() {
        setSize(510, 520);
        setLocation(200, 150);
        setTitle("Concert Ticket Calculator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // setting up top panel
        JPanel mainPanel = new JPanel(new MigLayout("", "", "[]10[grow]10[]"));
        setContentPane(mainPanel); 

        // top panel for seat data
        JPanel panelInput = new JPanel(new MigLayout("", "[]10[fill]10[fill]10[fill]", ""));
        panelInput.setBorder(new TitledBorder("Enter Seat Data"));

        // Row 1 headers
        panelInput.add(new JLabel("")); 
        panelInput.add(new JLabel("Type       "));
        panelInput.add(new JLabel("Count      "));
        panelInput.add(new JLabel("Price ($)  "), " wrap");

          // Row 2 inputs
        panelInput.add(new JLabel("         Enter for Seat:  "));
        txtType = new JTextField();
        panelInput.add(txtType);
        txtCount = new JTextField();
        panelInput.add(txtCount);
        txtPrice = new JTextField();
        panelInput.add(txtPrice, "wrap");

        // Row 3 submit button aligned under fields
        btnSubmit = new JButton("Submit Data");
        panelInput.add(new JLabel(""));
        panelInput.add(btnSubmit, "span 3, align right");

        mainPanel.add(panelInput, "grow, wrap");

        // Middle panel
        JPanel pnlOutput = new JPanel(new MigLayout("fill"));
        pnlOutput.setBorder(new TitledBorder("Seat Sales Report"));

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        // monospaced for JTextArea
        txtOutput.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        txtOutput.setPreferredSize(new Dimension(400, 300));
        pnlOutput.add(txtOutput, "align center");
        mainPanel.add(pnlOutput,"grow, wrap");


        JPanel panelButtons = new JPanel(new MigLayout("", "[]85[]", ""));
        btnSalesReport = new JButton("Sales Report");
        btnTicketsReport = new JButton("Tickets Report");
        btnReset = new JButton("Reset");

        panelButtons.add(btnSalesReport);
        panelButtons.add(btnTicketsReport);
        panelButtons.add(btnReset);

        mainPanel.add(panelButtons);
        // ActionEvents
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSubmit(e);
            }
        });

        btnSalesReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtOutput.setText(Report.buildSalesReport(seats, seatSize));
            }
        });

        btnTicketsReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtOutput.setText(Report.buildTicketsReport(seats, seatSize));
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetAll();
            }
        });
        // Submit when pressing Enter in the price area
        txtPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    onSubmit(null);
                }
            }
        });
    }

    // Adds one Seat entry to the array
    private void onSubmit(ActionEvent e) {
        if (seatSize > 4) {
            disableInputs();
            return;
        }

        String type = txtType.getText();
        int count = Integer.parseInt(txtCount.getText());
        double price = Double.parseDouble(txtPrice.getText());
        
        seats[seatSize] = new Seat(type, count, price);
        seatSize++;

        // clear fields for next entry
        txtType.setText("");
        txtCount.setText("");
        txtPrice.setText("");

        // if max reached disable it
        if (seatSize > 4) {
            disableInputs();
        }
    }

    private void disableInputs() {
        txtType.setEnabled(false);
        txtCount.setEnabled(false);
        txtPrice.setEnabled(false);
        btnSubmit.setEnabled(false);
    }

    private void enableInputs() {
        txtType.setEnabled(true);
        txtCount.setEnabled(true);
        txtPrice.setEnabled(true);
        btnSubmit.setEnabled(true);
    }

    private void resetAll() {
        // clear data
        seats = new Seat[MAX_SEATS];
        seatSize = 0;

        txtType.setText("");
        txtCount.setText("");
        txtPrice.setText("");
        txtOutput.setText("");
        enableInputs();
    }

    public static void main(String[] args) throws Exception {
        new Window().setVisible(true);  
    }

}
