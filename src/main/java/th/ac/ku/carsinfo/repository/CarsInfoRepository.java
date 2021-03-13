package th.ac.ku.carsinfo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.carsinfo.model.CarsInfoEntity;

@Repository
public interface CarsInfoRepository extends JpaRepository<CarsInfoEntity, Integer> {
    CarsInfoEntity findById(int id);
}
