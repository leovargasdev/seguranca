import java.io.*;
import java.security.*;
import javax.crypto.*;
class rsa{
	public static String texto = "Pizza é vida!";
	public static Cipher cipher;
	public static void main(String[] args) throws Exception{
		cipher = Cipher.getInstance("RSA");
		/* ------------ Criptografar ------------*/
		ObjectInputStream a = new ObjectInputStream(new FileInputStream("keys/public"));
		PublicKey publicKey = (PublicKey) a.readObject();
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] cipherText = cipher.doFinal(texto.getBytes());
		System.out.println("\nTEXTO: " + texto);
		System.out.println("-------------------------------");
		for(int k = 0; k < cipherText.length; k++)
			System.out.print(" " + cipherText[k]);
		/* ------------ Descriptografar ------------*/
		ObjectInputStream b = new ObjectInputStream(new FileInputStream("keys/private"));
		PrivateKey privateKey = (PrivateKey) b.readObject();
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		System.out.println("-------------------------------");
		System.out.println("TEXTO DESCRIPTOGRAFADO: " + new String(cipher.doFinal(cipherText)) + "\n");
	}
}
