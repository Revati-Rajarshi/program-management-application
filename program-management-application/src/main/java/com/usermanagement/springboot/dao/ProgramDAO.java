package com.usermanagement.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.springboot.model.Program;


@Repository
public interface ProgramDAO extends JpaRepository<Program, Integer>{

}
