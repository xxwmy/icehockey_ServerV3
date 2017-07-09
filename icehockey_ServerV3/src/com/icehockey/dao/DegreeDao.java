package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.Degree;
import com.icehockey.util.DBUtil;

public class DegreeDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	Degree degree = null;

	public Degree getDegreeByUserId(String roleName, int userId) {
		String sql = null;
		if ("coach".equals(roleName)) {
			sql = "SELECT * FROM USER, coach, degree WHERE USER .userId = coach.userId AND coach.degreeId = degree.degreeId AND USER .userId = ?";

		} else if ("judge".equals(roleName)) {
			sql = "SELECT * FROM USER, judge, degree WHERE USER .userId = judge.userId AND judge.degreeId = degree.degreeId AND USER .userId = ?";

		}

		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			if (rs.next()) {

				// int userId=rs.getInt("userId");
				String userName = rs.getString("userName");
				int degreeId = rs.getInt("degreeId");
				String degreeName = rs.getString("degreeName");
				degree = new Degree(userId, userName, degreeId, degreeName);
				return degree;
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
		return degree;
	}

	public Degree getDegreeByUserId2(String roleName, int userId) {
		if ("coach".equals(roleName)) {
			String sql = "SELECT * FROM USER, coach, degree WHERE USER .userId = coach.userId AND coach.degreeId = degree.degreeId AND USER .userId = ?";
			try {
				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, userId);
				rs = preparedStatement.executeQuery();
				if (rs.next()) {

					// int userId=rs.getInt("userId");
					String userName = rs.getString("userName");
					int degreeeId = rs.getInt("degreeeId");
					String degreeName = rs.getString("degreeName");
					degree = new Degree(userId, userName, degreeeId, degreeName);
					return degree;
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
		} else if ("judge".equals(roleName)) {
			String sql = "SELECT * FROM USER, judge, degree WHERE USER .userId = judge.userId AND judge.degreeId = degree.degreeId AND USER .userId = ?";
			try {
				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, userId);
				rs = preparedStatement.executeQuery();
				System.out.println("等级sql："+sql);
				if (rs.next()) {

					// int userId=rs.getInt("userId");
					String userName = rs.getString("userName");
					int degreeId = rs.getInt("degreeId");
					String degreeName = rs.getString("degreeName");
					degree = new Degree(userId, userName, degreeId, degreeName);
					System.out.println(degree);
					return degree;
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
		}
		return degree;
	}
}
