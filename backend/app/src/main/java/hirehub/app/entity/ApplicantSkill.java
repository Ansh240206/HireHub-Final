package hirehub.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ApplicantSkill",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"profileId", "skillId"}
        ))
public class ApplicantSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId", nullable = false)
    private ApplicantProfile applicantProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skillId", nullable = false)
    private Skill skill;
}
