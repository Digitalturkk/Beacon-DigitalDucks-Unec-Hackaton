package com.beacon.Assigments.Services;

import com.beacon.Assigments.Assigment;

import java.util.List;
import java.util.Optional;

public interface AssigmentService {

    Assigment create(Assigment assigment);

    Assigment update(Long id, Assigment assigment);

    Optional<Assigment> getById(Long id);

    List<Assigment> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    List<Assigment> getByModuleId(Long moduleId);

    List<Assigment> getByMentorId(Long mentorId);

    List<Assigment> getByModuleIdAndMentorId(Long moduleId, Long mentorId);
}