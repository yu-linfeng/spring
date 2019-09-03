import com.coderbuff.bean.Instance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Arrays;

/**
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class DefaultListableBeanFactoryTest {

    private DefaultListableBeanFactory beanFactory;

    private boolean isXml = true;

    @Before
    public void init() {
        beanFactory = new DefaultListableBeanFactory();
        if (isXml) {
            isXml(beanFactory);
        } else {
            isCode(beanFactory);
        }

    }

    /**
     * 通过XML配置文件加载Bean定义
     * @param beanFactory DefaultListableBeanFactory
     */
    private void isXml(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/spring-beanfactory.xml");
    }

    /**
     * 通过编码方式加载Bean定义
     * @param beanFactory DefaultListableBeanFactory
     */
    private void isCode(DefaultListableBeanFactory beanFactory) {
        AbstractBeanDefinition beanDefinition = new RootBeanDefinition(Instance.class);
        //Bean定义注册到容器中
        beanFactory.registerBeanDefinition("instance", beanDefinition);
        //指定依赖关系
        /*MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new ropertyValue("newsListener",newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
        beanDefinition.setPropertyValues(propertyValues);*/
    }

    @Test
    public void testDefaultListableBeanFactory() {
        Assert.assertNotNull(beanFactory.getBean("instance"));
        System.out.println(Arrays.asList(beanFactory.getBeanDefinitionNames()));
    }
}
