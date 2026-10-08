package hirehub.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ApplicantProfile")
public class ApplicantProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long profileId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private User user;

    @Column(length = 500)
    private String address;

    private Double cgpa;

    @Column(length = 255)
    private String fieldOfStudy;

    @Column(length = 255)
    private String institution;

    private Integer graduationYear;

    private Integer yearsOfExperience;

    private Integer age;

}
