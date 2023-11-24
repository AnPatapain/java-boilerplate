package tds.td6_threads;

import javax.crypto.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static List<String> getPassAndSalts(String filepath) {
        File file = new File(filepath);
        List<String> passAndSalts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
            String line;
            int count = 0;
            while((line = reader.readLine()) != null && count < 1000 ) {
                passAndSalts.add(line);
                count++;
            }
            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return passAndSalts;
    }
    
    
    public static void main(String[] args) throws Exception{
        List<String> passAndSalts = getPassAndSalts("/home/kean/eclipse-workspace/java-boilerplate/src/tds/td6_threads/passwords.txt");
        String pass_stagaire_hashed = "zyLj+eqxjzTh9eEz/Ga4Lw==";
        AtomicReference<SecretKey> detected_secretKey = new AtomicReference<>(null);

        int numThreads = Runtime.getRuntime().availableProcessors();
        
        List<Thread> threads = new ArrayList<>();
        AtomicBoolean isKeyDetected = new AtomicBoolean(false);
        int chunkedSize = passAndSalts.size() / numThreads;
        int remain = passAndSalts.size() % numThreads;
        
        for(int i = 0; i < numThreads; i++) {
            int start = i* ( chunkedSize + ( (i < remain) ? 1:0) );
            int end = start + ( chunkedSize + ( (i < remain) ? 1:0) ) - 1;
            
            Runnable runnable = new MyRunnable(isKeyDetected, detected_secretKey, passAndSalts, pass_stagaire_hashed, start, end);
            Thread thread = new Thread(runnable);
            
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to complete
        for(Thread thread : threads) {
            thread.join();
        }

        System.out.print("Secret Key detected: ");
        for(byte b : detected_secretKey.get().getEncoded()) {
            System.out.print(String.format("%02X", b));
        }
        System.out.println();

        String cible = "XLtXaPNv67TJqQ0d8xCiMR7oyVumZsn4nnVv3P/W4ZA=";
        String password_original = PrimitivesAES.decrypt("AES/ECB/PKCS5Padding", cible, detected_secretKey.get(), null);
        System.out.println("Password of bnguyen: " + password_original);
    }
}
