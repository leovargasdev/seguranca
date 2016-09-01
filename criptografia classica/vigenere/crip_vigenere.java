import java.io.*;
import java.nio.file.*;
class crip_vigenere{
    public static void main(String [] agrs) throws IOException{
        byte[] chico = Files.readAllBytes(Paths.get("1.input"));
        FileOutputStream w = new FileOutputStream(new File("outputs/out_crip.txt"));
        byte[] chavethefenda = "abcd".getBytes();
        int a = 0;
        while(a < chico.length)
            for(int k = 0; k < chavethefenda.length && a < chico.length; k++, a++)
                chico[a] = (byte)((chico[a] + chavethefenda[k])%256);
        w.write(chico);
        w.close();
    }
}
