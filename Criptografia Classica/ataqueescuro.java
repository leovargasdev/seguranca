import java.util.*;
import java.io.*;
import java.nio.file.*;
import cesar.*;
import transposicao.*;
import vigenere.*;
import substituicao.*;
class ataqueescuro{
    public ArrayList <String> palavras = new ArrayList <String>();
    public int acerto = 0;
    public ataqueescuro(File l)throws IOException{
        Scanner s = new Scanner(l);
        while(s.hasNext())
            palavras.add(s.nextLine());
    }
    public boolean achaCHAVE(String[] palavrasDescrip){
        acerto = 0;
        for(int i = 0; i < palavrasDescrip.length; i++)
            if(palavrasDescrip[i].length() != 0)//Ignora os vetores que ficaram com só com espaços
                for(int k = 0; k < palavras.size(); k++)
                    if(palavrasDescrip[i].equals(palavras.get(k)))
                        acerto++;
        if((palavrasDescrip.length*0.75) < acerto)// 75% das palavras pertencem a lingua
            return true;
        return false;
    }
    public void ataqueCesar(byte[] juca)throws IOException{
        cesar c = new cesar();
        for(int jabuti = 0; jabuti < Math.pow(10,3); jabuti++)//JABUTI variavel para ser as chaves possiveis.
            if(this.achaCHAVE(c.ataqueEscuro(jabuti, juca.clone()).replaceAll("[^a-zA-Z1-9 ]", " ").toLowerCase().split(" "))){
//Linha de cima: Passa para o metodo a string quebrada nos espaços, e nela so contem letra minúsculas e numeros.
                System.out.println("(ATAQUE ESCURO)chave cesar: " + jabuti);
                break;
            }
    }
}
