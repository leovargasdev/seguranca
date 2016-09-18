import java.io.*;
import java.nio.file.*;
class descrip_transposicao{
    public static void main(String [] agrs) throws IOException{
        byte[] nilo = Files.readAllBytes(Paths.get("outputs/out_crip.txt"));
        FileOutputStream w = new FileOutputStream(new File("outputs/out_descrip.txt"));
        int linhas = 13, colunas = nilo.length/linhas;
        System.out.println("linhas:" + linhas + ", colunas:" + colunas);
        if((nilo.length % linhas) != 0) colunas++;
        byte[][] matrix = new byte[linhas][colunas];
        byte[][] aux = new byte[colunas][linhas];
        for(int k = 0, b = 0; k < linhas; k++)
            for(int y = 0; y < colunas && b < nilo.length; y++, b++){
                matrix[k][y] = nilo[b];
                aux[y][k] = matrix[k][y];
            }
        for(int k = 0; k < colunas; k++)
            for(int y = 0; y < linhas; y++)
                w.write(aux[k][y]);
        w.close();
    }
}
