package transposicao;
import java.io.*;
import java.nio.file.*;
public class transposicao{
    public byte[] nilo;
    public transposicao(byte[] b) throws IOException{
        this.nilo = b;
    }
    public void criptografar(int colunas) throws IOException{
        int linhas = this.nilo.length/colunas;
        FileOutputStream w = new FileOutputStream(new File("transposicao/outputs/out_crip.txt"));
        if((this.nilo.length % colunas) != 0) linhas++;
        byte[][] aux = new byte[colunas][linhas];
        for(int k = 0, b = 0; k < linhas; k++) // constroi a matriz transposta
            for(int y = 0; y < colunas && b < this.nilo.length; y++, b++)
                aux[y][k] = this.nilo[b];
        for(int k = 0; k < colunas; k++)
            for(int y = 0; y < linhas; y++)
                w.write(aux[k][y]);
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
        System.out.println(this.nilo.length);
        //System.out.println(this.nilo[0][0]);
    }
}
