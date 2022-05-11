
package com.financialorgratingsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialorgratingsystem.entity.Organization;
import com.financialorgratingsystem.exception.OrganizationIdNotFoundException;
import com.financialorgratingsystem.repository.OrganizationRepo;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	OrganizationRepo organizationRepo;

	@Transactional
	@Override
	public Organization addOrganization(Organization o) {
		Organization organization = organizationRepo.save(o);
		return organization;
	}


	@Override
	public Organization updateOrganization(Organization o) {
		Organization organization = null;
		if (organizationRepo.existsById(o.getOrganizationId())) {
			organization = organizationRepo.save(o);
			return organization;
		}
	
		return organization;
	}

	@Override
	public Organization getOrganizationByOrganizationId(int organizationId) throws OrganizationIdNotFoundException {
		if (organizationRepo.existsById(organizationId)) {
			return organizationRepo.getById(organizationId);
		}
		else  {
			throw new OrganizationIdNotFoundException("Enter valid Id");
		}
	}

	@Override
	public List<Organization> getAllOrganization() {
		return organizationRepo.findAll();
	}
}
