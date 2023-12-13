package com.dino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dino.domain.TestVO;
import com.dino.mapper.TestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service  //  스프링 서비스
@Log4j  // 롬복 라이브러리에서 제공되는 로그
@RequiredArgsConstructor 
public class SampleServiceImpl implements SampleService {
	   // 자동주입
		private final TestMapper testMapper;
		
		@Override
		public int insert(TestVO vo) {
			return testMapper.insert(vo);
		}

		@Override
		public List<TestVO> getList() {
			return testMapper.getList();
		}

		@Override
		public TestVO getOne(int id) {
			return testMapper.getOne(id);
		}

		@Override
		public int update(TestVO vo) {
			return testMapper.update(vo);
		}

		@Override
		public int delete(int id) {
			return testMapper.delete(id);
		}
}
