// src/main/java/com/beacon/Achievements/Services/AchievementService.java
package com.beacon.Achievements.Services;

import com.beacon.Achievements.Achievement;

import java.util.List;
import java.util.Optional;

public interface AchievementService {

    Achievement create(Achievement achievement);

    Achievement update(Long id, Achievement achievement);

    Optional<Achievement> getById(Long id);

    List<Achievement> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}