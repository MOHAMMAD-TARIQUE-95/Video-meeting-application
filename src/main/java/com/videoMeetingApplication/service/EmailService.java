package com.videoMeetingApplication.service;

import java.time.LocalDateTime;

public interface EmailService {

    void sendEmail(String[] to, String title,String host, LocalDateTime dateTime,int duration);
}
