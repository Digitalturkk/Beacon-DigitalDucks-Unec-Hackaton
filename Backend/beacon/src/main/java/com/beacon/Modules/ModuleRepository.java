package com.beacon.Modules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    List<Module> findByCourse_Id(Long courseId);

    boolean existsByCourse_IdAndOrderNumber(Long courseId, Integer orderNumber);
}