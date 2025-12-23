package com.beacon.Notifications;

import com.beacon.Notifications.Services.NotificationService;
import com.beacon.Users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // ---- CRUD by Notification id ----

    @PostMapping("/notifications")
    public ResponseEntity<NotificationDTO> create(@RequestBody NotificationDTO dto) {
        Notification created = notificationService.create(fromDto(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
    }

    @PutMapping("/notifications/{id}")
    public ResponseEntity<NotificationDTO> update(@PathVariable Long id, @RequestBody NotificationDTO dto) {
        Notification updated = notificationService.update(id, fromDto(dto));
        return ResponseEntity.ok(toDto(updated));
    }

    @GetMapping("/notifications/{id}")
    public ResponseEntity<NotificationDTO> getById(@PathVariable Long id) {
        Optional<NotificationDTO> dto = notificationService.getById(id).map(this::toDto);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/notifications")
    public ResponseEntity<List<NotificationDTO>> getAll() {
        List<NotificationDTO> result = notificationService.getAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/notifications/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        notificationService.deleteById(id);
    }

    // ---- Resource-oriented user scope ----

    @GetMapping("/users/{userId}/notifications")
    public ResponseEntity<List<NotificationDTO>> getByUser(@PathVariable Long userId) {
        List<NotificationDTO> result = notificationService.getByUserId(userId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    // ---- DTO mapping ----

    private NotificationDTO toDto(Notification notification) {
        return new NotificationDTO(
                notification.getId(),
                notification.getUser() != null ? notification.getUser().getId() : null,
                notification.getMessage()
        );
    }

    private Notification fromDto(NotificationDTO dto) {
        Notification notification = new Notification();

        if (dto.getUserId() != null) {
            User u = new User();
            u.setId(dto.getUserId());
            notification.setUser(u);
        }

        notification.setMessage(dto.getMessage());
        return notification;
    }
}