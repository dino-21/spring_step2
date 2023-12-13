package com.dino.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dino.domain.TestVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 컨텍스트 로드하고 JUnit 테스트 실행
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class SampleServiceTest {

	@Autowired
	private SampleService sampleService;

	@Test
	public void serviceInsert() {
		TestVO vo = TestVO.builder().title("서비스 제목3").content("서비스 내용3").build();
		sampleService.insert(vo);
	}

	@Test
	public void serviceGetList() {
		sampleService.getList().forEach(list -> log.info(list));
	}

	@Test
	public void testgetOne() {
		TestVO record = sampleService.getOne(3);
		log.info(">>>>>> Retrieved Record: " + record);
	}

	@Test
	public void testUpdate() {
		TestVO vo = TestVO.builder().id(2) // 업데이트할 번호 id 2
				.title("업데이트된 제목1").content("업데이트된 내용2").build();

		int result = sampleService.update(vo);
		log.info(">>>>>> Update result: " + result);
	}

	@Test
	public void testDelete() {
		int idToDelete = 3; // 삭제할 번호 id 3
		int result = sampleService.delete(idToDelete);
		log.info(">>>>>> Delete result: " + result);
	}
}
