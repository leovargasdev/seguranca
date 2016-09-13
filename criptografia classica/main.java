import java.io.*;
import java.nio.file.*;
import cesar.*;
class main{
    public static void main(String [] args)throws IOException{
        /*------------- Cesar --------------*/
        cesar c = new cesar();
        byte[] v_cesar = Files.readAllBytes(Paths.get("1.input"));
        c.criptografar(17, v_cesar);
        byte[] v_cesar_crip = Files.readAllBytes(Paths.get("outputs/out_cesar.txt"));
        c.descriptografar(17, v_cesar_crip);
    }
}
