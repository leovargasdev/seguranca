//
import java.util.Scanner;
class diffiehelmann{
    public static void main(String [] agrs){
        Scanner scanner = new Scanner(System.in);
        double m = 23;                                  // modulo
        double base = 5;                                //  base
        double chave = scanner.nextDouble();            // chave secreta
        System.out.println(Math.pow(base,chave) % m);   // chave intermediaria
        double ci = scanner.nextDouble();               // lendo a chave intermediaria da outra pessoa
        System.out.println("msg:" + (Math.pow(ci,chave) % m));
    }
}
