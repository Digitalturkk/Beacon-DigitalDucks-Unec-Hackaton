// src/main/java/com/beacon/Achievements/AchievementRepository.java
package com.beacon.Achievements;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}