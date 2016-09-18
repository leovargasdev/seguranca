import java.util.Scanner;
class diffiehellman{
    public static void main(String [] agrs){
        Scanner scanner = new Scanner(System.in);
        double m = 23;                           // modulo
        double b = 5;                            // base
        double c = scanner.nextDouble();         // lendo chave secreta
        System.out.println(Math.pow(b,c) % m);   // gerando chave intermediaria
        double ci = scanner.nextDouble();        // lendo a chave intermediaria da outra pessoa
        System.out.println("msg:" + (Math.pow(ci,c) % m));
    }
}
