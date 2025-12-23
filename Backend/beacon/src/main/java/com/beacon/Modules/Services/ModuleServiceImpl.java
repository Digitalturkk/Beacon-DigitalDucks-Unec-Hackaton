package com.beacon.Modules.Services;

import com.beacon.Modules.Module;
import com.beacon.Modules.ModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module create(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public Module update(Long id, Module module) {
        Module existing = moduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Module not found: " + id));

        existing.setTitle(module.getTitle());
        existing.setContent(module.getContent());
        existing.setCourse(module.getCourse());
        existing.setOrderNumber(module.getOrderNumber());
        existing.setEstimatedTime(module.getEstimatedTime());

        existing.setAssigments(module.getAssigments());
        existing.setProgresses(module.getProgresses());

        return moduleRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Module> getById(Long id) {
        return moduleRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Module> getAll() {
        return moduleRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        moduleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return moduleRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Module> getByCourseId(Long courseId) {
        return moduleRepository.findByCourse_Id(courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByCourseIdAndOrderNumber(Long courseId, Integer orderNumber) {
        return moduleRepository.existsByCourse_IdAndOrderNumber(courseId, orderNumber);
    }
}