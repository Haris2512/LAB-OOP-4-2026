package tuprak6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    List<String> logs;

    public LibraryLogger () {
        this.logs = new ArrayList<>();
    }

    public String logActivity (String activity) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fixWaktu = now.format(formatter);
        
        // menggabungkan waktu dan aktivitas, lalu simpan ke list
        String fullLog = fixWaktu + " " + activity;
        this.logs.add(fullLog);

        return fullLog;
    }

    // getLogs: mengembalikan semua log sebagai string
    public String getLogs () {
        if (logs.isEmpty()) {
            return "Belum ada aktivitas tercatat";
        }

        String hasil = "";

        // ===== 1. LOG ASLI =====
        for (String log : logs) {
            hasil += log + "\n";
        }

        // ===== 2. RANGKUMAN =====
        hasil += "\nRangkuman:\n";
        hasil += "Dipinjam pada        | Judul                     | Member        | Dikembalikan pada\n";
        hasil += "------------------------------------------------------------------------------------------\n";

        for (String logPinjam : logs) {

            // ambil hanya yang dipinjam
            if (logPinjam.contains("dipinjam oleh")) {

                // contoh:
                // 2026-05-06 08:32:22 Item al dipinjam oleh talis

                String waktuPinjam = logPinjam.substring(0, 19);

                // ambil judul
                String kataHabisItem = logPinjam.split("Item ")[1];
                String judul = kataHabisItem.split(" dipinjam")[0];

                // ambil member
                String member = logPinjam.split("oleh ")[1];

                String waktuKembali = "-";

                // cari untuk kembalikan
                for (String logKembali : logs) {
                    if (logKembali.contains("dikembalikan oleh") &&
                        logKembali.contains(judul) &&
                        logKembali.contains(member)) {

                        waktuKembali = logKembali.substring(0, 19);
                        break;
                    }
                }

                hasil += String.format("%-20s | %-25s | %-12s | %-20s\n",
                        waktuPinjam, judul, member, waktuKembali);
            }
        }

        return hasil;
    }

    public void clearLogs () {
        this.logs.clear();
    }
}
