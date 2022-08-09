package com.zee.zee5app.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;

public class MovieRepoImpl implements MovieRepository {
	private List<Movie> movies = new ArrayList<>();
	private MovieRepoImpl() {
        // TODO Auto-generated constructor stub
    }
    
    private static MovieRepository movieRepo;
    
    public static MovieRepository getInstance() {
        
        
        if(movieRepo == null) {
            movieRepo = new MovieRepoImpl();
            
        }
        
        return movieRepo;
    }
    Comparator<Movie> comparator = (e1,e2)->e1.getMovieName().compareTo(e2.getMovieName());
	@Override
	public Movie insertMovie(Movie movie) {
		boolean result =  movies.add(movie);
		
		if(result) {
			System.out.println("done");
			return movie;
		}
		else return null;
	}
	public List<Movie> findByOrderByMovieNameDsc(){
		Collections.sort(movies,comparator);
		return movies;
	}
	@Override
	public Movie updateMovie(String movieId, Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
