import com.cy.edu.SpringConfig;
import com.cy.edu.dao.AccountDao;
import com.cy.edu.pojo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Yang on 2020/10/8.
 */
public class SpringTest {

    @Test
    public void testIoc() {
        //通过读取配置文件
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\Yang\\IdeaProjects\\studySpring\\StudyspringTransfer-iocxml\\src\\main\\resources\\applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao);
        Object o = applicationContext.getBean("connectionUtils");
        System.out.println(o);
    }

    @Test
    public void testAnno() {
        //通过读取配置文件
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao);
        Object o = applicationContext.getBean("connectionUtils");
        System.out.println(o);
    }
}
