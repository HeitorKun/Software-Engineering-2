package com.heitor.SoftwareEngineering2.services.ActivityService;

import com.heitor.SoftwareEngineering2.domain.Activity.Activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {

    private final RestTemplate restTemplate;
    private final String activitiesServiceUrl;

    @Autowired
    public ActivityService(@Value("${activities.microservice.url}") String activitiesServiceUrl) {
        this.restTemplate = new RestTemplate();
        this.activitiesServiceUrl = activitiesServiceUrl;
    }

    public ActivityService(RestTemplate restTemplate, @Value("${activities.microservice.url}") String activitiesServiceUrl) {
        this.restTemplate = restTemplate;
        this.activitiesServiceUrl = activitiesServiceUrl;
    }

    public Activity createActivity(Activity activity) {
        return restTemplate.postForObject(activitiesServiceUrl + "/activities", activity, Activity.class);
    }

    public Activity getActivityById(Long activityId) {
        return restTemplate.getForObject(activitiesServiceUrl + "/activities/" + activityId, Activity.class);
    }

    public Activity updateActivity(Long activityId, Activity activity) {
        restTemplate.put(activitiesServiceUrl + "/activities/" + activityId, activity);
        return getActivityById(activityId);
    }

    public void deleteActivity(Long activityId) {
        restTemplate.delete(activitiesServiceUrl + "/activities/" + activityId);
    }
}
