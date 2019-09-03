import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jndi.support.SimpleJndiBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class SimpleJndiBeanFactoryTest {

    private SimpleJndiBeanFactory beanFactory;

    @Before
    public void init() {
        beanFactory = new SimpleJndiBeanFactory();
        beanFactory.addShareableResource("java:comp/env/mysql");
    }

    @Test
    public void testSimpleJndiBeanFactory() {
        beanFactory.getBean("mysql");
    }
}
