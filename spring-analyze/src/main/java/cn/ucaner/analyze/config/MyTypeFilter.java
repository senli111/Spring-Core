package cn.ucaner.analyze.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
* @Package：cn.ucaner.analyze.config   
* @ClassName：MyTypeFilter   
* @Description：   <p> MyTypeFilter </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:26:07   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
public class MyTypeFilter implements TypeFilter {

	/**
	 * metadataReader：读取到的当前正在扫描的类的信息   - 读取到的当前正在扫描的类的信息
	 * metadataReaderFactory:可以获取到其他任何类信息的   可以获取到其他的任何类型的信息的
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)throws IOException {
		/**
		 * 获取当前类注解的信息
		 */
		@SuppressWarnings("unused")
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		/**
		 * 获取当前正在扫描的类的类信息
		 */
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		/**
		 * 获取当前类资源（类的路径）
		 */
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName() ;
		
		//类名 - filter - 自定义的.
		System.out.println("--->"+className);
		if(className.contains("er")){
			return true;
		}
		return true;
	}

}
