package com.example.demo.sgin;

import java.util.Base64;

public class ApplicationTests {

    public static void main(String[] args) throws Exception {
        String filepath = "/home/chenzhenyang/workspace/workspace-sts/uaa/spring-security-basic-sampels/src/main/resources";
        System.out.println("--------------公钥加密私钥解密过程-------------------");
        String signKey = "ihep_公钥加密私钥解密";
        // 公钥加密过程
        byte[] cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),
                signKey.getBytes());
        String cipher = new String(Base64.getEncoder().encode(cipherData));
        // 私钥解密过程
        byte[] res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),
        		Base64.getDecoder().decode(cipher));
        String restr = new String(res);
        System.out.println("原文：" + signKey);
        System.out.println("加密：" + cipher);
        System.out.println("解密：" + restr);
        System.out.println();

        System.out.println("--------------私钥加密公钥解密过程-------------------");
//        signKey = "ihep_私钥加密公钥解密";
        // 私钥加密过程
        cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),
                signKey.getBytes());
        cipher = new String(Base64.getEncoder().encode(cipherData));
        // 公钥解密过程
        res = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),
        		Base64.getDecoder().decode(cipher));
        restr = new String(res);
        System.out.println("原文：" + signKey);
        System.out.println("加密：" + cipher);
        System.out.println("解密：" + restr);
        System.out.println();


        System.out.println("---------------私钥签名过程------------------");
//        String content = "ihep_这是用于签名的原始数据";
        String content = signKey;
        String signstr = RSASignature.sign(content, RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)));
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signstr);
        System.out.println();

        System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signstr);

        System.out.println("验签结果：" + RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath))));
        System.out.println();
    }

}
