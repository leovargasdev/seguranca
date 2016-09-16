import java.io.*;
import java.nio.file.*;
import cesar.*;
import vigenere.*;
class main{
    public static void main(String [] args)throws IOException{
        byte[] inputC = Files.readAllBytes(Paths.get("1.input")), inputV = inputC.clone(), inputT = inputV.clone();
        int kcesar = 17, ktransp = 13;
        byte[] kvigenere = "abcd".getBytes();
        /*------------- Cesar --------------*/
        cesar c = new cesar(inputC);
        c.criptografar(kcesar);
        c.descriptografar(kcesar, Files.readAllBytes(Paths.get("outputs/out_cesar.txt")));
        /*------------- Vigenere --------------*/
        vigenere v = new vigenere(inputV);
        v.criptografar(kvigenere);
        v.descriptografar(kvigenere, Files.readAllBytes(Paths.get("outputs/out_vigenere.txt")));
    }
}
