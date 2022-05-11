
package com.financialorgratingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialorgratingsystem.entity.Organization;
import com.financialorgratingsystem.exception.OrganizationIdNotFoundException;
import com.financialorgratingsystem.service.OrganizationService;

@RestController
@RequestMapping("/org")
@CrossOrigin(origins = "http://localhost:3000/")
public class OrganizationController {
	@Autowired
	OrganizationService organizationService;

	@PostMapping("/add")
	public ResponseEntity<Organization> insertOrganization(@RequestBody Organization org) {
		Organization org1 = organizationService.addOrganization(org);
		return new ResponseEntity<>(org1, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization o) {
		Organization org = organizationService.updateOrganization(o);
		if (o == null) {
			return new ResponseEntity("Sorry! update failed!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	@GetMapping("get/{organizationId}")
	public ResponseEntity<Organization> getOrganizationByOrganizationId(
			@PathVariable("organizationId") int organizationId) throws OrganizationIdNotFoundException {
		
		Organization organization = organizationService.getOrganizationByOrganizationId(organizationId);
	
		return new ResponseEntity<>(organization, HttpStatus.OK);
	}
	@GetMapping("/allorg")
	public List<Organization> getAllOrganization() {
		return organizationService.getAllOrganization();
	}
}
