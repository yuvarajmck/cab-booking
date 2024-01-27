package com.terzo.CabBooking.service.Impl;

import com.terzo.CabBooking.Dto.FeedbackDto;
import com.terzo.CabBooking.model.Feedback;
import com.terzo.CabBooking.repository.FeedbackRepository;
import com.terzo.CabBooking.repository.TripRepository;
import com.terzo.CabBooking.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final TripRepository tripRepository;
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(TripRepository tripRepository, FeedbackRepository feedbackRepository) {
        this.tripRepository = tripRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public void save(FeedbackDto feedback) {
        feedbackRepository.save(mapToFeedback(feedback));
    }

    private Feedback mapToFeedback(FeedbackDto feedbackDto) {
        return Feedback.builder()
                .feedBack(feedbackDto.getFeedback())
                .rating(feedbackDto.getRating())
                .tripInfo(tripRepository.findById(feedbackDto.getTripId()).get())
                .build();
    }
}
