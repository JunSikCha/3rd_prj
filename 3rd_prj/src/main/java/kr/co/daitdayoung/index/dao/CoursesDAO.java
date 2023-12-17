package kr.co.daitdayoung.index.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.daitdayoung.dao.MyBatisHandler;
import kr.co.daitdayoung.index.domain.CoursesDomain;

@Component
public class CoursesDAO {
	
	 @Autowired private MyBatisHandler mbh;

	public List<CoursesDomain> selectLeftCat() {
		
		mbh = MyBatisHandler.getInstance();
		
		SqlSession ss = mbh.getMyBatisHandler(false);
		
		List<CoursesDomain> idList = ss.selectList("kr.co.daitdayoung.index.leftCategory");
		
		mbh.closeHandler(ss);
		
		return idList;
	
	
	} //selectCourses
	
	
	 
		
} //class