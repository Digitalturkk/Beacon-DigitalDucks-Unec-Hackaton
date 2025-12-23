// src/main/java/com/beacon/Achievements/UserAchievement/UserAchievementController.java
package com.beacon.Achievements.UserAchievement;

import com.beacon.Achievements.Achievement;
import com.beacon.Achievements.UserAchievement.Services.UserAchievementService;
import com.beacon.Users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user-achievements")
public class UserAchievementController {

    private final UserAchievementService userAchievementService;

    public UserAchievementController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

    @PostMapping
    public ResponseEntity<UserAchievementDTO> create(@RequestBody UserAchievementDTO dto) {
        UserAchievement created = userAchievementService.create(fromDto(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAchievementDTO> update(@PathVariable Long id, @RequestBody UserAchievementDTO dto) {
        if (!userAchievementService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        UserAchievement updated = userAchievementService.update(id, fromDto(dto));
        return ResponseEntity.ok(toDto(updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAchievementDTO> getById(@PathVariable Long id) {
        Optional<UserAchievement> found = userAchievementService.getById(id);
        return found.map(ua -> ResponseEntity.ok(toDto(ua)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserAchievementDTO>> getAll(
            @RequestParam(name = "userId", required = false) Long userId,
            @RequestParam(name = "achievementId", required = false) Long achievementId
    ) {
        List<UserAchievement> items;

        if (userId != null && achievementId != null) {
            Optional<UserAchievement> one = userAchievementService.getByUserIdAndAchievementId(userId, achievementId);
            items = one.map(List::of).orElseGet(List::of);
        } else if (userId != null) {
            items = userAchievementService.getByUserId(userId);
        } else if (achievementId != null) {
            items = userAchievementService.getByAchievementId(achievementId);
        } else {
            items = userAchievementService.getAll();
        }

        List<UserAchievementDTO> result = items.stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        userAchievementService.deleteById(id);
    }

    private UserAchievementDTO toDto(UserAchievement ua) {
        Long userId = ua.getUser() != null ? ua.getUser().getId() : null;
        Long achievementId = ua.getAchievement() != null ? ua.getAchievement().getId() : null;

        return new UserAchievementDTO(
                ua.getId(),
                userId,
                achievementId,
                ua.getReceivedAt()
        );
    }

    private UserAchievement fromDto(UserAchievementDTO dto) {
        UserAchievement ua = new UserAchievement();

        if (dto.getUserId() != null) {
            User userRef = new User();
            userRef.setId(dto.getUserId());
            ua.setUser(userRef);
        }

        if (dto.getAchievementId() != null) {
            Achievement achievementRef = new Achievement();
            achievementRef.setId(dto.getAchievementId());
            ua.setAchievement(achievementRef);
        }

        ua.setReceivedAt(dto.getReceivedAt());
        return ua;
    }
}