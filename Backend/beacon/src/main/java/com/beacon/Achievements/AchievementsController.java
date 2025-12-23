// src/main/java/com/beacon/Achievements/AchievementsController.java
package com.beacon.Achievements;

import com.beacon.Achievements.Services.AchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/achievements")
public class AchievementsController {

    private final AchievementService achievementService;

    public AchievementsController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @PostMapping
    public ResponseEntity<AchievementsDTO> create(@RequestBody AchievementsDTO dto) {
        Achievement created = achievementService.create(fromDto(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AchievementsDTO> update(@PathVariable Long id, @RequestBody AchievementsDTO dto) {
        if (!achievementService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Achievement updated = achievementService.update(id, fromDto(dto));
        return ResponseEntity.ok(toDto(updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AchievementsDTO> getById(@PathVariable Long id) {
        Optional<Achievement> found = achievementService.getById(id);
        return found.map(a -> ResponseEntity.ok(toDto(a)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AchievementsDTO>> getAll(
            @RequestParam(name = "active", required = false) Boolean active
    ) {
        List<Achievement> achievements = achievementService.getAll();

        if (active != null) {
            achievements = achievements.stream()
                    .filter(a -> active.equals(a.getIsActive()))
                    .collect(Collectors.toList());
        }

        List<AchievementsDTO> result = achievements.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        achievementService.deleteById(id);
    }

    private AchievementsDTO toDto(Achievement a) {
        return new AchievementsDTO(
                a.getId(),
                a.getTitle(),
                a.getDescription(),
                a.getIcon(),
                a.getConditionType(),
                a.getIsActive()
        );
    }

    private Achievement fromDto(AchievementsDTO dto) {
        Achievement a = new Achievement();
        a.setId(dto.getId());
        a.setTitle(dto.getTitle());
        a.setDescription(dto.getDescription());
        a.setIcon(dto.getIcon());
        a.setConditionType(dto.getConditionType());
        a.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : Boolean.TRUE);
        return a;
    }
}