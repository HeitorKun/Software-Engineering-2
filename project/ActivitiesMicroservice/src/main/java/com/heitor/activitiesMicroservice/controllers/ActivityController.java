package com.heitor.softwareEngineering.controllers;

import com.heitor.softwareEngineering.domain.Activity.Activity;
import com.heitor.softwareEngineering.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long activityId) {
        return activityService.getActivityById(activityId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity newActivity = activityService.createActivity(activity);
        return ResponseEntity.ok(newActivity);
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long activityId, @RequestBody Activity activity) {
        Activity updatedActivity = activityService.updateActivity(activityId, activity);
        if (updatedActivity != null) {
            return ResponseEntity.ok(updatedActivity);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {
        activityService.deleteActivity(activityId);
        return ResponseEntity.ok().build();
    }
}
