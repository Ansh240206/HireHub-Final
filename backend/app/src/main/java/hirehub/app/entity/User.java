package hirehub.app.entity;

import hirehub.app.enums.RoleName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    @Column(nullable = false, unique = true, updatable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private RoleName role;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, updatable = false, length = 13)
    private String phone;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private ApplicantProfile applicantProfile;

    public void setApplicantProfile(ApplicantProfile profile){
        this.applicantProfile = profile;

        if(profile!=null) applicantProfile.setUser(this);

    }
}
