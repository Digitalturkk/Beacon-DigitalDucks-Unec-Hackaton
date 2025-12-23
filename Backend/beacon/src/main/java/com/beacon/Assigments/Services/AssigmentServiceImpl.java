package com.beacon.Assigments.Services;

import com.beacon.Assigments.Assigment;
import com.beacon.Assigments.AssigmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssigmentServiceImpl implements AssigmentService {

    private final AssigmentRepository assigmentRepository;

    public AssigmentServiceImpl(AssigmentRepository assigmentRepository) {
        this.assigmentRepository = assigmentRepository;
    }

    @Override
    public Assigment create(Assigment assigment) {
        return assigmentRepository.save(assigment);
    }

    @Override
    public Assigment update(Long id, Assigment assigment) {
        Assigment existing = assigmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assigment not found: " + id));

        existing.setTitle(assigment.getTitle());
        existing.setDescription(assigment.getDescription());
        existing.setModule(assigment.getModule());
        existing.setMentor(assigment.getMentor());
        existing.setDeadline(assigment.getDeadline());
        existing.setSubmissions(assigment.getSubmissions());

        return assigmentRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Assigment> getById(Long id) {
        return assigmentRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assigment> getAll() {
        return assigmentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        assigmentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return assigmentRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assigment> getByModuleId(Long moduleId) {
        return assigmentRepository.findByModule_Id(moduleId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assigment> getByMentorId(Long mentorId) {
        return assigmentRepository.findByMentor_Id(mentorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Assigment> getByModuleIdAndMentorId(Long moduleId, Long mentorId) {
        return assigmentRepository.findByModule_IdAndMentor_Id(moduleId, mentorId);
    }
}