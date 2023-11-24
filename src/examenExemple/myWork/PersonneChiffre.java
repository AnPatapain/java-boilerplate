package examenExemple.myWork;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class PersonneChiffre extends Personne{
	private String encryptedNom;
	
	public PersonneChiffre(String nom, int year, int month, int day, String password) {
		super(nom, year, month, day);
		encryptData(password, nom);
	}
	
	private void encryptData(String password, String nom) {
		try {
			SecretKey secretKey = PrimitiveAES.getKeyFromPassword(password, "sel");
			IvParameterSpec iv = PrimitiveAES.generateIv();
			this.encryptedNom = PrimitiveAES.encrypt("AES/ECB/PKCS5Padding", nom, secretKey, iv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getNom() {
		return encryptedNom;
	}
	
	public String getEncryptedNom() {
		return encryptedNom;
	}
	
	public String getNom(String password) {
		try {
			SecretKey secretKey = PrimitiveAES.getKeyFromPassword(password, "sel");
			return PrimitiveAES.decrypt("AES/ECB/PKCS5Padding", encryptedNom, secretKey, PrimitiveAES.generateIv());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
