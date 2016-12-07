import java.security.*;
public class Destinatario{
    public void recebeMensagem(PublicKey pubKey, String mensagem, byte[] assinatura) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature clientSig = Signature.getInstance("SHA1withRSA");// Verificar assinatura
        clientSig.initVerify(pubKey);
        clientSig.update(mensagem.getBytes());
        if (clientSig.verify(assinatura))
            System.out.println("A Mensagem recebida foi assinada corretamente.");
        else
            System.out.println("A Mensagem recebida NÃO pode ser validada.");
    }
}
