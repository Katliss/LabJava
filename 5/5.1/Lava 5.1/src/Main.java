import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pathIn;
        ArrayList<Thread> threads = new ArrayList<>();
        PrintWriter printWriter;
        FileReadInNewThread fileReadInNewThread;
        try {
            printWriter = new PrintWriter("out.bat", "UTF-8");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 4; i++) {
            pathIn = "in_%s.bat".formatted(i);
            fileReadInNewThread = new FileReadInNewThread(pathIn, printWriter, i);
            Thread thread = new Thread(fileReadInNewThread);
            thread.start();
            System.out.println("Поток" + i + " создался");
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        printWriter.close();
        System.out.println("Завершение основного потока");
    }
}