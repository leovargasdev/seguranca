package substituicao;
import java.io.*;
import java.nio.file.*;
public class substituicao{
    public byte[] jurema;
    public byte[] key, ascii = new byte[256];
    public substituicao(byte[] v) throws IOException{
        this.jurema = v;
        this.key = Files.readAllBytes(Paths.get("keys/key1"));
        for(int a = 0; a < ascii.length; a++)
            this.ascii[a] = (byte)a;
    }
    public void criptografar() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("substituicao/outputs/out_crip.txt"));
        for(int u = 0; u < this.jurema.length; u++)
            for(int e = 0; e < this.ascii.length; e++)
                if(this.jurema[u] == this.ascii[e]){
                    this.jurema[u] = this.key[e];
                    break;
                }
        w.write(this.jurema);
        w.close();
    }
    /*public static void main(String [] args){
        int[] ordenado = {1,2,3,4,5};
        int[] texto = {3,1,5};
        int[] desordenado = {2,4,5,3,1};
        for(int k = 0; k < texto.length; k++)
            for(int t = 0; t < ordenado.length; t++)
                if(texto[k] == ordenado[t]){
                    texto[k] = desordenado[t];
                    break;
                }

        for(int k = 0; k < texto.length; k++)
            System.out.print(texto[k] + "-");
        System.out.println();
    }*/
}
