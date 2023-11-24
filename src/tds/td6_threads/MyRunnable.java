package tds.td6_threads;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;


public class MyRunnable implements Runnable {
	AtomicBoolean isKeyDetected;
	AtomicReference<SecretKey> detected_secretKey;
	List<String> passAndSalts;
	String pass_stagaire_hashed;
	int start;
	int end;
	
	public MyRunnable(AtomicBoolean isKeyDetected, AtomicReference<SecretKey> detected_secretKey, 
			List<String> passAndSalts, String pass_stagaire_hashed,
			int start, int end) {
		
		this.isKeyDetected = isKeyDetected;
		this.detected_secretKey = detected_secretKey;
		this.passAndSalts = passAndSalts;
		this.pass_stagaire_hashed = pass_stagaire_hashed;
		this.start = start;
		this.end = end;
		
	}
	
	public SecretKey findSecretKey(String password, String salt, String pass_stagaire_hashed) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKey secretKey = PrimitivesAES.getKeyFromPassword(password, salt);
        IvParameterSpec iv = PrimitivesAES.generateIv();
        String sangoku_hashed = PrimitivesAES.encrypt("AES/ECB/PKCS5Padding", "sangoku", secretKey, iv);
        if(sangoku_hashed.equals(pass_stagaire_hashed)) {
            return secretKey;
        }
        return null;
    }

	@Override
	public void run() {
		System.out.println("Start: " + Thread.currentThread().getName());
        if(isKeyDetected.get()) return;

        for(int j = start; j <= end; j++) {
            for(String salt : passAndSalts) {
                try {
                    SecretKey secretKey = findSecretKey(passAndSalts.get(j), salt, pass_stagaire_hashed);
                    if (secretKey != null) {
                        detected_secretKey.set(secretKey);
                        isKeyDetected.set(true);
                        return;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
	}
	
}