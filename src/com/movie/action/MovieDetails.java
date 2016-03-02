package com.movie.action;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.s3.model.Bucket;
import com.movie.dao.movieDAO;
import com.movie.dao.movieImageDAO;
import com.movie.domain.Movie;
import com.movie.domain.MovieImage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MovieDetails extends ActionSupport {
	private String movieID="1";
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	/**
	 * @return
	 */
	public String execute() {
		//将电影id放入session中
		Map session=ActionContext.getContext().getSession();
		if(session.containsKey("movieID"))
			session.remove("movieID");
		session.put("movieID", movieID);
		// TODO Auto-generated method stub
		Movie movie = movieDAO.getMovieDetailsByMovieID(movieID);
		//System.out.println("movieID:  "+movieID);
	
		if(movie!=null){
			Map request = (Map)ActionContext.getContext().get("request");
			request.put("movieDetails", movie);
			return SUCCESS;
		}
		return ERROR;
	}
}