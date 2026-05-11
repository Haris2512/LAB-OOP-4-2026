import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    
    private List<String[]> logs;

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

   
    public String logActivity(String activity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " " + activity;

        logs.add(new String[]{timestamp, activity, "-", "-"});
        return logEntry;
    }

    public void logBorrow(String timestamp, String title, String memberName) {
        logs.add(new String[]{timestamp, title, memberName, "-"});
    }

    
    public void logReturn(String title, String returnTime) {
        for (String[] log : logs) {
            if (log[1].equals(title) && log[3].equals("-")) {
                log[3] = returnTime;
                return;
            }
        }
    }

    public String getLogs() {
        if (logs.isEmpty()) {
            return "Belum ada aktivitas.";
        }

        int col1 = 20; 
        int col2 = 30; 
        int col3 = 15; 
        int col4 = 20;

        String sep = "+" + "-".repeat(col1) + "+" + "-".repeat(col2) + "+" + "-".repeat(col3) + "+" + "-".repeat(col4) + "+";
        StringBuilder sb = new StringBuilder();
        sb.append(sep).append("\n");
        sb.append(String.format("| %-" + (col1 - 2) + "s | %-" + (col2 - 2) + "s | %-" + (col3 - 2) + "s | %-" + (col4 - 2) + "s |%n",
                "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
        sb.append(sep).append("\n");

        for (String[] log : logs) {
            sb.append(String.format("| %-" + (col1 - 2) + "s | %-" + (col2 - 2) + "s | %-" + (col3 - 2) + "s | %-" + (col4 - 2) + "s |%n",
                    log[0], log[1], log[2], log[3]));
        }
        sb.append(sep);
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
        System.out.println("Log berhasil dikosongkan.");
    }

    public String getNowTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
