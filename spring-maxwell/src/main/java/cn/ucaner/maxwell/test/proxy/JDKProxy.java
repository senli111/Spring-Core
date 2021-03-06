package cn.ucaner.maxwell.test.proxy;

import java.lang.reflect.Proxy;

/**
* @Package：cn.ucaner.maxwell.test.proxy   
* @ClassName：JDKProxy   
* @Description：   <p> 测试JDK动态代理 </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:46:09   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class JDKProxy {

	/**
	 * @Description: java.lang.reflect.Proxy 
	 */
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        //java.lang.reflect.Proxy   JDK动态代理
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),new Class[]{UserService.class}, new Handler(userService));
        proxy.printName();
    }

}
//outputs 
//[MaxWell-Handler]Method printName is proxyed.
//Name is xxxx
//Age: 18