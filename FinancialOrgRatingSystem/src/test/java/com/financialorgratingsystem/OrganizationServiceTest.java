package com.financialorgratingsystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.financialorgratingsystem.entity.Organization;
import com.financialorgratingsystem.exception.OrganizationIdNotFoundException;
import com.financialorgratingsystem.repository.OrganizationRepo;
import com.financialorgratingsystem.service.OrganizationService;

@SpringBootTest
public class OrganizationServiceTest {

	@Autowired
	OrganizationService organizationservice;

	@MockBean
	OrganizationRepo organizationRepo;

	Organization o1;

	@BeforeEach
	public void setUp() throws Exception {
		o1 = getOrganization();

	}
    
	private Organization getOrganization() {
		Organization o = new Organization();
		o.setOrganizationId(1);
		o.setUserName("Chaitra R");
		o.setPassword("C@2410");
		o.setOrganizationName("ABC");
		o.setOrganizationRating(4);
		o.setEmailId("abc@gmail.com");
		o.setContactNumber("566689909");
		o.setFinanceRating(4);
		return o;
	}

	@Test
	void testAddOrganization() {

		Mockito.when(organizationRepo.save(o1)).thenReturn(o1);
		assertThat(organizationservice.addOrganization(o1)).isEqualTo(o1);
	}

	@Test
	void testGetOrganizationByOrganizationId() throws OrganizationIdNotFoundException {

		Mockito.when(organizationRepo.existsById(o1.getOrganizationId())).thenReturn(true);
		Mockito.when(organizationRepo.getById(o1.getOrganizationId())).thenReturn(o1);
		assertThat(organizationservice.getOrganizationByOrganizationId(o1.getOrganizationId())).isEqualTo(o1);

	}

	@Test
	void testUpdateOrganization() throws OrganizationIdNotFoundException {

		Mockito.when(organizationRepo.existsById(o1.getOrganizationId())).thenReturn(true);
		Mockito.when(organizationRepo.save(o1)).thenReturn(o1);
		assertThat(organizationservice.updateOrganization(o1)).isEqualTo(o1);

	}

	@Test
	void testGetAllOrganization() {

		Organization o2 = new Organization();

		o2.setOrganizationId(3);
		o2.setUserName("Chaitra R");
		o2.setPassword("C@2410");
		o2.setOrganizationName("ABC");
		o2.setOrganizationRating(4);
		o2.setEmailId("abc@gmail.com");
		o2.setContactNumber("566689909");
		o2.setFinanceRating(4);
		List<Organization> orgList = new ArrayList<>();
		orgList.add(o1);
		orgList.add(o2);
		Mockito.when(organizationRepo.findAll()).thenReturn(orgList);
		assertThat(organizationservice.getAllOrganization()).isEqualTo(orgList);

	}
}