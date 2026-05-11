import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    List<String> logs;
    final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String entry = LocalDateTime.now().format(FORMATTER) + " " + activity;
        logs.add(entry);
        return entry;
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Tidak ada log aktivitas.";
        StringBuilder sb = new StringBuilder();
        for (String log : logs) sb.append(log).append("\n");
        return sb.toString().trim();
    }

    public void clearLogs() {
        logs.clear();
    }
}