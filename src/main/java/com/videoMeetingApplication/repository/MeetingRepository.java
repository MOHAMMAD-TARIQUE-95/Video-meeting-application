package com.videoMeetingApplication.repository;

import com.videoMeetingApplication.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

    Meeting findMeetingById(Integer meetingId);

    List<Meeting> findMeetingsByHostId(Integer userId);
}

