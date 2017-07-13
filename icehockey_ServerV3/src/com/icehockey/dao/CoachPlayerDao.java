package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.CoachPlayer;
import com.icehockey.util.DBUtil;

public class CoachPlayerDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	List<CoachPlayer> coachPlayers = null;
	CoachPlayer coachPlayer = null;

	/**
	 * SELECT user1.userId coachId,user1.userName coachName,user2.userId,user2.userName
	   FROM user user1 ,user user2 ,coachplayer
	   WHERE user1.userId =coachplayer.coachUserId AND user2.userId=coachplayer.playerUserId
	 * 
	 * */
	public List<CoachPlayer> getCoachPlayerRecordByCoachId(String roleName,int userId) {
		String sql=null;
		if("coach".equals(roleName)){
			sql = "SELECT * FROM USER, coachplayer WHERE USER .userId = coachplayer.coachUserId AND user.userId=?";
		
		}else if("judge".equals(roleName)){
			
		}else{
			sql="SELECT * FROM USER, coachplayer WHERE USER .userId = coachplayer.playerUserId AND USER .userId = ?";
		}
		coachPlayers = new ArrayList<CoachPlayer>();
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			while (rs.next()) {

				int CPRecord = rs.getInt("CPRecord");
				int coachUserId = rs.getInt("coachUserId");
				String coachName = rs.getString("userName");
				int playerUserId = rs.getInt("playerUserId");
				String playerName = rs.getString("playerName");
				double bestScore = rs.getDouble("bestScore");
				coachPlayer = new CoachPlayer(CPRecord, coachUserId, coachName,
						playerUserId, playerName, bestScore);
				coachPlayers.add(coachPlayer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return coachPlayers;
	}
	// SELECT * FROM USER, coachplayer WHERE USER .userId =
	// coachplayer.coachUserId AND user.userId=100009
}
