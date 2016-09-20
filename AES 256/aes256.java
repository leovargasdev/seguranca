import javax.crypto.spec.*;
import javax.crypto.*;
public class aes256{
	static String IV = "AAAAAAAAAAAAAAAA";
	static String texto = "Pizza é vida!";
	static String chaveencriptacao = "0123456789abcdef";
	static Cipher aes_256;
	public static byte[] encrypt() throws Exception {
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		aes_256.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
		return aes_256.doFinal(texto.getBytes("UTF-8"));
	}
	public static String decrypt(byte[] textoencriptado) throws Exception{
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		aes_256.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(aes_256.doFinal(textoencriptado),"UTF-8");
	}
	public static void main(String [] args) throws Exception{
		aes_256 = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		byte[] textoencriptado = encrypt();
		System.out.println("\nTexto: " + texto);
		System.out.println("-------------------------------");
		System.out.print("Encriptografado: ");
		for (int i = 0; i < textoencriptado.length; i++)
			 System.out.print(textoencriptado[i] + " ");
		System.out.println("\n-------------------------------");
		System.out.println("Decriptado: " + decrypt(textoencriptado) + "\n");
	}
}
