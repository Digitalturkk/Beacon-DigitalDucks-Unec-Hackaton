package com.beacon.Assigments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssigmentRepository extends JpaRepository<Assigment, Long> {

    List<Assigment> findByModule_Id(Long moduleId);

    List<Assigment> findByMentor_Id(Long mentorId);

    List<Assigment> findByModule_IdAndMentor_Id(Long moduleId, Long mentorId);
}