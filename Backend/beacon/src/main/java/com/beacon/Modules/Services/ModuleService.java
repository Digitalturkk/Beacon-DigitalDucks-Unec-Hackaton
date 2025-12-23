package com.beacon.Modules.Services;

import com.beacon.Modules.Module;

import java.util.List;
import java.util.Optional;

public interface ModuleService {

    Module create(Module module);

    Module update(Long id, Module module);

    Optional<Module> getById(Long id);

    List<Module> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    List<Module> getByCourseId(Long courseId);

    boolean existsByCourseIdAndOrderNumber(Long courseId, Integer orderNumber);
}