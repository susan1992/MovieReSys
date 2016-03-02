package com.movie.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.s3.model.Bucket;
import com.movie.dao.movieDAO;
import com.movie.domain.Movie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UpLoadMovie extends ActionSupport {

	private String movieName;
	private String moviePublishedYear;
	private String movieType;
	private String movieDetails;
	private String imagesSum;
	private String moviesSum;
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;


	public String getImagesSum() {
		return imagesSum;
	}


	public void setImagesSum(String imagesSum) {
		this.imagesSum = imagesSum;
	}


	public String getMoviesSum() {
		return moviesSum;
	}


	public void setMoviesSum(String moviesSum) {
		this.moviesSum = moviesSum;
	}


	public List<File> getUpload() {
		return upload;
	}


	public void setUpload(List<File> upload) {
		this.upload = upload;
	}


	public List<String> getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public List<String> getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getMoviePublishedYear() {
		return moviePublishedYear;
	}


	public void setMoviePublishedYear(String moviePublishedYear) {
		this.moviePublishedYear = moviePublishedYear;
	}


	public String getMovieType() {
		return movieType;
	}


	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}


	public String getMovieDetails() {
		return movieDetails;
	}


	public void setMovieDetails(String movieDetails) {
		this.movieDetails = movieDetails;
	}

	/**
	 * @return
	 */
	public String execute() {
		if(upload!=null){
			int i=1;
			int allSum = Integer.valueOf(upload.size());
			int imageSum = Integer.valueOf(imagesSum);
			int movieSum = Integer.valueOf(moviesSum);
			System.out.println("图片个数： "+imageSum);
			System.out.println("电影个数： "+movieSum);
			System.out.println("总的个数： "+allSum);

			
			//将电影的摘要信息插入数据库movie中
			//元数据信息插入数据库	

				Movie movie = new Movie();
				movie.setName(movieName);
				movie.setPublished_year(moviePublishedYear);
				movie.setType(movieType);
				movie.setDetails(movieDetails);
				//movie.setMiniImageUrl("WebRoot/localImages/"+imageName);

			if(movie!=null)
			{
				Map session=ActionContext.getContext().getSession();
				if(session.containsKey("movie"))
					session.remove("movie");
				session.put("movie", movie);
			}
			return SUCCESS;
		}
		else{
			return ERROR;
		}

	}
}