package hirehub.app.entity;

import hirehub.app.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long companyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerUserId", nullable = false, unique = true)
    private User ownerUser;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String website;

    @Column(length = 255)
    private String location;

    @Column(length = 255)
    private String industry;

    private String companySize;
    private VerificationStatus verificationStatus;
    private String logoUrl;
}
