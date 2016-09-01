import java.io.*;
import java.nio.file.*;
class descrip_cesar{
    public static void main(String [] agrs) throws IOException{
        int key = 17;
        byte[] juca = Files.readAllBytes(Paths.get("outputs/out_crip.txt"));// lendo arquivo criptografado
        FileOutputStream w = new FileOutputStream(new File("outputs/out_descrip.txt"));
        for(int oxa = 0; oxa < juca.length; oxa++)
            juca[oxa] = (byte)((juca[oxa] - key)%256);
        w.write(juca);
        w.close();
    }
}
