import java.io.*;
import java.nio.file.*;
class descrip_vigenere{
    public static void main(String [] agrs) throws IOException{
        byte[] chico = Files.readAllBytes(Paths.get("outputs/out_crip.txt"));
        FileOutputStream w = new FileOutputStream(new File("outputs/out_descrip.txt"));
        byte[] chavethefenda = "abcd".getBytes();// chave em string passando para um vetor de bytes
        int a = 0;
        while(a < chico.length)
            for(int k = 0; k < chavethefenda.length && a < chico.length; k++, a++)
                chico[a] = (byte)((chico[a] - chavethefenda[k])%256);
        w.write(chico);
        w.close();
    }
}
