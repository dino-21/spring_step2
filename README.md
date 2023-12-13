3 tier


data  - service - controller 




![44-2](https://github.com/dino-21/Spring_Mybatis5/assets/80396471/b63baf3a-9a7f-4210-814c-f95d4f5b5f06)



![1-1](https://github.com/dino-21/Spring_Mybatis5/assets/80396471/ad0947d3-9802-487c-98b6-5ecf5ca06939)



![1-3](https://github.com/dino-21/Spring_Mybatis5/assets/80396471/d92242cc-429f-406e-9421-be8759fb1f83)



![1-5](https://github.com/dino-21/Spring_Mybatis5/assets/80396471/8df9d387-7f48-4ac6-aab9-f29db6969825)




data 계층에서 테스트하고 service 계층에서 작업하기

1. com.dino.service 패키지 만들고
SampleService.java 인터페이스 만들기

mapper에 있는 CRUD메서드 가져오기

2. SampleServiceImpl.java 파일 만들기
오버라이딩 메서드 만들기

@RequiredArgsConstructor어노테이션 만들고
final TestMapper 만들어서 자동주입하기


3. @Lo4j 에러나면
pom.xml 에서 log4j에서 runtime scope 주석처리하기

4. servlet-context.xml파일 수정
<!-- 서비스 패키지 내의 컴포넌트를 스캔 -->
<context:component-scan base-package="con.dino.service" />


5 . SampleServiceTest.java 파일 만들기 (테스트 파일)
SampleService.java 인터페이스 파일 우클릭
New > Junit Test Case

어노테이션에 servlet-context.xml추가
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

6. SampleServiceTest.java 코드 추가 - CRUD
각 메소드마다 테스트
콘솔과 mysql에서 확인



7. service 계층에서 테스트하고 Controller 계층 작업하기
SampleController.java 인터페이스 파일 만들기
src/main/java 패키지 아래
com.dino.controller 패키지 아래 SampleController.java파일 만들기

@RequiredArgsConstructor 어노테이션과
final SampleService service 만들어서 자동주입하기

어노테이션 @GetMapping("/read") 붙여서 read 메소드 만들기

매개변수로 @RequestParam("id") 사용
브라우저 요청하는 parm의 값 가져옴


8. 톰캣에서 Server에서 context수정하기
프로젝트 작업할때마다 context는 controller가 기본값으로
되어 있으므로 매번 수정해서 확인해 줘야 함.
http://localhost:8282/controller 삭제에서 controller를 삭제하기
context를 /controller를 삭제하기


9. 실행해보면
controller 계층에서 SampleController.java 페이지에서 실행해보면
@GetMapping("/read") read.jsp파일이 없어서 에러남
views 폴더 아래 read.jsp파일 만들기
<h3>${list}</h3> 코드 추가

10. 브라우저에 값을 보고 싶으면 SampleController.java 코드 수정
매개변수 자리에 파라미터를 Model사용
Model은 jsp화면에 값을 전달하고 싶을때 사용
(Model model)
model.addAttribute("list", vo);

10. 브라우져에서 ?id=4 sql에 있는 4번 값을 확인하기
http://localhost:8282/read?id=4
