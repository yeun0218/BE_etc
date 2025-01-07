package pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="pack")
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {
        // TODO 1016 Spring _ DB 
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ProcessInter inter = context.getBean("processImpl", ProcessInter.class);
        inter.showData();
    }
}