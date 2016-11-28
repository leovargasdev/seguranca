import java.io.*;
import java.nio.file.*;
import cesar.*;
import transposicao.*;
import vigenere.*;
import substituicao.*;
class main{
    public static void main(String [] args)throws IOException{
        byte[] kvigenere = "abcd".getBytes();
        byte[] textoClaro = Files.readAllBytes(Paths.get("inputs/7.input"));
        ataqueescuro ae = new ataqueescuro(new File("inputs/ataque_escuro.txt"));
        //byte[] textoClaro = Files.readAllBytes(Paths.get("inputs/carne.txt"));
        //ataqueescuro ae = new ataqueescuro(new File("inputs/carne_original.txt"));
        byte[] inputC = textoClaro.clone(), inputV = inputC.clone(), inputT = inputV.clone(), inputS = inputT.clone();
        int kcesar = 13, ktransposicao = 5;
        /*------------- Cifra de Cesar --------------*/
        cesar c = new cesar(inputC);
        c.criptografar(kcesar);
        c.ataqueClaro(textoClaro[0]);
        c.descriptografar(kcesar, Files.readAllBytes(Paths.get("cesar/outputs/out_crip.txt")));
        ae.ataqueCesar(c.juca);
        ae.ataqueCesar(Files.readAllBytes(Paths.get("cesar/outputs/7.input.ceasar.X")));
        /*------------- Cifra de Vigenere --------------*/
        vigenere v = new vigenere(inputV);
        v.criptografar(kvigenere);
        v.ataqueClaro(textoClaro);
        v.descriptografar(kvigenere, Files.readAllBytes(Paths.get("vigenere/outputs/out_crip.txt")));
        /*------------- Cifra de Transposicao ----------*/
        transposicao t = new transposicao(inputT, ktransposicao);
        t.criptografar();
        t.ataqueClaro();
        t.descriptografar(ktransposicao, Files.readAllBytes(Paths.get("transposicao/outputs/out_crip.txt")));
        /*------------- Cifra de Transposicao ----------*/
        /*substituicao s = new substituicao(inputS);
        s.criptografar();
        s.descriptografar();*/
    }
}
