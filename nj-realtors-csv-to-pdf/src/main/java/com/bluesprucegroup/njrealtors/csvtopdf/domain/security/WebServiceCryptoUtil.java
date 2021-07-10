package com.bluesprucegroup.njrealtors.csvtopdf.domain.security;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

public class WebServiceCryptoUtil {
	private static final Logger log = LogManager.getLogger(WebServiceCryptoUtil.class);
	private static final String IV = "IV_VALUE_16_BYTE";
    private static final String SALT = "oCiRvFKV780n6dBDsZvWGpjh1A9lZxOeczZQWtd3TBtwrJr+jwIyPe"; 
    private static final String VALUE = "abOSOo0ryNNYz5VAj/ErnEqtNHKKb7zQoQwuAw/5T3xg3iQvERqotM"; 
    private static final String CIPHER_INSTANCE = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_INSTANCE = "PBKDF2WithHmacSHA1";
    private static final String CRYTO_ALGORITHM = "AES";
    private static final String CHAR_SET_ENCODED = "UTF-8";
    
    @Value("${web.service.id.a}")
	private static String webServiceIdA;
    
    @Value("${web.service.id.b}")
	private static String webServiceIdB;
    
    public static String encrypt(String input) {
    	String output = "";
        try {
            Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
            byte[] encryptedVal = cipher.doFinal(getBytes(input));
           output = getString(Base64.encodeBase64(encryptedVal));
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
        return output;
    }
 
    public static String decrypt(String input) throws Exception {
    	String output = "";
        try {
        	if(input.contains("-")) {
        		//Log.info("Decrypto found (-):" + input);
        	}
        	input = input.replace("-", "+");
	        byte[] decodedValue = Base64.decodeBase64(getBytes(input));
	        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
	        byte[] decodedBytes = cipher.doFinal(decodedValue);
	        
	        output = new String(decodedBytes);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
        return output;
    }
    
    public static String getCurrentHour() {
		return new SimpleDateFormat("yyyy-MM-dd-HH").format(new Date());
	}
    
    private static String getString(byte[] bytes) throws UnsupportedEncodingException {
        return new String(bytes, CHAR_SET_ENCODED);
    }
 
    private static byte[] getBytes(String str) throws UnsupportedEncodingException {
        return str.getBytes(CHAR_SET_ENCODED);
    }
 
    private static Cipher getCipher(int mode) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE);
        byte[] ivBytes = getBytes(IV);
        cipher.init(mode, generateKey(), new IvParameterSpec(ivBytes));
        return cipher;
    }
 
    private static Key generateKey() throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
        char[] valueArray = getValue().toCharArray();
        byte[] saltBytes = getBytes(getSalt());
 
        KeySpec keySpec = new PBEKeySpec(valueArray, saltBytes, 65536, 128);
        SecretKey tempSecretKey = factory.generateSecret(keySpec);
        byte[] secretKeyBytes = tempSecretKey.getEncoded();
        return new SecretKeySpec(secretKeyBytes, CRYTO_ALGORITHM);
    }
    
    public static String getHash256(String input) {
        try {
            return org.apache.commons.codec.digest.DigestUtils.sha256Hex(input);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }
    
    public static String getSalt() {
    	return findSaltValue();
    }
    
    public static String getValue() {
    	return VALUE + webServiceIdB;
    }
    
    private static String findSaltValue() {
    	return SALT + webServiceIdA;
    }
    
    public static BCryptPasswordEncoder passwordEncoder() {
    	String salt = SALT+WebServiceCryptoUtil.getSalt();
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12, new SecureRandom(salt.getBytes()));
    	//String encoded = encoder.encode(param);
    	return encoder;
    }
}
