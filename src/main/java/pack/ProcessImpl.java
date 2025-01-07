package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessImpl implements ProcessInter{
	// TODO 1016 Spring _ DB 02 _ 직원 정보 출력 예제 _ Annotation
	@Autowired
	private JikwonInter jikwonInter;
	
	@Override
	public void showData() {
		for (JikwonDto s : jikwonInter.selectList()) {
			System.out.println(s.getJikwonno() + " " + 
				s.getJikwonname() + " " + 
				s.getBusername() + " " + 
				s.getJikwonjik());
		}
		System.out.println("건수 : " + jikwonInter.selectList().size());
	}
}
