public class Report {

    // Sales Report string 
    public static String buildSalesReport(Seat[] seats, int size) {
        StringBuilder StringBuilder = new StringBuilder();

        StringBuilder.append(String.format("%-8s %12s %12s %12s%n",
                "","Tickets Sold", "Price", "Total"));
        StringBuilder.append("         ------------        -----        -----\n");
        
        double grandTotal = 0.0;

        for (int i = 0; i < size; i++) {
            Seat s = seats[i];
            grandTotal += s.getTotalSales();

            StringBuilder.append(String.format("%-1s %8d %22.2f %12.2f%n",s.getType(),s.getCount(),s.getPrice(),s.getTotalSales()));
        }
        StringBuilder.append("                                                \n");
        StringBuilder.append(String.format("%-1s %1.2f%n",
        
                "Total Sales:", grandTotal));

        return StringBuilder.toString();
    }

    // the Tickets Report string 
    public static String buildTicketsReport(Seat[] seats, int size) {
        StringBuilder StringBuilder = new StringBuilder();

        int totalTickets = 0;
        for (int i = 0; i < size; i++) {
            totalTickets += seats[i].getCount();
        }

        StringBuilder.append(String.format("%-16s %14s %14s%n",
                "Seat Type","Tickets Sold", "% of Tickets"));
        StringBuilder.append("-------------------------------------------------\n");

        for (int i = 0; i < size; i++) {
            Seat s = seats[i];

            double percent = 0.0;
            if (totalTickets > 0) {
                // calculating percent 
                percent = (s.getCount() * 100.0) / totalTickets;
            }

            StringBuilder.append(String.format("%-8s %14s %17.2f%%%n",s.getType(),s.getCount(),percent));
        }

        StringBuilder.append("                                                \n");
        StringBuilder.append(String.format("%-6s %1d%n", "Total Tickets:", totalTickets));

        return StringBuilder.toString();
    }
}
