package com.icehockey.service;

import com.icehockey.dao.DegreeDao;
import com.icehockey.entity.Degree;

public class DegreeService {

	Degree degree=null;
	DegreeDao degreeDao=new DegreeDao();
	public Degree queryDegreeNameByUserId(String roleName, int userId) {
		System.out.println("bbbbbbbbbbb");
		degree=degreeDao.getDegreeByUserId(roleName,userId);
		if(degree!=null){
			System.out.println("ccccccccccccccccccc");
			System.out.println("degreeService"+degree);
			return degree;
		}else{
			System.out.println("dddddddddddddddddd");
			return null;
		}
		
	}

}
