package ibus.paqi.spring;


import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ioc {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("appliction_test.xml");
        System.out.println(context.getBean("testService"));
    }

    @Test
    public void test2(){
        //<import>注解使用
        ApplicationContext context = new ClassPathXmlApplicationContext("appliction_test3.xml");
        System.out.println(context.getBean("testService"));
    }

    @Test
    public void test3(){
        //Generic bean: class [ibus.paqi.spring.beans.TestDao];
        // scope=; abstract=false;
        // lazyInit=false;
        // autowireMode=0;
        // dependencyCheck=0;
        // autowireCandidate=true;
        // primary=false;
        // factoryBeanName=null;
        // factoryMethodName=null;
        // initMethodName=null;
        // destroyMethodName=null;
        // defined in class path resource [appliction_test2.xml]
        ApplicationContext context = new ClassPathXmlApplicationContext("appliction_test3.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        ConfigurableListableBeanFactory beanFactory = ((ClassPathXmlApplicationContext) context).getBeanFactory();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            System.out.println(beanDefinition.getClass().getName());
            System.out.println(beanDefinition);

        }


    }


}
