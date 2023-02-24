package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.add_movie(movie);
    }

    public void addDirector(Director director){
        movieRepository.add_director(director);
    }

    public void createMovieDirectorPair(String movie, String director){
        movieRepository.add_pair( director,  movie);
    }

    public Movie findMovie(String movieName){
        return movieRepository.get_movie(movieName);
    }

    public Director findDirector(String directorName){
        return movieRepository.get_director(directorName);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepository.get_all_movie_director(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.get_all_movie();
    }

    public void deleteDirector(String director){
        movieRepository.delete_director_by_name(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }

}