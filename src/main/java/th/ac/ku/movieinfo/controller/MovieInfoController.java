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

    @PutMapping("/update/{id}")
    public MovieInfoResponse update(@PathVariable int id,
                                           @RequestBody MovieInfoEntity movieInfoEntity) {
        MovieInfoResponse movieInfoResponse = new MovieInfoResponse();
        try {
            MovieInfoEntity movieInfo = this.movieInfoRepository.findById(id);
            if (null != movieInfo) {
                movieInfo.setName(movieInfoEntity.getName());
                movieInfo.setdesc(movieInfoEntity.getdesc());
                movieInfo.setMovieTheater(movieInfoEntity.getMovieTheater());
                movieInfo.setStartDate(movieInfoEntity.getStartDate());
                movieInfo.setShowTimes(movieInfoEntity.getShowTimes());
                movieInfo = this.movieInfoRepository.save(movieInfo);
                movieInfo.setMovieInformation(movieInfo);
                movieInfo.setMessage("Update Success");
            } else {
                movieInfoResponse.setMessage("Everything all up to date");
            }
        } catch (Exception exception) {
            movieInfoResponse.setMessage("Can not update");
        }
        return movieInfoResponse;
    }

    @DeleteMapping("/delete/{id}")
    public MovieInfoResponse update(@PathVariable int id) {
        MovieInfoResponse movieInfoResponse = new MovieInfoResponse();
        try {
            MovieInfoEntity movieInfo = this.movieInfoRepository.findById(id);
            if (null != movieInfo) {
                this.movieInfoRepository.delete(movieInfo);
                movieInfoResponse.setMessage("Delete Success");
            } else {
                movieInfoResponse.setMessage("No data to delete");
            }
        } catch (Exception exception) {
            movieInfoResponse.setMessage("Can not Delete");
        }
        return movieInfoResponse;
    }

}
