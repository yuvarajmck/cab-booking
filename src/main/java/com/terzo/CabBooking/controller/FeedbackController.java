package com.terzo.CabBooking.controller;

import com.terzo.CabBooking.Dto.FeedbackDto;
import com.terzo.CabBooking.service.FeedbackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/new")
    public String addFeedback(@RequestBody FeedbackDto feedback){
        feedbackService.save(feedback);
        return "Feedback added";
    }
}
