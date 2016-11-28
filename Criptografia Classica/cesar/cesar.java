package cesar;
import java.io.*;
import java.nio.file.*;
public class cesar{
    public byte[] juca;
    public cesar(byte [] v){
        this.juca = v;
    }
    public cesar(){}
    public void criptografar(int key) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("cesar/outputs/out_crip.txt"));
        for(int oxa = 0; oxa < this.juca.length; oxa++)
            this.juca[oxa] = (byte)(( this.juca[oxa] + key)%256);
        w.write(this.juca);
        w.close();
    }
    public void descriptografar(int key, byte[] juca) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("cesar/outputs/out_descrip.txt"));
        for(int oxa = 0; oxa < juca.length; oxa++)
            juca[oxa] = (byte)(( juca[oxa] - key)%256);
        w.write(juca);
        w.close();
    }
    public String ataqueEscuro(int key, byte[] pastor) throws IOException{
        for(int oxa = 0; oxa < pastor.length; oxa++)
            pastor[oxa] = (byte)(( pastor[oxa] - key)%256);
        return new String(pastor, "UTF-8");
    }
    public void ataqueClaro(byte asas){
        System.out.println("(ATAQUE CLARO) chave cesar: " + ((int) this.juca[0] - asas));
    }
}
