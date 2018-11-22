package filemanage.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Spring Bean操作类
 * 
 */
public class BeanFactoryHelper implements BeanFactoryAware {
    private static BeanFactory beanFactory; //BEAN工厂
    @SuppressWarnings("static-access")
	@Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    public static BeanFactory getBeanfactory() {
        return beanFactory;
    }
}
