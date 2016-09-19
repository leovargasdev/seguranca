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
        /*int[] a = {1,2,3,4,5}, b = {2,4,1,5,3};
        for(int y = 0; y < a.length; y++)
            for(int t = 0; t < b.length; t++)
                if(a[y] == b[t])
                    a[y] =
        for(int u = 0; u < this.jurema.length; u ++)
            for(int e = 0; e < this.key.length; e++)
                if((char)this.jurema[u] == (char)e)
                    this.jurema[u] = key[e];
                    //System.out.println("vetor ju: " + (char)this.jurema[u] + ", vetor e: " + (char)key[e]);
                    //System.out.println("vetor ju: " + (char)this.jurema[u] + ", vetor e: " + (char)key[e]);
        w.write(this.jurema);
        w.close();*/
        //System.out.println(this.jurema[0] + ", valor em char: " + (char)this.jurema[0]);
        //System.out.println(key[(int)this.jurema[0]] + ", valor em char: " + (char)key[(int)this.jurema[0]]);
    }
}
