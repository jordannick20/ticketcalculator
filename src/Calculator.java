import javax.swing.*;


public class Calculator extends JFrame {

    // Store totals per seat type
    private static class SeatStats {
        int ticketsSold = 0;
        double price = 0.0;     // last entered price for display
        double total = 0.0;     // ticketsSold * price summed over entries
    }
  
    public Calculator() {
    
        
        JFrame jordanWindow = new JFrame();
        jordanWindow.setVisible(true);

        jordanWindow.setSize(400, 500);
        jordanWindow.setLocation(100, 100);
        jordanWindow.setTitle("Concert Ticket Calculator");
        System.out.println("hello");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
    }
    public static void main(String[] args) throws Exception {
        new Calculator();   
    }

}
