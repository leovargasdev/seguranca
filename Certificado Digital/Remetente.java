import java.security.*;
public class Remetente{
    private PublicKey pubKey;
    public PublicKey getPubKey(){
        return this.pubKey;
    }
    public void setPubKey(PublicKey pubKey){
        this.pubKey = pubKey;
    }
    public byte[] geraAssinatura(String mensagem) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig = Signature.getInstance("SHA1withRSA");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");//Geração das chaves públicas e privadas
        kpg.initialize(512, new SecureRandom());//Segundo parâmetro é um obj do tipo SecureRandom
        KeyPair keyP = kpg.generateKeyPair();
        this.pubKey = keyP.getPublic();
        sig.initSign(keyP.getPrivate());//Inicializando Obj Signature com a Chave Privada
        sig.update(mensagem.getBytes());//Gerar assinatura
        return sig.sign();//retorna um vetor de bytes
    }
}
