[문항1] 자바 소스 파일을 컴파일하면 확장자가 '.class'인 목적 파일이 생성된다.
 이것은 플랫폼에 독립적이며 운영체제와 상관없이 실행가능한데, 
 특히 자바가상머신에서 실행할 수 있다는 특징을 가지고 있어서 기계어와비교하여 자바에서는 공식적인 표현으로 무엇이라고 부르는가? (배점:5)

 =>
원시코드 - SRC파일에 저장되는 .java 파일
바이트 코드 - bin 파일에 저장되는 .class 파일



[문항2] 객체 설계 5원칙에 대해 각각의 Full Name을 작성하시오. (배점:5)

=>





[문항3] 생성자 메서드의 특징을 5가지 이상 나열하시오. (배점:5)

=>
- 모든 클래스에 반드시 존재하는 메서드 (기본생성자)이다.
- 메서드 명은 반드시 클래스 명과 동일해야 한다,
- 단 한번만 호출 가능하다.
- 오버로딩이 가능하다
- 임의의 생성자(인자가 있는 생성자)를 만들게 되면 더 이상 기본 생성자는 제공되지 않는다.


[문항4] ShopService 객체를 싱글톤으로 만들려고 한다.
ShopServiceExample클래스에서 
ShopService의 getInstance()로 싱글톤을 얻을 수 있도록 
ShopService클래스를 작성하시오. (배점:10)

class ShopService {

}

class ShopServiceExample {
    public static void main(String[] args){
          ShopService obj1 = ShopService.getInstance();
          ShopService obj2 = ShopService.getInstance();

          if(obj1 == obj2) {
              System.out.println("같은 객체이다.");
          }
          else{
              System.out.println("다른 객체이다.");
          }
    }
}

=> 
class ShopService {
    private ShopService() {}

    private static ShopService instance = new ShopService();

    static ShopService getInstance() {
        return instance;
    }
}

class ShopServiceExample {
    public static void main(String[] args){
          ShopService obj1 = ShopService.getInstance();
          ShopService obj2 = ShopService.getInstance();

          if(obj1 == obj2) {
              System.out.println("같은 객체이다.");
          }
          else{
              System.out.println("다른 객체이다.");
          }
    }
}


[문항5] 스레드 동기화와 관련된 다음 설명 중 올바른 것을 고르시오.
그리고 올바르지 않은 것은 왜 그런지도 간단히 설명하시오. (배점:5)
① 스레드 동기화란 여러 스레드들이 하나의 공유 객체에 동시 접근하게 하기 위한 것이다.
② 메소드 notify()는 현재 실행중인 스레드를 정해진 시간 동안 중지시킨다.
③ 메소드 wait()는 대기 상태의 스레드들 가운데 하나를 기다리게 한다.
④ synchronized로 정의된 메소드는 한 번에 하나의 스레드에 의해서만 실행될 수 있다.

=>
1. 스레드 동기화란 하나의 공유객체에 한번에 하나씩 접근하는 것이다.
2. 메소드 notify()는 wait하고 있는 스레드를 다시 실행시키는 것이다.
3. 메소드 wait()는 여러 개의 스레드를 대시 상태로 하는 것이다 -> 한번에 실행시는 메소드가 notifyall()

정답 : 4번



[문항6] HTTP와 HTTPS의 차이를 설명하시오. (배점:5)

=>
http는 비연결 지향성과 무상태성을 가지고 있다.  -> 이를 보안하기 위해 쿠키, 세션, 토큰기반인증(JWT)를 사용한다. 

	
[문항7] 서블릿의 목적과 서블릿으로 만드려면 어떻게 해야하는지에 대해 서술하시오. (배점:5)

=>
get 방식
- 하이퍼링크 전송방식, URL 전송방식 
- 기본 전송 방식
- 소량의 데이터를 전송할 때 사용
- 전송되는 데이터가 쿼리 문자열로 외부에 노출 
- 데이터 조회 목적

post방식
- 폼 전송방식
- 대량의 데이터 전송할 때 사용 
- 전송되는 데이터가 노출되지 않음 -> 보안성 좋음
- 데이터 변경을 목적



[문항9] 다음의 html 내용에 따라 서블릿을 작성하고, 정상적인 출력(상품의 합계 가격)이 될 수 있도록 작성하시오.

제출할 파일 :
- 서블릿 클래스
- web.xml 또는 어노테이션 사 (배점:10)

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
    <h1>상품 계산 프로그램</h1>
    <form action="/ServletExam/market" method="GET">
        <input type="checkbox" name="food" value="2000"/>사과<br>
        <input type="checkbox" name="food" value="3000"/>계란<br>
        <input type="checkbox" name="food" value="2500"/>파<br><br>
        <input type="submit" value="계산"/>
    </form>
</body>
</html>

=>
package market;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletExam/market")
public class Total extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] foodItems = req.getParameterValues("food");
        int sum = 0;

        if (foodItems != null) {
            for (String item : foodItems) {
                try {
                    sum += Integer.parseInt(item);
                } catch (NumberFormatException e) {
                    System.out.println("유효한 숫자가 아닙니다: " + item);
                }
            }
        }
        resp.setContentType("text/html;charset=UTF-8");
        
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>계산 결과</h1>");
        resp.getWriter().println("<p>총합: " + sum + " 원</p>");
        resp.getWriter().println("</body></html>");
    }
}


[문항10] Cookie와 Session에 대해 차이점과 특징에 대해서 간단히 설명하시오. (배점:5)

=>
cookie  는 클라이언트 측 저장기술로 사용자의 보조기억장치에도 별도로 따로 저장하며, 사용자가 요청할 시에 사용자의 하드디스크에서 해당 데이터를 불러옵니다. 
텍스트만 저장 가능하며, 만료기간이 존재합니다.

session은 서버 측 저장기술로 서버측 메모리에 그 사용자만 접근할 수 있는 정보를 따로 저장합니다. 모든 타입의 데이터를 저장할 수 있으며, 
서버의 메모리가 허용하는 범위 내에서 얼마든지 저장 가능합니다.



[문항11] CSR과 SSR의 차이점에 대해 서술하시오. (배점:5)

=>

CSR(Client-Side Rendering)은 
웹브라우저에서 JS를 사용하여 콘텐츠를 랜더링하며, 초기 로딩시간이 길 수 있지만 페이지 전환이 빠릅니다.
서버 부하가 적고 클라이언트 리소스를 더 많이 사용합니다.

 SSR(Server-Side Rendering은
서버에서 HTML을 생성하여 클라이언트로 전송합니다.
초기 페이지 로딩이 빠르고 , 서버 부하가 높지만 클라이언트의 리소스 사용이 적습니다. 


	
[문항12] JSP에서 Context관련 객체들에 대해 나열하고, 
각각의 특징에 대해서 간단히 설명하시오. (배점:10)

=>
- session 
프로젝트 내에서 어느 페이지에서든 사용 가능
접속하는 사용자마다 하나씩 만들어져서 해당 사용자에 한해서 전역변수 
수시로 자동 삭제

-application
한 프로젝트 당 하나만 만들어져서 모든 사용자가 다 같이 사용할 가능 (전역변수)
처음 프로젝트가 서버에 올라갈때 만들어지며, 프로젝트가 서버에 살아있는 한 사라지지 않음

-pageContext
지역변수 개념으로 그 페이지에서만 사용 가능 
모든 범위, 모든 context 사용 가능한 
혼자서 session, application, request 모두 사용 가능

-request
사용자가 요청했을 때만 그 공간에 있는 데이터 사용할 수 있음 (포워드관계)


	
[문항13] 아래의 코드를 수행했을 경우 첫번째는 true가 나오고 두번째는 false가 나온다.
그 이유를 설명하고, 이것을 값만 비교할 수 있도록 코드를 수정하시오. (배점:10)

=>
obj1 와 obj2 는 Integer 안에 존재하기(-128~127) 때문에 같은 객체를 참조하고 있고 
obj3 와 obj4는 서로 다른 Integer  객체를 참조하고 있기때문에 false가 나온다.

public class Test {
    public static void main(String[] args) {
        Integer obj1 = 100;
        Integer obj2 = 100;
        Integer obj3 = 300;
        Integer obj4 = 300;
     
        System.out.println(obj1.equals(obj2));
        System.out.println(obj3.equals(obj4));
    }
}


[문항14] 다음 중 Bean Property 규약 중에 getter메서드에 대한 규칙이 바르지 않은 것들을 모두 고르시오. (배점:5)
① get다음에 시작하는 첫번째 문자는 소문자
② return type이 존재
③ void type이 존재
④ 매개변수가 없다.

=>
1. 반드시 대문자
3. return 타입임으로 void가 올 수 없다.


[문항15] Controller 클래스의 setService()를 호출하려고 한다.
setService()의 매개값으로 올 수 있는 것에 O표, 올 수 없는것에 X표를 하시오. (아래의 그림은 상속에 대한 구조이다.) (배점:10)

public class Controller {
    public MemberService service;
    public void setService(MemberService service) {
          this.service = service;
    }
}

Controller controller = new Controller();
controller.setService( __________?__________ );

① new Service( )        (    )
② new MemberService( )        (    )
③ new AService( )        (    )
④ new BService( )        (    )
⑤ new BoardService( )        (    )
⑥ new DService( )        (    )


=>
1. X
2. O
3. O
4. O
5. X
6. X