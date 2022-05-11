
package com.financialorgratingsystem.service;

import java.util.List;

import com.financialorgratingsystem.entity.Organization;
import com.financialorgratingsystem.exception.OrganizationIdNotFoundException;

public interface OrganizationService {
	public Organization addOrganization(Organization o);

	public Organization getOrganizationByOrganizationId(int organizationId) throws OrganizationIdNotFoundException;

	public Organization updateOrganization(Organization o);

	public List<Organization> getAllOrganization();
}
