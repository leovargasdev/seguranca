import java.security.*;
public class AssinaturaDigital {
    public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Remetente remetente = new Remetente();//Gera Assinatura Digital para uma Mensagem
        String mensagem = "Hoje no almoço eu comi um pastel de flango";
        byte[] assinatura = remetente.geraAssinatura(mensagem);
        PublicKey pubKey = remetente.getPubKey();//chave publica para ser enviada ao destinatario
        //Destinatário recebe dados correto
        Destinatario destinatario = new Destinatario();
        destinatario.recebeMensagem(pubKey, mensagem, assinatura);
        //Destinatário recebe mensagem alterada
        String msgAlterada = "Ontem na janta eu comi um pastel de carne";
        destinatario.recebeMensagem(pubKey, msgAlterada, assinatura);
        //Criando outra Assinatura
        String mensagem2 = "Almoço e janta são horas da boia";
        byte[] assinatura2 = remetente.geraAssinatura(mensagem2);
        PublicKey pubKey2 = remetente.getPubKey();//outra chave publica
        destinatario.recebeMensagem(pubKey, mensagem, assinatura2);//Testando com outra assinatura
        destinatario.recebeMensagem(pubKey2, mensagem, assinatura);//Testando com outra chave
        destinatario.recebeMensagem(pubKey2, mensagem2, assinatura2);//Testando com outra chave
    }
}
