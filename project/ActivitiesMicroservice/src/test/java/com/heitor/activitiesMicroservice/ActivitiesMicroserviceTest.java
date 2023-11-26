package test.java.com.heitor.activitiesMicroservice;

import com.heitor.activitiesMicroservice.domain.Activity.Activity;
import com.heitor.activitiesMicroservice.domain.Activity.ActivityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActivitiesMicroserviceTest {

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private ActivityService activityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllActivities() {
        List<Activity> activities = Arrays.asList(
                new Activity(1L, "Activity 1", true),
                new Activity(2L, "Activity 2", false)
        );

        when(activityRepository.findAll()).thenReturn(activities);

        List<Activity> result = activityService.getAllActivities();

        assertEquals(2, result.size());
        assertEquals("Activity 1", result.get(0).getTitle());
        assertEquals("Activity 2", result.get(1).getTitle());

        verify(activityRepository, times(1)).findAll();
    }

    @Test
    void getActivityById() {
        Activity activity = new Activity(1L, "Activity 1", true);

        when(activityRepository.findById(1L)).thenReturn(Optional.of(activity));

        Optional<Activity> result = activityService.getActivityById(1L);

        assertTrue(result.isPresent());
        assertEquals("Activity 1", result.get().getTitle());

        verify(activityRepository, times(1)).findById(1L);
    }
}
