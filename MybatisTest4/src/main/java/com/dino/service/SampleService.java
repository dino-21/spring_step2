package com.dino.service;

import java.util.List;

import com.dino.domain.TestVO;

public interface SampleService {
	public int insert(TestVO vo);

	public List<TestVO> getList();

	public TestVO getOne(int id);

	public int update(TestVO vo);

	public int delete(int id);
}
