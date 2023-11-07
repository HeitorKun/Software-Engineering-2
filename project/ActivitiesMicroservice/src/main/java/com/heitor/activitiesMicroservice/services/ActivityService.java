package com.heitor.softwareEngineering.services;

import com.heitor.softwareEngineering.domain.Activity.Activity;
import com.heitor.softwareEngineering.domain.Activity.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(Long activityId) {
        return activityRepository.findById(activityId);
    }

    public Activity createActivity(Activity activity) {
        // Here you can add additional logic before saving the activity if needed
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long activityId, Activity updatedActivity) {
        return activityRepository.findById(activityId)
            .map(activity -> {
                // Copy properties from updatedActivity to the existing entity
                activity.setTitle(updatedActivity.getTitle());
                activity.setState(updatedActivity.isState());
                activity.setStartDate(updatedActivity.getStartDate());
                activity.setEndDate(updatedActivity.getEndDate());
                activity.setUserId(updatedActivity.getUserId());
                return activityRepository.save(activity);
            })
            .orElseGet(() -> {
                // Handle the case where the activity doesn't exist, e.g., throw an exception
                // Or you can also save the new activity if that's the desired behavior
                return null;
            });
    }

    public void deleteActivity(Long activityId) {
        activityRepository.deleteById(activityId);
    }
}
