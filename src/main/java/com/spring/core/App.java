package com.spring.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/*
 * Dependency Injection --
 * Dependency injection is an approach to implement loose coupling among the classes in an application.
 * IOC:  the responsibility of object creation and injecting the dependencies is given to the framework (i.e. Spring) 
 * instead of the class creating the dependency objects by itself.
 * 
 * Spring --
 * Spring is a Dependency Injection framework (IOC) to make java application loosely coupled. 
 * Spring framework makes easy development of Java EE application. 
 * It was developed by Rod Johnson in 2003.
 * 
 * Spring IoC Container --
 * The Spring container is at the core of the Spring Framework. 
 * The container will instantiate the objects, configure them, wire them together, and manage their complete life cycle from creation till destruction. 
 * 
 * Spring IOC Containers (BeanFactory vs ApplicationContext) --
 * ApplicationContext extends BeanFactory
 * BF doesn't provide support for i18n but AC does
 * BF loads beans on-demand (Lazy Loading) while AC loads all beans at startup (Eager Loading)
 * XMLBeanFactory implements BF while ClassPathXmlApplicationContext implements AC
 * 
 * Autowiring -- 
 * Spring container inject the dependencies automatically.
 * 
 * Stereotype Annotations --
 * @Component @Controller @Service @Repository
 * 
 * Bean Scope --
 * Singleton Prototype request session globalsession
 * 
 * Injecting Prototype bean into a Singleton bean --
 * When you inject prototype bean to singleton bean, prototype bean still behave like a singleton bean.
 * 
 * Circular dependencies --
 * Error: Requested bean is currently in creation: Is there an unresolvable circular reference?
 * Use Setter injection instead of Constructor injection
 * Use @Lazy with @Autowired    public A(@Lazy B b) { ... }
 * 
 * Spring MVC --
 * Spring MVC is part of Spring framework used to build a web application.
 * It is build on top of Servlet API.
 * It follows Model-View-Controller design pattern.
 * Model (Data) - View (Presenting data) - Controller (Servlet interface)
 * 
 * Dispatcher Servlet/Front controller --
 * Handles all incoming HTTP requests and send back response to client
 * Client -> DS -> Controller -> View Resolver -> View -> DS -> Client
 * 
 * Aspect Oriented Programming (AOP) --
 * 
 */


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //Resource res = new ClassPathResource("com/spring/core/config.xml");
        //BeanFactory context = new XmlBeanFactory(res);
        
        //ApplicationContext fcontext = new FileSystemXmlApplicationContext();
        //ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/spring/core/config.xml");
        
        System.out.println("------------------------");
        
        Student student = (Student) context.getBean("studentObject");
        System.out.println(student);
        
        System.out.println("------------------------");
        
        Employee employee = context.getBean("employeeObject", Employee.class);
        System.out.println(employee);
        
        System.out.println("------------------------");
        
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        
        System.out.println("------------------------");
        
        SpelExpressionParser spel = new SpelExpressionParser();
        Expression expr = spel.parseExpression("10+20");
        System.out.println("Expression evaluate: " + expr.getValue());
        
        System.out.println("------------------------");

        context.registerShutdownHook();
        context.close();
        
        System.out.println("------------------------");
        
        ApplicationContext acontext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        /*Annotation annotation = acontext.getBean("annotation", Annotation.class);*/
        Annotation annotation = acontext.getBean("getAnnotation", Annotation.class);
        System.out.println(annotation);
        
        System.out.println("------------------------");
        
    }
}
