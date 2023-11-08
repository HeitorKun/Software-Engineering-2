package com.heitor.tasksMicroservice.domain.Task;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks_table")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(name = "detailed_description", columnDefinition = "TEXT")
    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "estimated_hours")
    private Integer estimatedHours;

    @Column(name = "actual_hours")
    private Integer actualHours;

    @Column(name = "activity_id")
    private Integer activityId;

    // Assuming you have a separate enum for priority
    public enum Priority {
        LOW, NORMAL, HIGH
    }
    
    // JPA requires that an EnumType be specified when using enumerated types.
    // The Priority enum is defined within the Task class for simplicity.
}
