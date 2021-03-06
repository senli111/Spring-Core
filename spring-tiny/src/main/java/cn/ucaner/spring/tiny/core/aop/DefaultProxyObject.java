package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.Proxy;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：DefaultProxyObject   
* @Description：   <p> DefaultProxyObject 
* 
* - 默认的代理对象 
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DefaultProxyObject extends AbstractProxy{

	/**
	 * getProxyObject
	 * JDK 动态生成
	 */
	@Override
	public  Object getProxyObject(Object obj, Aop aop) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new DefaultAOPHandler(obj,aop));
	}


	/**
	 * getProxyObjectByType 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProxyObjectByType(Class<T> clz, Aop aop){
		Object obj=null;
		try {
			obj= getProxyObject(clz.newInstance(),aop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T)obj;
	}
}
