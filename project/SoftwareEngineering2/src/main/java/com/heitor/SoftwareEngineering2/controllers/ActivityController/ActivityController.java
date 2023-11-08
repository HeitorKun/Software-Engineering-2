package com.heitor.SofwareEngineering2.controllers;

import com.heitor.SoftwareEngineering2.services.ActivityService.ActivityService;
import com.heitor.SoftwareEngineering2.domain.Activity.Activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    
    @PostMapping
    public ResponseEntity<Activity> createActivity(@Valid @RequestBody Activity activity) {
        Activity newActivity = activityService.createActivity(activity);
        return ResponseEntity.ok(newActivity);
    }

    
    @PutMapping("/{activityId}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long activityId, @Valid @RequestBody Activity activityDetails) {
        Activity updatedActivity = activityService.updateActivity(activityId, activityDetails);
        if (updatedActivity != null) {
            return ResponseEntity.ok(updatedActivity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{activityId}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long activityId) {
        if (activityService.deleteActivityWithTasks(activityId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
