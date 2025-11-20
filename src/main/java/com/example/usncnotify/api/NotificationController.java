package com.example.usncnotify.api;

import com.example.usncnotify.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/distance/{old}/{current}")
    public ResponseEntity<String> receiveNotification(@PathVariable int old, @PathVariable int current) {
        notificationService.Notify(old, current);
        return ResponseEntity.ok("notification sent");
    }
}
