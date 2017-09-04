package com.lifeintokyo.cds.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeintokyo.cds.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findByKanaStartingWithOrderByKanaDesc(String kana);
	public Page<Student> findByKanaStartingWithOrderByKanaDesc(String kana, Pageable pageable);
	public List<Student> findByUpdatedate(Date startDate);
	public List<Student> findAllByOrderByKanaDesc();
	public Page<Student> findAllByOrderByKanaDesc(Pageable pageable);
}
