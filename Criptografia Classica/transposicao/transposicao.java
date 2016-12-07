package transposicao;
import java.io.*;
import java.nio.file.*;
public class transposicao{
    public byte[] nilo;
    public int linhas, colunas;
    public String local_crip = "transposicao/outputs/out_crip.txt";
    public String local_descrip = "transposicao/outputs/out_descrip.txt";
    public transposicao(){}
    public transposicao(byte[] v, int chave) throws IOException{
        this.colunas = chave;// a chave é o numero de colunas
        this.linhas = v.length/this.colunas;
        this.nilo = v;//Cria matriz normal
    }
    public byte[][] criarMatriz(byte[] kuka){
        if((kuka.length % this.colunas) != 0) this.linhas++;
        byte[][] aux = new byte[this.colunas][this.linhas];
        for(int l = 0, b = 0; l < this.linhas; l++)
            for(int c = 0; c < this.colunas && b < kuka.length; c++, b++)
                aux[c][l] = kuka[b]; //variavel b anda pelo vetor de entrada, para colocar os valores na matriz
        return aux;
    }
    public byte[] transposta(byte[][] helio) {//recebe a matriz, escreve a transposta em um array de bytes, retornando esse array.
        byte[] aux = new byte[this.linhas*this.colunas];
        for(int c = 0, a = 0; c < this.colunas; c++)
            for(int l = 0; l < this.linhas && a < aux.length; l++, a++)//fazendo a transposta, primeiro escreve as linhas.
                aux[a] = helio[c][l];
        return aux;
    }
    public void criptografar() throws IOException{
        FileOutputStream w = new FileOutputStream(new File(local_crip));
        this.nilo = transposta(criarMatriz(this.nilo));
        w.write(this.nilo);
        w.close();
    }
    public void descriptografar(int chave, byte[] figo) throws IOException{
        FileOutputStream w = new FileOutputStream(new File(local_descrip));
        this.linhas = chave;// pra descriptografar, é o processo contrario a chave vira as linhas.
        this.colunas = figo.length/this.linhas;
        w.write(transposta(criarMatriz(figo)));//Primeiro cria a matriz, dps faz a transposta da transpota, que é a propria matriz original
        w.close();
    }
    public String[] ataqueEscuro(int key, byte[] freira, int op) throws IOException{
        this.linhas = key;// pra descriptografar, é o processo contrario a chave vira as linhas.
        this.colunas = freira.length/this.linhas;
        if(op == 1) return new String(transposta(criarMatriz(freira)), "UTF-8").toLowerCase().split(" ");//OP 1: 75% de acerto, bem mais rápido.
        else return new String(transposta(criarMatriz(freira)), "UTF-8").replaceAll("[^a-zA-Z1-9 ]", " ").toLowerCase().split(" ");//OP 2: 90% de acerto, porem mais lento.
    }
    public void ataqueClaro(){
        System.out.println("(ATAQUE CLARO) chave transposicao: " + criarMatriz(this.nilo).length);
    }
}
