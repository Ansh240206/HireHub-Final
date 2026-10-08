package hirehub.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Skill")
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long skillId;

    @Column(nullable = false, unique = true, length = 100)
    private String name;
}
