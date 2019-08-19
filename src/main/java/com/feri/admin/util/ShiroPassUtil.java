package com.feri.admin.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;

/**
 * @program: NewRetail_Admin
 * @description: 基于Shiro实现密码加密
 * @author: Feri
 * @create: 2019-08-16 14:20
 */
public class ShiroPassUtil {
    //md5
    /**
     * 实现对指定字符串进行加密
     * @param pass 要密码的内容
     * @param salt 盐
     * @param count 加密次数*/
    public static String md5Pass(String pass,String salt,int count){
        /**
         * 摘要算法 参数说明
         * 1、摘要算法 支持：Md5 sha hmac等
         * 2、要加密的字符串
         * 3、盐 干扰字符串
         * 4、加密次数*/
        SimpleHash simpleHash=new SimpleHash("MD5",pass,salt,count);
        return simpleHash.toBase64();
    }
    public static String md5Pass(String pass){
        return md5Pass(pass,"zzjava",1024);
    }

    //生成AES的秘钥
    public static String createAESKey(){
        AesCipherService aesCipherService=new AesCipherService();
        aesCipherService.setKeySize(256);
        Key key= aesCipherService.generateNewKey();
        return new String(Base64.encode(key.getEncoded()));
    }
    //AES加密
    public static String AESEnc(String key,String msg){
        AesCipherService aesCipherService=new AesCipherService();
        byte[] k=Base64.decode(key);
        SecretKeySpec keySpec=new SecretKeySpec(k,"AES");
        String str=aesCipherService.encrypt(msg.getBytes(),keySpec.getEncoded()).toBase64();
        return str;
    }
    //Aes解密
    public static String AESEDoc(String key,String msg){
        AesCipherService aesCipherService=new AesCipherService();
        byte[] k=Base64.decode(key);
        SecretKeySpec keySpec=new SecretKeySpec(k,"AES");
        String str=new String(aesCipherService.decrypt(Base64.decode(msg),keySpec.getEncoded()).getBytes());
        return str;
    }


}
