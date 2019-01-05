package bitirme.service;

import java.util.List;

//import com.bitirme.exception.ExamNotFoundException;

import bitirme.model.ClassicExam;
import bitirme.model.TestExam;
import bitirme.model.User;

public interface ExamServiceWeb {
	public List<ClassicExam> findAll();
	public List<TestExam> findAllTest();
	List<ClassicExam> findExams(String name);
	ClassicExam findById(String id);// throws ExamNotFoundException;
	void createExam(ClassicExam exam);
	void updateExam(ClassicExam exam);
	void deleteExam(Long id);
	void createUser(User user);
}
