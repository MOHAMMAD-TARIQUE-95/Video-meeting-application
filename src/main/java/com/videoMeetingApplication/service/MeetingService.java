package com.videoMeetingApplication.service;

import com.videoMeetingApplication.entity.Meeting;

import java.util.List;

public interface MeetingService {
    List<Meeting> getAllScheduledMeetings();

    Meeting createMeeting(Meeting meeting);

    void scheduleMeeting(Meeting meeting);

    Meeting findMeetingById(Integer meetingId);

    void delete(Meeting meeting);

    List<Meeting> getAllScheduledMeetingsByHostId(Integer userId);


}

