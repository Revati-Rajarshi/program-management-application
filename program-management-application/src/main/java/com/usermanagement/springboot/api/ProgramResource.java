package com.usermanagement.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.springboot.model.Program;
import com.usermanagement.springboot.service.ProgramService;

@RestController
@RequestMapping(value = "/programs")
public class ProgramResource {
	
	@Autowired
	private ProgramService programService;
	
	@PostMapping
	public Program addProgram(@RequestBody Program program){
		return programService.addProgram(program);
	}
	
	@GetMapping
	public List<Program> getAllPrograms(){
		return programService.getAllPrograms();
	}
	
	@GetMapping(value = "/{pid}")
	public Program getProgram(@PathVariable("pid") int pid) {
		return programService.getProgram(pid);
	}
	
	@PutMapping(value = "/{pid}")
	public Program updateProgram(@PathVariable("pid")int pid, @RequestBody Program program) {
		return programService.updateProgram(pid, program);	
	}
	
	@DeleteMapping(value = "/{pid}")
	public ResponseEntity<Object> deleteProgram(@PathVariable("pid") int pid) {
		return programService.deleteProgram(pid);
	}
}
