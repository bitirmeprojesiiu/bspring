package bitirme.service;

import bitirme.dao.ExamDao;
import bitirme.dao.imp.IExamDao;
import bitirme.model.ClassicExam;
import bitirme.model.TestExam;
import bitirme.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceWebImp implements ExamServiceWeb {

	private ExamDao examRepository;

	@Autowired
	IExamDao examDao;
	
	@Autowired
	public void setExamRepository(ExamDao examRepository) {
		this.examRepository = examRepository;
	}
	
	@Override
	public List<ClassicExam> findAll() {
		//examRepository
		return null;
	}
	@Override
	public List<TestExam> findAllTest() {
		//examRepository
		return null;
	}

	@Override
	public List<ClassicExam> findExams(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassicExam findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createExam(ClassicExam exam) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateExam(ClassicExam exam) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExam(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createUser(User user) {

	}

	@Override
	public List<ClassicExam> getAllClassicExam (){
		return examDao.getAllClassicExam();
	}

	@Override
	public List<TestExam> getAllTestExam (){
		return examDao.getAllTestExam();
	}

}
