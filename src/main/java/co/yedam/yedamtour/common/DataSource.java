package co.yedam.yedamtour.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//싱글톤 class 
public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
		
		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	// sqlSessionFactory를 SqlSessionFactoryBuilder통해서 빌드
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
