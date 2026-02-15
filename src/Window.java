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
        JPanel mainPanel = new JPanel(new MigLayout());
        setContentPane(mainPanel); 

        // top panel for seat data
        JPanel panelInput = new JPanel(new MigLayout());
        panelInput.setBorder(new TitledBorder("Enter Seat Data"));

        // Row 1 headers
        panelInput.add(new JLabel()); 
        panelInput.add(new JLabel());
        panelInput.add(new JLabel());
        panelInput.add(new JLabel());

          // Row 2 inputs
        panelInput.add(new JLabel("Enter for Seat:"));
        txtType = new JTextField();
        panelInput.add(txtType);
        txtCount = new JTextField();
        panelInput.add(txtCount);
        txtPrice = new JTextField();
        panelInput.add(txtPrice, "wrap");

        // Row 3 submit button aligned under fields
        btnSubmit = new JButton("Submit Data");
        panelInput.add(new JLabel(""));
        panelInput.add(btnSubmit);

        mainPanel.add(panelInput);

        // Middle panel
        JPanel pnlOutput = new JPanel(new MigLayout());
        pnlOutput.setBorder(new TitledBorder("Seat Sales Report"));

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        // monospaced for JTextArea
        txtOutput.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        txtOutput.setPreferredSize(new Dimension(400, 300));
        pnlOutput.add(txtOutput);
        mainPanel.add(pnlOutput);


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

    public static void main(String[] args) throws Exception {
        new Window().setVisible(true);  
    }

}
