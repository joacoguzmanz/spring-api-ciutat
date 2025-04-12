package guzman.joaquin.ciutat.model.repository;

import guzman.joaquin.ciutat.model.domain.Ciutat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiutatRepository extends JpaRepository<Ciutat, Integer> {
}
