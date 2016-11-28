import java.util.*;
import java.io.*;
import java.nio.file.*;
import cesar.*;
import transposicao.*;
import vigenere.*;
import substituicao.*;
class ataqueescuro{
    public ArrayList <String> palavras = new ArrayList <String>();
    public ataqueescuro(File l)throws IOException{
        Scanner s = new Scanner(l);
        while(s.hasNext())
            palavras.add(s.nextLine());
    }
    public void ataqueCesar(byte[] juca)throws IOException{
        cesar c = new cesar();
        int acerto = 0, jabuti = 0;//JABUTI variavel para ser as chaves possiveis.
        while(jabuti < Math.pow(10,3)){
            String[] palavrasDescrip = c.ataqueEscuro(jabuti, juca.clone()).replaceAll("[^a-zA-Z1-9 ]", " ").toLowerCase().split(" ");
            //linha de cima: deixa só as letras, numeros. Deixa tds as letras minúsculas. Quebra a string nos espaços.
            for(int i = 0; i < palavrasDescrip.length; i++)
                if(palavrasDescrip[i].length() != 0)//Ignora os vetores que ficaram com só com espaços
                    for(int k = 0; k < palavras.size(); k++)
                        if(palavrasDescrip[i].equals(palavras.get(k))) acerto++;
            if((palavrasDescrip.length*0.75) < acerto){// 75% das palavras pertencem a lingua
                System.out.println("(ATAQUE ESCURO)chave cesar: " + jabuti);
                break;
            } else acerto = 0;
            jabuti++;
        }
    }
}
