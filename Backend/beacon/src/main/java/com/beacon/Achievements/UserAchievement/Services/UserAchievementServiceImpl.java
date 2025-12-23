package com.beacon.Achievements.UserAchievement.Services;

import com.beacon.Achievements.UserAchievement.UserAchievement;
import com.beacon.Achievements.UserAchievement.UserAchievementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserAchievementServiceImpl implements UserAchievementService {

    private final UserAchievementRepository userAchievementRepository;

    public UserAchievementServiceImpl(UserAchievementRepository userAchievementRepository) {
        this.userAchievementRepository = userAchievementRepository;
    }

    @Override
    public UserAchievement create(UserAchievement userAchievement) {
        return userAchievementRepository.save(userAchievement);
    }

    @Override
    public UserAchievement update(Long id, UserAchievement userAchievement) {
        UserAchievement existing = userAchievementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UserAchievement not found: " + id));

        // Copy entity fields (adjust setters to match your UserAchievement entity).
        existing.setUser(userAchievement.getUser());
        existing.setAchievement(userAchievement.getAchievement());

        return userAchievementRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserAchievement> getById(Long id) {
        return userAchievementRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAchievement> getAll() {
        return userAchievementRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userAchievementRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return userAchievementRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAchievement> getByUserId(Long userId) {
        return userAchievementRepository.findByUser_Id(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAchievement> getByAchievementId(Long achievementId) {
        return userAchievementRepository.findByAchievement_Id(achievementId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserAchievement> getByUserIdAndAchievementId(Long userId, Long achievementId) {
        return userAchievementRepository.findByUser_IdAndAchievement_Id(userId, achievementId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUserIdAndAchievementId(Long userId, Long achievementId) {
        return userAchievementRepository.existsByUser_IdAndAchievement_Id(userId, achievementId);
    }
}