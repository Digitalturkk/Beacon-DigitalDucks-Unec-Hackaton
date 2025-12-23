// src/main/java/com/beacon/Progresses/Services/ProgressService.java
package com.beacon.Progresses.Services;

import com.beacon.Progresses.Progress;

import java.util.List;
import java.util.Optional;

public interface ProgressService {

    Progress create(Progress progress);

    Progress update(Long id, Progress progress);

    Optional<Progress> getById(Long id);

    List<Progress> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    List<Progress> getByUserId(Long userId);

    List<Progress> getByCourseId(Long courseId);

    List<Progress> getByModuleId(Long moduleId);

    Optional<Progress> getByUserIdAndModuleId(Long userId, Long moduleId);

    boolean existsByUserIdAndModuleId(Long userId, Long moduleId);
}