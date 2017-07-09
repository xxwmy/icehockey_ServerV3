package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.ClubRecordDao;
import com.icehockey.entity.ClubRecord;

public class ClubRecordService {
	List<ClubRecord> clubRecords=null;
	ClubRecordDao clubRecordDao=new ClubRecordDao();
	
	public List<ClubRecord> queryClubRecordByUserId(String roleName, int userId) {
		clubRecords=clubRecordDao.getClubRecordByUserId(roleName,userId);
		if(clubRecords!=null){
			for(ClubRecord clubRecord:clubRecords){
				System.out.println(clubRecord);
			}
			return clubRecords;
		}
		return null;
	}

}
