package com.movie.dao;

import com.movie.dao.UserDaoImpl;
import com.movie.dao.uDAO;

public class DAOFactory {
	public static uDAO getUserDAOInstance(){
		return new UserDaoImpl();
		}
	}