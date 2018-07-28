package com.lx.test;
import org.springframework.context.ApplicationContext;

/** 
 * BeanFactory实例化Bean工程测试类  
 */  
public class Test {  
    public static void main(String args[]) {  
        Test test = new Test();  
        test.test();  
    }  
  
    public void test() {  
        ApplicationContext context = BeanContextHelper.getApplicationContext();  
        Employee employee = (Employee) context.getBean("employee");  
        System.out.println("**********从Spring BeanFactory获取到的最终bean实例**********");  
        System.out.println("最终bean的值：" + employee);  
    }  
}