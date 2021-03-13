package th.ac.ku.movieinfo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.movieinfo.model.MovieInfoEntity;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfoEntity, Integer> {
    MovieInfoEntity findById(int id);
}
