import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.PersonDao;
import com.pk.mybatis.domain.PersonVO;

public class Main {
	public static void main(String [] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		PersonDao dao = context.getBean(PersonDao.class);
		
		System.out.println(dao);
		
	//	List<PersonVO> list = dao.list();
		
//		for(PersonVO imsi : list) {
//		System.out.println(imsi);
//	}
//	
		
		//id를 가지고 데이터를 조회하는 메소드 호출
		//PersonVO vo = dao.listid("gil");
		//System.out.println(vo);
		
		Scanner sc = new Scanner(System.in);
		//primary key를 입력받는 경우에는 반드시 중복체크를 해야합니다.
		String id = "";
while(true) {
	System.out.println("사용할 id를 입력하세요:");
		id = sc.nextLine();
		PersonVO vo = dao.listid(id);
		if(vo == null) {
			break;
	}
	System.out.println(id + "는 사용 불가능한 id 입니다");
	}
	System.out.println("비밀번호 입력:");
	String pw = sc.nextLine();
	
	System.out.println("이름 입력:");
	String name = sc.nextLine();
	
	System.out.println("전화번호 입력:");
	String phone = sc.nextLine();
	
	PersonVO newVO = new PersonVO();
	newVO.setId(id);
	newVO.setPw(pw);
	newVO.setName(name);
	newVO.setPhone(phone);
	//select 이외의 구문은 영향받은 행의 개수를 리턴
	int result = dao.insertprocedure(newVO);
	
	if(result > 0) {
	System.out.println(name + "님이 삽입되었습니다.");
	}
	
	

	sc.close();
	context.close();
		
	}
}
