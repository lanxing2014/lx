package test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class TestShiroAuthorizer {
	@Test  
	public void testHelloworld() {  
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
        
        //判断拥有权限：user:create
       
        System.out.println(subject.isPermitted("user1:update"));  
        System.out.println(subject.isPermitted("user2:update"));  
        //通过二进制位的方式表示权限  
        System.out.println(subject.isPermitted("+user1+2"));//新增权限  
        System.out.println(subject.isPermitted("+user1+8"));//查看权限  
        System.out.println(subject.isPermitted("+user2+10"));//新增及查看  
  
        System.out.println(subject.isPermitted("+user1+4"));//没有删除权限  
  
        System.out.println(subject.isPermitted("menu:view"));//通过MyRolePermissionResolver解析得到的权限  
        
        
    } catch (AuthenticationException e) {  
        //5、身份验证失败  
    	System.out.println("登录失败！");
    }  
    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
  
    //6、退出  
    subject.logout();  
	}
}
