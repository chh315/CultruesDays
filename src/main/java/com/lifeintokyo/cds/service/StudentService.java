package com.lifeintokyo.cds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeintokyo.cds.domain.School;
import com.lifeintokyo.cds.domain.Student;
import com.lifeintokyo.cds.repository.SchoolRepository;
import com.lifeintokyo.cds.repository.StudentRepository;
import com.lifeintokyo.cds.utils.DateFormatter;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	
	public Long saveStudent(Student student, long schoolid, String buzDate) {
		School school = schoolRepository.findOne(schoolid);
		
		student.setUpdatedate(DateFormatter.parse(buzDate));
		student.setId(null);
		student.setSchool(school);
		student = studentRepository.save(student);
		
		return student.getId();
	}
	
	public Page<Student> listStudents(Pageable pageable, String startWithKana) {
		if (startWithKana == null || "".equals(startWithKana)) {
			return studentRepository.findAllByOrderByKanaDesc(pageable);
		} else {
			return studentRepository.findByKanaStartingWithOrderByKanaDesc(startWithKana, pageable);
		}
	}
	public List<Student> listStudents() {
			return studentRepository.findAllByOrderByKanaDesc();
	}
	
}
