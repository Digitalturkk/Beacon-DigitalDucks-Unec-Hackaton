// src/main/java/com/beacon/Progresses/ProgressRepository.java
package com.beacon.Progresses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findByUser_Id(Long userId);

    List<Progress> findByCourse_Id(Long courseId);

    List<Progress> findByModule_Id(Long moduleId);

    Optional<Progress> findByUser_IdAndModule_Id(Long userId, Long moduleId);

    boolean existsByUser_IdAndModule_Id(Long userId, Long moduleId);
}