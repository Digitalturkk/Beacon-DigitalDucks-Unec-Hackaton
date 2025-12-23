package com.beacon.Achievements.UserAchievement.Services;

import com.beacon.Achievements.UserAchievement.UserAchievement;

import java.util.List;
import java.util.Optional;

public interface UserAchievementService {

    UserAchievement create(UserAchievement userAchievement);

    UserAchievement update(Long id, UserAchievement userAchievement);

    Optional<UserAchievement> getById(Long id);

    List<UserAchievement> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    List<UserAchievement> getByUserId(Long userId);

    List<UserAchievement> getByAchievementId(Long achievementId);

    Optional<UserAchievement> getByUserIdAndAchievementId(Long userId, Long achievementId);

    boolean existsByUserIdAndAchievementId(Long userId, Long achievementId);
}