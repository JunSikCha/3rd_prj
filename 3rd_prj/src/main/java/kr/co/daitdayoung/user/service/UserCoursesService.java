package kr.co.daitdayoung.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.co.daitdayoung.user.dao.UserCoursesDAO;
import kr.co.daitdayoung.user.domain.CoursesExamInfoDomain;
import kr.co.daitdayoung.user.domain.UserCoursesDomain;
import kr.co.daitdayoung.user.domain.UserCoursesExamDomain;
import kr.co.daitdayoung.user.domain.UserCoursesLectureDomain;
import kr.co.daitdayoung.user.domain.UserCoursesNoticeDomain;
import kr.co.daitdayoung.user.vo.UserCoursesVO;

@Component
public class UserCoursesService {

	@Autowired
	private UserCoursesDAO ucDAO;

	public UserCoursesDomain searchCoursesInfo(UserCoursesVO ucVO) {

		UserCoursesDomain umcd = ucDAO.selectCourseInfo(ucVO);
		return umcd;
	}// searchCoursesInfo

	public List<UserCoursesNoticeDomain> searchCoursesNoticeList(String couCode) {
		List<UserCoursesNoticeDomain> list = ucDAO.selectCourseNoticeList(couCode);
		return list;
	}// searchCoursesNoticeList

	public UserCoursesNoticeDomain searchCoursesNoticeDetail(String cnCode) {
		UserCoursesNoticeDomain ucnDomain = ucDAO.selectCourseNoticeDetail(cnCode);
		return ucnDomain;
	}// searchCoursesNoticeDetail

	public List<UserCoursesLectureDomain> searchCoursesLectureList(UserCoursesVO cuVO) {
		List<UserCoursesLectureDomain> list = ucDAO.selectCourseLectureList(cuVO);
		return list;
	}// searchCoursesLectureList

	public UserCoursesLectureDomain searchCoursesLectureDetail(UserCoursesVO cuVO) {
		UserCoursesLectureDomain uclDomain = ucDAO.selectCourseLectureDetail(cuVO);
		return uclDomain;
	}// searchCoursesLectureDetail
	
	@Transactional
	public int modifyCoursesRecode(UserCoursesVO ucVO) {
		int cnt = 0;
		try {
			cnt += ucDAO.updateCoursesRecode(ucVO);
			cnt += ucDAO.updateCoursesRegistration(ucVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public UserCoursesExamDomain searchCoursesExam(String couCode) {
		UserCoursesExamDomain uceDomain = ucDAO.selectCourseExam(couCode);
		return uceDomain;
	}// searchCoursesExam

	public CoursesExamInfoDomain searchCoursesExamInfo(UserCoursesVO cuVO) {
		CoursesExamInfoDomain examInfo = ucDAO.selectCourseExamInfo(cuVO);
		
		return examInfo;
	}// searchCoursesLectureDetail

}// class