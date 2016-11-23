package transposicao;
import java.io.*;
import java.nio.file.*;
public class transposicao{
    public byte[][] nilo;
    int linhas, colunas;
    public transposicao(byte[] tatu, int c) throws IOException{
        this.colunas = c;
        this.linhas = tatu.length/this.colunas;
        if((tatu.length % this.colunas) != 0)
            this.linhas++;
        this.nilo = new byte[this.colunas][this.linhas];
        for(int k = 0, b = 0; k < this.linhas; k++) // constroi a matriz transposta
            for(int y = 0; y < this.colunas && b < tatu.length; y++, b++)// variavel b é q anda pelas linhas.
                this.nilo[y][k] = tatu[b];
    }
    public void criptografar() throws IOException{
        FileOutputStream w = new FileOutputStream(new File("transposicao/outputs/out_crip.txt"));
        for(int k = 0; k < this.colunas; k++)
            for(int y = 0; y < this.linhas; y++)
                w.write(this.nilo[k][y]);
        w.close();
    }
    public void descriptografar(int linhas, byte[] nilo) throws IOException{
        FileOutputStream w = new FileOutputStream(new File("transposicao/outputs/out_descrip.txt"));
        int colunas = nilo.length/linhas;
        if((nilo.length % linhas) != 0) colunas++;
        byte[][] aux = new byte[colunas][linhas];
        for(int k = 0, b = 0; k < linhas; k++)
            for(int y = 0; y < colunas && b < nilo.length; y++, b++)
                aux[y][k] = nilo[b];
        for(int k = 0; k < colunas; k++)
            for(int y = 0; y < linhas; y++)
                w.write(aux[k][y]);
        w.close();
    }
    public void ataqueClaro(){
        System.out.println("chave transposicao: " + this.nilo.length);
    }
}
