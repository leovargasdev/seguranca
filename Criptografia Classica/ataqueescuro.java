import java.util.*;
import java.io.*;
import java.nio.file.*;
import cesar.*;
import transposicao.*;
import vigenere.*;
import substituicao.*;
class ataqueescuro{
    public ArrayList <String> palavras = new ArrayList <String>();
    public int acerto = 0, op = 1;//op = 1 = 75% de acerto, op = 2 = 90% de acerto.
    public double porcentagem = 0.75;//pode ser de 75% ate 90% depende da opção no método
    public ataqueescuro(File l)throws IOException{
        Scanner s = new Scanner(l);
        while(s.hasNext())
            palavras.add(s.nextLine().toLowerCase());
    }
    public boolean TestaChave(String[] palavrasDescrip){
        acerto = 0;
        for(int i = 0; i < palavrasDescrip.length; i++)
            if(palavrasDescrip[i].length() != 0)//Ignora os vetores que ficaram com só com espaços
                for(int k = 0; k < palavras.size(); k++)
                    if(palavrasDescrip[i].equals(palavras.get(k)))
                        acerto++;
        if((palavrasDescrip.length*porcentagem) <= acerto)//verifica a porcentagem de acerto
            return true;
        return false;
    }
    public void ataqueCesar(byte[] pegasus)throws IOException{
        cesar c = new cesar();
        for(int jabuti = 0; jabuti < Math.pow(10,3); jabuti++)//JABUTI variavel para ser as chaves possíveis.
            if(this.TestaChave(c.ataqueEscuro(jabuti, pegasus.clone(), op))){
                System.out.println("(ATAQUE ESCURO)chave cesar: " + jabuti);
                break;
            }
    }
    public void ataqueVigenere(byte[] pegasus)throws IOException{
        vigenere v = new vigenere();
        String cobra = "abc0123456789";//possíveis caracteres na chave
        int sz = cobra.length();
        int n = (int)Math.pow(sz,3);//com a variavel cobra, fazer combinações de 3 em 3.
        for(int i = 0; i < n; i++){
            int p1 = i % sz, p2 = (i / sz) % sz, p3 = (i / sz / sz) % sz;
            byte[] chave = {(byte)cobra.charAt(p1), (byte)cobra.charAt(p2), (byte)cobra.charAt(p3)};
            if(this.TestaChave(v.ataqueEscuro(chave, pegasus.clone(), op))){
                System.out.println("(ATAQUE ESCURO)chave vigenere: " + new String(chave, "UTF-8"));
                break;
            }
        }
    }
    public void ataqueTransposicao(byte[] pegasus)throws IOException{
        transposicao t = new transposicao();
        for(int rena = 1; rena < pegasus.length; rena++){//rena variavel para ser as chaves possíveis.
            if(this.TestaChave(t.ataqueEscuro(rena, pegasus.clone(), op))){
                System.out.println("(ATAQUE ESCURO)chave transposicao: " + rena);
                break;
            }
        }
    }
}
