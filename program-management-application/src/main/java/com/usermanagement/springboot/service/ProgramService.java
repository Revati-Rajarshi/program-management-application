package com.usermanagement.springboot.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.usermanagement.springboot.dao.ProgramDAO;
import com.usermanagement.springboot.exception.ProgramNotFoundException;
import com.usermanagement.springboot.model.Program;

@Component
public class ProgramService {
	
	@Autowired
	private ProgramDAO programDAO;
	
	private List<Program> programList = new CopyOnWriteArrayList();
	
	public Program addProgram(Program program) {
		return this.programDAO.save(program);
	}

	public List<Program> getAllPrograms(){
		return this.programDAO.findAll();
	}
	
	public Program getProgram(int pid) {
		return this.programDAO.findById(pid)
				.orElseThrow(() -> new ProgramNotFoundException("Program not found with id: " + pid));
	}
	
	public Program updateProgram(int pid, Program program) {
		program.setPid(pid);
		Program existing = programDAO.findById(pid)
				.orElseThrow(() -> new ProgramNotFoundException("Program not found with id: " + pid));
		existing.setPname(program.getPname());
		existing.setDetails(program.getDetails());
		existing.setActive(program.isActive());
		
		return this.programDAO.save(existing);
		
	}
	
	public ResponseEntity<Object> deleteProgram(int pid) {
		Program existing = programDAO.findById(pid)
				.orElseThrow(() -> new ProgramNotFoundException("Program not found with id: " + pid));
		programDAO.delete(existing);
		return ResponseEntity.ok().build();
	}
}
