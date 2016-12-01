import java.util.*;
import java.io.*;
import java.nio.file.*;
class padroes{
    public static void main(String [] args)throws IOException{
        byte[] input = Files.readAllBytes(Paths.get("input.txt"));
        ArrayList <String> contados = new ArrayList <String>();
        for(int a = 0; a < input.length; a++){
            boolean achou = false;
            for(int i = 0; i < contados.size(); i++)
                if(contados.get(i).equals("" + (char)input[a]) || (char)input[a] == '\n')
                    achou = true;
            if(!achou)
                contados.add("" + (char)input[a]);
        }
        System.out.print("Entrada: " + new String(input, "UTF-8"));
        for(int a = 0; a < input.length; a++)
            for(int i = 0; i < contados.size(); i++)
                if(contados.get(i).equals("" + (char)input[a]))
                    System.out.println(contados.get(i) + ": " + i);
    }
}
