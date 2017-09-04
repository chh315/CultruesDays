package com.lifeintokyo.cds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeintokyo.cds.domain.School;

public interface SchoolRepository extends JpaRepository<School, Long>{
}
