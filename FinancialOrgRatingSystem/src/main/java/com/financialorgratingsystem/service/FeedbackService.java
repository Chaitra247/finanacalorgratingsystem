package com.financialorgratingsystem.service;

import java.util.List;
import com.financialorgratingsystem.entity.Feedback;
import com.financialorgratingsystem.exception.NotFoundException;

public interface FeedbackService {
	public List<Feedback> getAllFeedback() throws NotFoundException;
	public Feedback addFeedback(Feedback feedback);
	Feedback getFeedbackByFId(int fId);
	public Feedback updateFeedback(Feedback feedback) throws NotFoundException;
	public boolean deleteFeedbackByFId(int fId) throws NotFoundException;
}