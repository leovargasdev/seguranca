package cesar;
import java.io.*;
import java.nio.file.*;
public class cesar{
    public void criptografar(int key, byte [] juca) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("outputs/out_cesar.txt"));
        for(int oxa = 0; oxa < juca.length; oxa++)
            juca[oxa] = (byte)(( juca[oxa] + key)%256);
        w.write(juca);
        w.close();
    }
    public void descriptografar(int key, byte [] juca) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("outputs/out_cesar_des.txt"));
        for(int oxa = 0; oxa < juca.length; oxa++)
            juca[oxa] = (byte)(( juca[oxa] - key)%256);
        w.write(juca);
        w.close();
    }
}
