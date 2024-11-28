package java15;

import java15.entities.Programmer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Programmer programmer = context.getBean("programmer", Programmer.class);

        context.close();
    }
}
