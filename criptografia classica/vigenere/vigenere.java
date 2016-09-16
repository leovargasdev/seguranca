package vigenere;
import java.io.*;
import java.nio.file.*;
public class vigenere {
    public byte[] chico;
    public vigenere(byte [] v){
        this.chico = v;
    }
    public void criptografar(byte[] key) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("outputs/out_vigenere.txt"));
        int a = 0;
        while(a < this.chico.length)
            for(int k = 0; k < key.length && a < this.chico.length; k++, a++)
                this.chico[a] = (byte)((this.chico[a] + key[k])%256);
        this.c_and_w(w, this.chico);
    }
    public void descriptografar(byte [] key, byte [] chico) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("outputs/out_vigenere_descrip.txt"));
        int a = 0;
        while(a < chico.length)
            for(int k = 0; k < key.length && a < chico.length; k++, a++)
                chico[a] = (byte)((chico[a] - key[k])%256);
        this.c_and_w(w, chico);
    }
    public void c_and_w(FileOutputStream w, byte[] v) throws IOException{
        w.write(v);
        w.close();
    }
}
