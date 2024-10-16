package com.videoMeetingApplication.service;

import com.videoMeetingApplication.entity.Invite;

public interface InviteService {
    void saveInvite(Invite invite);

    Invite findByMeetingIdAndUserId(Integer meetingId, Integer userId);
}
