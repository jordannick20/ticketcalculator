import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import net.miginfocom.swing.MigLayout;




public class Window extends JFrame {

    private JTextField txtType;
    private JTextField txtCount;
    private JTextField txtPrice;

    private JTextArea txtOutput;

    private JButton btnSubmit;


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


        // JTextArea Object
        JTextArea txtOutput = new JTextArea();
        txtOutput.setLineWrap(true);
        txtOutput.setWrapStyleWord(true);
        txtOutput.setEditable(false);
        txtOutput.setBackground(Color.WHITE);
        mainPanel.add(txtOutput);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Window().setVisible(true);  
    }

}
