package th.ac.ku.movieinfo.model;

public class MovieInfoResponse {

    private MovieInfoEntity movieInfo;

    private String message;

    public MovieInfoEntity getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfoEntity movieInfo) {
        this.movieInfo = movieInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
