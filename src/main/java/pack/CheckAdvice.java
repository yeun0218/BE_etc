package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckAdvice {
	
	@Around("execution(public void showData())")
	public Object check(ProceedingJoinPoint joinPoint) throws Throwable {
		// 핵심 로직 실행 전 부가 기능 (ID, PW 확인)
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디를 입력 : ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력 : ");
		String pw = scanner.nextLine();

		if (!id.equals("ok") || !pw.equals("123")) {
			System.out.println("불일치");
			return null;
		}

		System.out.println("인증 성공");
		
		
		Object  object =   joinPoint.proceed();
		return  object;
	}
	
}
