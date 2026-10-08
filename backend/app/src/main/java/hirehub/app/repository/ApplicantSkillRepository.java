package hirehub.app.repository;

import hirehub.app.entity.ApplicantSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantSkillRepository extends JpaRepository<ApplicantSkill, Long> {
}
