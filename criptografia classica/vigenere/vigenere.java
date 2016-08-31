import java.io.*;
import java.nio.file.*;
class cesar{
    public static void main(String [] agrs) throws IOException{
        Path path = Paths.get("1.input");
        byte[] tc = Files.readAllBytes(path);
        File f = new File("texto.txt");
        FileOutputStream w = new FileOutputStream(f);
        String chave = "abcd";
        int tamanho = chave.length();
        byte[] key = new byte[tamanho];
        for(int a = 0; a < tamanho; a++)
            key[a] = (byte)chave.charAt(a);
        int a = 0;
        while(a < tc.length){
            for(int k = 0; k < tamanho && a < tc.length; k++){
                tc[a] = (byte)((tc[a] + key[k])%256);
                a++;
            }
        }
        w.write(tc);
        w.close();
    }
}
