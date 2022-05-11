package com.financialorgratingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialorgratingsystem.entity.Feedback;
import com.financialorgratingsystem.exception.NotFoundException;
import com.financialorgratingsystem.service.FeedbackService;

@RestController
@RequestMapping("/feed")
@CrossOrigin
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;

	@GetMapping("/get/feedback")
	public ResponseEntity<List<Feedback>> getAllFeedback() {
		List<Feedback> fList = feedbackService.getAllFeedback();
		return new ResponseEntity<>(fList, HttpStatus.OK);
	}

	@GetMapping("/getf/{feedbackId}")
	public ResponseEntity<Feedback> getFeedbackByFId(@PathVariable("feedbackId") int fId) {
		Feedback fId1 = feedbackService.getFeedbackByFId(fId);
		if (fId1 == null) {
			return new ResponseEntity("Sorry Feedback Not Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(fId1, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Feedback> insertFeedback(@RequestBody Feedback feedback) {
		Feedback feedback1 = feedbackService.addFeedback(feedback);
		if (feedback1 == null) {
			return new ResponseEntity("Sorry! Feedback not added!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) throws NotFoundException {
	Feedback f = feedbackService.updateFeedback(feedback);
	if (feedback == null) {
	return new ResponseEntity("Sorry! update failed!", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(feedback, HttpStatus.OK);
	}
	@DeleteMapping("/deletef/{fId}")
	public ResponseEntity<String> deleteFeedbackByFId(@PathVariable("fId") int fId) throws NotFoundException {
	boolean feedback=feedbackService.deleteFeedbackByFId(fId);
	ResponseEntity<String> res=new ResponseEntity("Feedback Deleted", HttpStatus.OK);
	if(feedback) {
	return res;
	}
	return null;
	}
}