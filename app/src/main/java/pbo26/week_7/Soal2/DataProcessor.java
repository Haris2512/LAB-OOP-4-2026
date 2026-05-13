package Soal2;

import java.util.Random;

public class DataProcessor {

    public int process(String fileName) {
        Random random = new Random();

        try {
            int delay =
                    random.nextInt(1501) + 500; // delay antara 500ms hingga 2000ms

            Thread.sleep(delay);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return random.nextInt(901) + 100;
    }
}