package test.shiro.four;

import java.security.Key;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Assert;
import org.junit.Test;

public class testBase64 {
	@Test
	public void TestB64(){
		String str = "hello";  
		String base64Encoded = Base64.encodeToString(str.getBytes());  
		String str2 = Base64.decodeToString(base64Encoded);
		System.out.println(str2);
		Assert.assertEquals(str, str2); 
	}
	
	@Test
	public void testSHA1(){
		String str = "hello";  
		String salt = "123";  
		//内部使用MessageDigest  
		String simpleHash = new SimpleHash("SHA-1", str, salt).toString();   
		System.err.println(simpleHash);
	}
	
	@Test
	public void testSHAServer(){
		DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512  
		hashService.setHashAlgorithmName("SHA-512");  
		hashService.setPrivateSalt(new SimpleByteSource("123")); //私盐，默认无  
		hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false  
		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个  
		hashService.setHashIterations(1); //生成Hash值的迭代次数  
		  
		HashRequest request = new HashRequest.Builder()  
		            .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))  
		            .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();  
		String hex = hashService.computeHash(request).toHex();
		
		System.out.println(hex);
		
	}
	
	@Test
	public void testAES(){
		
		AesCipherService aesCipherService = new AesCipherService();  
		aesCipherService.setKeySize(128); //设置key长度  
		//生成key  
		Key key = aesCipherService.generateNewKey();  
		String text = "hello";  
		//加密  
		String encrptText =   
		aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();  
		//解密  
		String text2 =  
		new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());  
		System.out.println(encrptText+"===="+text2);
		Assert.assertEquals(text, text2);   
	}
}
