package com.videoMeetingApplication.service;

import com.videoMeetingApplication.entity.Invite;
import com.videoMeetingApplication.repository.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviteServiceImpl implements InviteService {

    InviteRepository inviteRepository;

    @Autowired
    public InviteServiceImpl(InviteRepository inviteRepository) {
        this.inviteRepository = inviteRepository;
    }

    @Override
    public void saveInvite(Invite invite) {
        inviteRepository.save(invite);
    }

    @Override
    public Invite findByMeetingIdAndUserId(Integer meetingId, Integer userId) {
        return inviteRepository.findByMeetingIdAndUserId(meetingId, userId);
    }
}