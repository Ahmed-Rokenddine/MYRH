package yc.ahmed.myrh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yc.ahmed.myrh.Entities.Offres;

@Repository
public interface OffresRepository extends JpaRepository<Offres,Long> {

}
