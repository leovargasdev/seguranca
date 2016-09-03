import java.io.*;
import java.nio.file.*;
class crip_transposicao{
    public static void main(String [] agrs) throws IOException{
        int key = 3;
        String texto = "hoje eu perdi";
        String texto2 = "";
        int linhas = texto.length()/key;
        if((texto.length() % key) != 0) linhas++;
        //System.out.println("(" + texto.length() + " / " + key + ")" + " =" + linhas);
        char[][] a = new char[linhas][key];
        char[][] a2 = new char[key][linhas];
        int w = 0;
        for(int k = 0; k < linhas; k++){
            for(int y = 0; y < key && w < texto.length(); y++, w++){
                a[k][y] = texto.charAt(w);
                a2[y][k] = a[k][y];
                System.out.print("["+a[k][y]+"] ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        for(int k = 0; k < key; k++){
            for(int y = 0; y < linhas; y++){
                System.out.print("["+a2[k][y]+"] ");
                texto2 += a2[k][y];
            }
            System.out.println();
        }
        System.out.println(texto2);
    }
}
