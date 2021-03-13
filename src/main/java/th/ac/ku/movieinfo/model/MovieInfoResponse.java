package th.ac.ku.movieinfo.model;

public class MovieInfoResponse {

    private MovieInfoEntity MovieInfo;

    private String message;

    public MovieInfoEntity getMovieInfo() {
        return MovieInfo;
    }

    public void setMovieInfo(MovieInfoEntity MovieInfo) {
        this.MovieInfo = MovieInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
