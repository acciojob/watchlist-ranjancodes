package com.driver;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
@Repository
public class MovieRepository {
    HashMap<String,Movie> movie_map ;
    HashMap<String,Director> director_map;
    HashMap<String, ArrayList<String>> map;

    public MovieRepository(){
        movie_map = new HashMap<>();
        director_map = new HashMap<>();
        map = new HashMap<>();
    }

    public MovieRepository(HashMap<String, Movie> moviemap, HashMap<String, Director> directormap, HashMap<String, ArrayList<String>> map) {
        this.movie_map = moviemap;
        this.director_map = directormap;
        this.map = map;
    }
    public void add_movie(Movie movie){
        String name  = movie.getName();
        movie_map.put(name,movie);
    }
    public  void add_director(Director director){
        String name = director.getName();
        director_map.put(name,director);
    }
    public void add_pair(String director, String movie ){
        if(this.map.containsKey(director)){
            ArrayList<String> temp = map.get(director);
            temp.add(movie);
        }
        else{
            ArrayList<String> temp = new ArrayList<>();
            temp.add(movie);
            map.put(director,temp);
        }
    }
    public Movie get_movie(String name){
        if(movie_map.containsKey(name)){
            return movie_map.get(name);
        }
        else return null;
    }
    public Director get_director(String name){
        if(director_map.containsKey(name)){
            return director_map.get(name);
        }
        else return null;
    }
    public ArrayList get_pair(String director){
        return map.getOrDefault(director, null);
    }
    public List<String> get_all_movie_director(String director){
        if(map.containsKey(director)) return map.get(director);
        return null;
    }
    public ArrayList<String> get_all_movie(){
        ArrayList<String> list = new ArrayList<>();
        for(String movie : movie_map.keySet()){
            list.add(movie);
        }
        return list;
    }
    public void delete_director_by_name(String name){
        if(map.containsKey(name)){
            ArrayList<String> mov = map.get(name);
            for(String s : mov){
                if(movie_map.containsKey(s)) movie_map.remove(s);
            }
            map.remove(name);
        }
        if(director_map.containsKey(name)) map.remove(name);

    }
    public void deleteAllDirector() {

        HashSet<String> moviesSet = new HashSet<String>();



        for (String director : map.keySet()) {
            for (String movie : map.get(director)) {
                moviesSet.add(movie);
            }
        }

        for (String movie : moviesSet) {
            if (movie_map.containsKey(movie)) {
                movie_map.remove(movie);
            }
        }
        director_map = new HashMap<>();
    }
}