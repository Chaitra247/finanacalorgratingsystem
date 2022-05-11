package com.financialorgratingsystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financialorgratingsystem.entity.Feedback;
import com.financialorgratingsystem.exception.NotFoundException;
import com.financialorgratingsystem.repository.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackRepo feedbackRepo;

	@Override
	public List<Feedback> getAllFeedback() throws NotFoundException {
		return feedbackRepo.findAll();
	}



	@Override
	public Feedback getFeedbackByFId(int fId) {
		return feedbackRepo.findById(fId).get();
	}

	@Transactional
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback f = feedbackRepo.save(feedback);
		return f;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) throws NotFoundException {

	Feedback f = null;
	if (feedbackRepo.existsById(feedback.getFeedbackId())) {
	feedback = feedbackRepo.save(feedback);
	return f;
	}
return f;
	}

	@Override
	public boolean deleteFeedbackByFId(int fId) throws NotFoundException {
if(feedbackRepo.existsById(fId)) {
	feedbackRepo.deleteById(fId);
	return true;
	}
	throw new NotFoundException("Invalid FeedbackId");
}
}