
package com.financialorgratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.financialorgratingsystem.entity.Organization;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Integer> {
	@Query("Select o from Organization o where o.userName=?1 and o.password=?2")
	public Organization validateOrganizationCredentials(String userName, String password);
}
