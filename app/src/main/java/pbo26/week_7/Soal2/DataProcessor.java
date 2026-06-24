import java.util.Random;

public class DataProcessor {
    public int process(String fileName) throws InterruptedException {
        Random random = new Random();
        int durasi = random.nextInt(1500) + 500; // 500ms - 2000ms
        Thread.sleep(durasi);
        
        // Return jumlah kata acak antara 100 - 1000
        return random.nextInt(900) + 100;
    }
}