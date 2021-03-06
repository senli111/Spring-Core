package cn.ucaner.spring.tiny.context;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.beans.factory.AutowireCapableBeanFactory;
import cn.ucaner.spring.tiny.beans.factory.DefaultListableBeanFactory;
import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;
import cn.ucaner.spring.tiny.core.io.AnnotationBeanDefinitionReader;
import cn.ucaner.spring.tiny.core.io.Resource;

/**
* @Package：cn.ucaner.spring.tiny.context   
* @ClassName：AutowireApplicationContext   
* @Description：   <p> 给AutowireApplicationContext增加自动注入的功能</p>
* @Author： - chenwentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class AutowireApplicationContext extends DefaultListableBeanFactory implements AutowireCapableBeanFactory{

	private static Logger logger = LoggerFactory.getLogger(AutowireApplicationContext.class);
	
	/**
	 * 加载log4j的配置
	 */
	static{
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public AutowireApplicationContext(Resource resource) throws Exception
	{
		super(resource);
		refresh();
	}

	public AutowireApplicationContext(String location) throws Exception
	{
		super(location);
		refresh();
	}
	
	/**
	* @Package：cn.ucaner.spring.tiny.context   
	* @ClassName：AutowireAnnotationBeanDefinition   
	* @Description：   <p> 继承ComponentHandle，拥有解析@component注解的能力 </p>
	* @Author： - Jason   
	* @CreatTime：2018年5月30日 下午9:01:35   
	* @Modify By：   
	* @ModifyTime：  2018年5月30日
	* @Modify marker：   
	* @version    V1.0
	 */
	private class AutowireAnnotationBeanDefinition extends AnnotationBeanDefinitionReader{
		public AutowireAnnotationBeanDefinition(BeanDefinitionRegistry registry){
			super(registry);
		}
	}
	
	
	@Override
	protected void refresh() throws Exception {
		int count=new AutowireAnnotationBeanDefinition(this).loadBeanDefinitions(resource);
		logger.info("[Tiny-Spring] Total Register Count-{} beanDfinition.",count);
	}

	
    @Override
    public void AutowireBean() {
        
    }
}
 