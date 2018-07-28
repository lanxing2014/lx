package test.shiro.three;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class TestShiroByINI {
	@Test
	public void TestShiroConfig(){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	    		new IniSecurityManagerFactory("classpath:shiro-jdbc-authorizer.ini");  
	    //2、得到SecurityManager实例 并绑定给SecurityUtils  
	    SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
	  
	    try {  
	        //4、登录，即身份验证  
	        subject.login(token);
	        PrincipalCollection  principals = subject.getPrincipals();
	        principals.asList();
	        for (Object object : principals) {
	        	System.out.println("###"+object.toString());
			}
	        //判断拥有角色：role1  
	        System.out.println(subject.hasRole("role1"));  
	        //判断拥有角色：role1 and role2  
	        System.out.println(subject.hasAllRoles(Arrays.asList("role1", "role2"))); 
	        //判断拥有角色：role1 and role2  and role3
	        System.out.println(subject.hasAllRoles(Arrays.asList("role1", "role2", "role3"))); 
	        
	        try {
	        	//判断拥有角色：role1 
		        subject.checkRole("role1"); 
		        //判断拥有角色：role1 and role2  
		        subject.checkRoles(Arrays.asList("role1", "role2")); 
		        //判断拥有角色：role1 and role2  and role3
		        subject.checkRoles(Arrays.asList("role1", "role2", "role3"));
			} catch (Exception e){
				System.out.println("exception:"+e.getMessage());
			}
	        
	        
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	System.out.println("登录失败！");
	    }  
	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
	  
	    //6、退出  
	    subject.logout();  
	}  
}
