package vigenere;
import java.io.*;
import java.nio.file.*;
public class vigenere {
    public byte[] chico;
    public vigenere(byte [] v){
        this.chico = v;
    }
    public void criptografar(byte[] key) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("vigenere/outputs/out_crip.txt"));
        int a = 0;
        while(a < this.chico.length)
            for(int k = 0; k < key.length && a < this.chico.length; k++, a++)
                this.chico[a] = (byte)((this.chico[a] + key[k])%256);
        w.write(this.chico);
        w.close();
    }
    public void descriptografar(byte [] key, byte [] chico) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("vigenere/outputs/out_descrip.txt"));
        int a = 0;
        while(a < chico.length)
            for(int k = 0; k < key.length && a < chico.length; k++, a++)
                chico[a] = (byte)((chico[a] - key[k])%256);
        w.write(chico);
        w.close();
    }
    public void ataqueClaro(byte[] martelo){
        System.out.print("chave vigenere: ");
        //for(int u = 0; u < this.chico.length; u++)
        for(int u = 0; u < 4; u++)
            System.out.print((char)((byte)(this.chico[u] - martelo[u])));
        System.out.println();
    }
}
