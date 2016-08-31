import java.io.*;
import java.nio.file.*;
class cesar{
    public static void main(String [] agrs) throws IOException{
        int key = 17;
        byte[] juca = Files.readAllBytes(Paths.get("2.input"));               // vetor com a entrada convertida em bytes
        FileWriter clr = new FileWriter(new File("out_crip.txt"), false);     // saida criptografada escrita no arquivo "out_crip.txt" e caso estiver algo escrito no arquivo é limpado
        FileOutputStream w = new FileOutputStream(new File("out_crip.txt"));
        for(int oxa = 0; oxa < juca.length; oxa++)
            juca[oxa] = (byte)((juca[oxa] + key)%256);
        w.write(juca);
        w.close();
        clr.close();

        /* ------------- Descriptografando ------------- */

        byte[] juca2 = Files.readAllBytes(Paths.get("out_crip.txt"));       // lendo arquivo criptografado      
        FileWriter clr2 = new FileWriter(new File("out_descrip.txt"), false); // saida descriptografa escrita no arquivo "out_descrip.txt"
        FileOutputStream w2 = new FileOutputStream(new File("out_descrip.txt"));
        for(int oxa = 0; oxa < juca2.length; oxa++)
            juca2[oxa] = (byte)((juca2[oxa] - key)%256);
        w2.write(juca2);
        w2.close();
        clr2.close();
    }
}
