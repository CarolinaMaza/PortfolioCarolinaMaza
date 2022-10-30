
package com.portfolio.CMaza.Repository;

import com.portfolio.CMaza.Entity.HardSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHardSkillRepository extends JpaRepository<HardSkill, Integer> {

    Optional<HardSkill> findByNombreHd(String nombreHd);

    public boolean existsByNombreHd(String nombreHd);
}
