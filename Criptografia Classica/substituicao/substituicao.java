package substituicao;
import java.io.*;
import java.nio.file.*;
public class substituicao{
    public byte[] jurema;
    public byte[] key;
    public substituicao(byte[] v) throws IOException{
        this.jurema = v;
        this.key = Files.readAllBytes(Paths.get("keys/key1"));
    }
    public void criptografar() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("substituicao/outputs/out_crip.txt"));
        for(int u = 0; u < this.jurema.length; u++)
            this.jurema[u] = this.key[(int)this.jurema[u]];
        w.write(this.jurema);
        w.close();
    }
    /*public void descriptografar(byte[] hugo) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("substituicao/outputs/out_descrip.txt"));
        for(int u = 0; u < this.jurema.length; u++)
            hugo[u] = ;
        w.write(this.hugo);
        w.close();
    }*/
}
