import com.coderbuff.bean.Instance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.StaticListableBeanFactory;

/**
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class StaticListableBeanFactoryTest {

    private StaticListableBeanFactory beanFactory;

    @Before
    public void init() {
        beanFactory = new StaticListableBeanFactory();
        Instance instance = new Instance();
        beanFactory.addBean("instance", instance);
    }

    @Test
    public void testStaticListableBeanFactory() {
        Assert.assertNotNull(beanFactory.getBean("instance"));
    }
}
