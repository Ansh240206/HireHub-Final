package hirehub.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long resumeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicantProfileId", nullable = false)
    private ApplicantProfile applicantProfile;

    @Column(nullable = false, length = 255)
    private String fileName;

    @Column(nullable = false, length = 500)
    private String fileUrl;

    @Column(nullable = false, updatable = false)
    private LocalDateTime uploadedAt;

    private Boolean isCurrent;

    @PrePersist
    protected void onCreate() {
        uploadedAt = LocalDateTime.now();
    }
}
