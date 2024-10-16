package com.videoMeetingApplication.controllers;

import com.videoMeetingApplication.entity.Invite;
import com.videoMeetingApplication.entity.Meeting;
import com.videoMeetingApplication.entity.User;
import com.videoMeetingApplication.service.InviteService;
import com.videoMeetingApplication.service.MeetingService;
import com.videoMeetingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    private MeetingService meetingService;
    private UserService userService;
    private InviteService inviteService;

    @Autowired
    public HomeController(MeetingService meetingService, UserService userService, InviteService inviteService) {
        this.meetingService = meetingService;
        this.userService = userService;
        this.inviteService = inviteService;
    }

    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping("/newMeeting")
    public String newMeeting(Model model) {
        return "newMeeting";
    }

    @GetMapping("/joinMeeting")
    public String joinMeeting(Model model) {
        return "join-meeting";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "sign-in";
    }

    @GetMapping("/userDashboard")
    public String userDashboard(Model model) {
        User currentLoggedInUser = userService.getCurrentUser();
        System.out.println(currentLoggedInUser);
        if (currentLoggedInUser == null) {
            System.out.println("Please Login first");
            return "sign-in";
        }

        Integer userId = currentLoggedInUser.getId();
        List<Meeting> scheduledMeetings = meetingService.getAllScheduledMeetingsByHostId(userId);
        Map<Meeting, Integer> invitedMeetings = new HashMap<>();

        for (Meeting currMeeting : currentLoggedInUser.getInvitedMeetings()) {
            Integer meetingId = currMeeting.getId();
            Invite invite = inviteService.findByMeetingIdAndUserId(meetingId, userId);
            int status = invite.getStatus();
            invitedMeetings.put(currMeeting, status);
        }

        model.addAttribute("loggedInUser",currentLoggedInUser);
        model.addAttribute("scheduledMeetings", scheduledMeetings);
        model.addAttribute("invitedMeetings", invitedMeetings);
        model.addAttribute("meeting", new Meeting());
        return "user-dashboard";
    }
}