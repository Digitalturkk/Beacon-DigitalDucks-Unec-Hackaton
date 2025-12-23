// src/main/java/com/beacon/Achievements/Services/AchievementServiceImpl.java
package com.beacon.Achievements.Services;

import com.beacon.Achievements.Achievement;
import com.beacon.Achievements.AchievementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    public AchievementServiceImpl(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Override
    public Achievement create(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public Achievement update(Long id, Achievement achievement) {
        Achievement existing = achievementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Achievement not found: " + id));

        // Copy fields from incoming entity to the managed entity.
        // Adjust these setters to match your Achievement entity fields.
        existing.setTitle(achievement.getTitle());
        existing.setDescription(achievement.getDescription());
        existing.setIsActive(achievement.getIsActive());

        return achievementRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Achievement> getById(Long id) {
        return achievementRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Achievement> getAll() {
        return achievementRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        achievementRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return achievementRepository.existsById(id);
    }
}