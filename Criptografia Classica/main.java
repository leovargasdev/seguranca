import java.io.*;
import java.nio.file.*;
import cesar.*;
import transposicao.*;
import vigenere.*;
import substituicao.*;
class main{
    public static void main(String [] args)throws IOException{
        byte[] inputC = Files.readAllBytes(Paths.get("inputs/1.input"));
        byte[] inputV = inputC.clone(), inputT = inputV.clone(), inputS = inputT.clone();
        int kcesar = 17, ktransposicao = 13;
        byte[] kvigenere = "abcd".getBytes();
        /*------------- Cifra de Cesar --------------*/
        cesar c = new cesar(inputC);
        c.criptografar(kcesar);
        c.descriptografar(kcesar, Files.readAllBytes(Paths.get("cesar/outputs/out_crip.txt")));
        /*------------- Cifra de Vigenere --------------*/
        vigenere v = new vigenere(inputV);
        v.criptografar(kvigenere);
        v.descriptografar(kvigenere, Files.readAllBytes(Paths.get("vigenere/outputs/out_crip.txt")));
        /*------------- Cifra de Transposicao ----------*/
        transposicao t = new transposicao(inputT);
        t.criptografar(ktransposicao);
        t.descriptografar(ktransposicao, Files.readAllBytes(Paths.get("transposicao/outputs/out_crip.txt")));
        /*------------- Cifra de Transposicao ----------*/
        substituicao s = new substituicao(inputS);
        s.criptografar();
        //s.descriptografar(ktransposicao, Files.readAllBytes(Paths.get("substituicao/outputs/out_crip.txt")));
    }
}
