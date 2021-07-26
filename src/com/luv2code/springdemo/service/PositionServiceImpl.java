package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.dao.PositionDAO;
import com.luv2code.springdemo.entity.Position;

@Service
public class PositionServiceImpl implements PositionService {

	
	@Autowired
	private PositionDAO positionDAO;
	
	@Override
	@Transactional
	public List<Position> getPositions() {
		
		return positionDAO.getPositions();
		
	}
	

}
