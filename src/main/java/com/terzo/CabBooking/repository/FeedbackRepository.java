package com.terzo.CabBooking.repository;

import com.terzo.CabBooking.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
