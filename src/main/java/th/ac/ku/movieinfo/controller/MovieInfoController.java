package th.ac.ku.movieinfo.controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.movieinfo.model.MovieInfoEntity;
import th.ac.ku.movieinfo.model.MovieInfoResponse;
import th.ac.ku.movieinfo.repository.MovieInfoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/movie-info")
public class MovieInfoController {

    private final MovieInfoRepository MovieInfoRepository;

    public MovieInfoController(MovieInfoRepository MovieInfoRepository) {
        this.MovieInfoRepository = MovieInfoRepository;
    }

    @GetMapping
    public List<MovieInfoEntity> findAll() {
        return this.MovieInfoRepository.findAll();
    }

    @GetMapping("/{id}")
    public MovieInfoEntity findById(@PathVariable int id) {
        return this.MovieInfoRepository.findById(id);
    }

    @PostMapping("/insert")
    public MovieInfoResponse insert(@RequestBody MovieInfoEntity MovieInfoEntity) {
        MovieInfoResponse MovieInfoResponse = new MovieInfoResponse();
        try {
            MovieInfoEntity MovieInfo = this.MovieInfoRepository.save(MovieInfoEntity);
            MovieInfoResponse.setMessage("Insert success");
            MovieInfoResponse.setMovieInfo(MovieInfo);
        } catch (Exception exception) {
            MovieInfoResponse.setMessage("Can not insert");
        }
        return MovieInfoResponse;
    }

}
