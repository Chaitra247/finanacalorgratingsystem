package com.financialorgratingsystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.financialorgratingsystem.entity.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
	@Query("Select f from Feedback f where f.organizationId=?1")
	List<Feedback> getFeedbackByOrganization(int organizationId);

	@Query("Select f from Feedback f where f.userId=?1")
	List<Feedback> getFeedbackUser(int userId);
}