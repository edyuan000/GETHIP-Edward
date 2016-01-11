package com.gallup.gethip;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class DataSourceManager {
	private static DataSourceManager manager = new DataSourceManager( );
	private static HashMap<String, Dao> daoMap = new HashMap<String, Dao>();
	private static ConnectionSource source;
	
	/* A private Constructor prevents any other 
	* class from instantiating.
	*/
	private DataSourceManager(){ }
	   
	/* Static 'instance' method */
	public static DataSourceManager getInstance( ) {
		return manager;
	}
	
	protected static void addDao(Class daoClass) throws SQLException{
		daoMap.put(daoClass.getName(), DaoManager.createDao(source, daoClass));
	}
	
	public static Dao getDao(Class c){
		return daoMap.get(c.getName());
	}
	
	protected static void setConnectionSource(ConnectionSource s){
		source = s;
	}
}
