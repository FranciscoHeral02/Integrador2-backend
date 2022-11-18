package com.ci2.sgth.people.infraestructure.expose;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci2.sgth.people.application.service.CampusService;
import com.ci2.sgth.people.domain.dto.CampusDto;

@RestController
@RequestMapping("/campus")
public class CampusController {
	@Autowired
	private CampusService campusService;
	
	@PostMapping
	public ResponseEntity<CampusDto> saveCampusInformation(@RequestBody CampusDto campus){
		
		return new ResponseEntity<CampusDto>(campusService.addCampus(campus),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CampusDto> updateCampusInformation(@RequestBody CampusDto campus){
		
		return new ResponseEntity<CampusDto>(campusService.addCampus(campus),HttpStatus.OK);
	}
	
	@DeleteMapping("/{idCampus}")
	public ResponseEntity<String> deleteCampusInformation(@PathVariable Long idCampus){
		
		campusService.deleteCampus(idCampus);
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<CampusDto>> getAllCampussInformation(){
		
		return new ResponseEntity<Set<CampusDto>>(campusService.getAllCampus(),HttpStatus.OK);
	}
	
	@GetMapping("/{idCampus}")
	public ResponseEntity<CampusDto> getCampusInformation(@PathVariable Long idCampus){
		
		return new ResponseEntity<CampusDto>(campusService.getCampus(idCampus),HttpStatus.OK);
	}
}
