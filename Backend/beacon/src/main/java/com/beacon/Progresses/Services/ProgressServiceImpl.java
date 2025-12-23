package com.beacon.Progresses.Services;

        import com.beacon.Progresses.Progress;
        import com.beacon.Progresses.ProgressRepository;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;
        import java.util.Optional;

        @Service
        @Transactional
        public class ProgressServiceImpl implements ProgressService {

            private final ProgressRepository progressRepository;

            public ProgressServiceImpl(ProgressRepository progressRepository) {
                this.progressRepository = progressRepository;
            }

            @Override
            public Progress create(Progress progress) {
                return progressRepository.save(progress);
            }

            @Override
            public Progress update(Long id, Progress progress) {
                Progress existing = progressRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Progress not found: " + id));

                existing.setUser(progress.getUser());
                existing.setCourse(progress.getCourse());
                existing.setModule(progress.getModule());
                existing.setStatus(progress.getStatus());

                return progressRepository.save(existing);
            }

            @Override
            @Transactional(readOnly = true)
            public Optional<Progress> getById(Long id) {
                return progressRepository.findById(id);
            }

            @Override
            @Transactional(readOnly = true)
            public List<Progress> getAll() {
                return progressRepository.findAll();
            }

            @Override
            public void deleteById(Long id) {
                progressRepository.deleteById(id);
            }

            @Override
            @Transactional(readOnly = true)
            public boolean existsById(Long id) {
                return progressRepository.existsById(id);
            }

            @Override
            @Transactional(readOnly = true)
            public List<Progress> getByUserId(Long userId) {
                return progressRepository.findByUser_Id(userId);
            }

            @Override
            @Transactional(readOnly = true)
            public List<Progress> getByCourseId(Long courseId) {
                return progressRepository.findByCourse_Id(courseId);
            }

            @Override
            @Transactional(readOnly = true)
            public List<Progress> getByModuleId(Long moduleId) {
                return progressRepository.findByModule_Id(moduleId);
            }

            @Override
            @Transactional(readOnly = true)
            public Optional<Progress> getByUserIdAndModuleId(Long userId, Long moduleId) {
                return progressRepository.findByUser_IdAndModule_Id(userId, moduleId);
            }

            @Override
            @Transactional(readOnly = true)
            public boolean existsByUserIdAndModuleId(Long userId, Long moduleId) {
                return progressRepository.existsByUser_IdAndModule_Id(userId, moduleId);
            }
        }