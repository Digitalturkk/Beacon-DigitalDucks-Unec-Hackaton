package com.beacon.Notifications.Services;

import com.beacon.Notifications.Notification;
import com.beacon.Notifications.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification update(Long id, Notification notification) {
        Notification existing = notificationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found: " + id));

        existing.setUser(notification.getUser());
        existing.setMessage(notification.getMessage());

        return notificationRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Notification> getById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return notificationRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notification> getByUserId(Long userId) {
        return notificationRepository.findByUser_Id(userId);
    }
}