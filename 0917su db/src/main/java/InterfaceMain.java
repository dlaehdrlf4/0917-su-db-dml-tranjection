import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.Personinterface;
import com.pk.mybatis.domain.PersonVO;

public class InterfaceMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//매퍼 인터페이스를 구현한 객체 찾아오기
		Personinterface personInterface = context.getBean(Personinterface.class);
		
		List<PersonVO> list = personInterface.list();
		
//		for(PersonVO vo : list) {
//			System.out.println(vo);
//		}
//		
		PersonVO vo = personInterface.select("mmm");
		System.out.println(vo);
		
		
		context.close();
		}

}
