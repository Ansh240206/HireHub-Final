package hirehub.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Application", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"applicantProfileId", "jobId"})
})
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicantProfileId", nullable = false)
    private ApplicantProfile applicantProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resumeId", nullable = false)
    private Resume resume;

    @Column(nullable = false, updatable = false)
    private LocalDateTime appliedAt;

    private LocalDateTime withdrawnAt;

    @Column(nullable = false, length = 50)
    private String status;

    @PrePersist
    protected void onCreate() {
        appliedAt = LocalDateTime.now();
    }
}
