package com.beacon.Notifications.Services;

import com.beacon.Notifications.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    Notification create(Notification notification);

    Notification update(Long id, Notification notification);

    Optional<Notification> getById(Long id);

    List<Notification> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    List<Notification> getByUserId(Long userId);
}