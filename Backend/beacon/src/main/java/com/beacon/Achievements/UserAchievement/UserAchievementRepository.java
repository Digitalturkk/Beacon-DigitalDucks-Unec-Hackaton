package com.beacon.Achievements.UserAchievement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {

    List<UserAchievement> findByUser_Id(Long userId);

    List<UserAchievement> findByAchievement_Id(Long achievementId);

    Optional<UserAchievement> findByUser_IdAndAchievement_Id(Long userId, Long achievementId);

    boolean existsByUser_IdAndAchievement_Id(Long userId, Long achievementId);
}