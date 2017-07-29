package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.CompetitionRecordDao;
import com.icehockey.entity.CompetitionRecord;

public class CompetitionRecordService {

	CompetitionRecordDao dao=new CompetitionRecordDao();
	CompetitionRecord competitionRecord=null;
	private List<CompetitionRecord> competitionRecords=null;
	
	public List<CompetitionRecord> queryPlayerByUserId(int userId) {
		competitionRecords = dao.getCompetitionRecordByUserId(userId);
		if(competitionRecord!=null){
			System.out.println("找到该球员赛事记录......"+competitionRecord);
		}
		return competitionRecords;
	}
}
