import java.io.*;
import java.nio.file.*;
class crip_transposicao{
    public static void main(String [] agrs) throws IOException{
        byte[] nilo = Files.readAllBytes(Paths.get("1.input"));
        FileOutputStream w = new FileOutputStream(new File("outputs/out_crip.txt"));
        int colunas = 13, linhas = nilo.length/colunas;
        if((nilo.length % colunas) != 0) linhas++;
        byte[][] aux = new byte[colunas][linhas];
        for(int k = 0, b = 0; k < linhas; k++)
            for(int y = 0; y < colunas && b < nilo.length; y++, b++)
                aux[y][k] = nilo[b];
        for(int k = 0; k < colunas; k++)
            for(int y = 0; y < linhas; y++)
                w.write(aux[k][y]);
        w.close();
    }
}
