package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.Player;
import com.icehockey.util.DBUtil;

public class PlayerDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private Player player = null;
	private PreparedStatement preparedStatement = null;

	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();

		String sql = "SELECT * FROM player,user WHERE player.userId=user.userId";
		try {
			conn = util.openConnection();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				int playerId = rs.getInt("playerId");// 球员编号
				int firstlearningAge = rs.getInt("firstlearningAge");// 初学年龄,
				int nowLearnClubId = rs.getInt("nowLearnClubId");// '现俱乐部',
				int everLearnCloudId = rs.getInt("everLearnCloudId");// '曾执教俱乐部',
				int nowLearnTeamId = rs.getInt("nowLearnTeamId");// '现执教球队',
				int everLearnTeamId = rs.getInt("everLearnTeamId");// '曾执教球队',

				int userId = rs.getInt("userId");// '登录编号',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				int sex = rs.getInt("sex");// '1代表男生0表示女生,默认为1男生',
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_player = rs.getString("ice_playe");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				int roleId = rs.getInt("roleId");// '角色编号',
				int handingId = rs.getInt("handingId");// '持杆方式',
				String image = rs.getString("image");// '头像',

				player = new Player(playerId, firstlearningAge, nowLearnClubId, everLearnCloudId, nowLearnTeamId,
						everLearnTeamId, userId, weChatId, telephone, userName, sex, password, birthday, country, city,
						height, weight, play, ice_player, snow_play, roleId, handingId, image);

				players.add(player);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return players;
	}

	public Player getPlayersByWechatNumber(String weChatId) {
		// List<Player> players=new ArrayList<Player>();

		String sql = "SELECT * FROM player,user WHERE player.userId=user.userId AND user.weChatId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, weChatId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int playerId = rs.getInt("playerId");// 球员编号
				int firstlearningAge = rs.getInt("firstlearningAge");// 初学年龄,
				int nowLearnClubId = rs.getInt("nowLearnClubId");// '现俱乐部',
				int everLearnCloudId = rs.getInt("everLearnCloudId");// '曾执教俱乐部',
				int nowLearnTeamId = rs.getInt("nowLearnTeamId");// '现执教球队',
				int everLearnTeamId = rs.getInt("everLearnTeamId");// '曾执教球队',

				int userId = rs.getInt("userId");// '登录编号',
				// String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				int sex = rs.getInt("sex");// '1代表男生0表示女生,默认为1男生',
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_player = rs.getString("ice_playe");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				int roleId = rs.getInt("roleId");// '角色编号',
				int handingId = rs.getInt("handingId");// '持杆方式',
				String image = rs.getString("image");// '头像',

				player = new Player(playerId, firstlearningAge, nowLearnClubId, everLearnCloudId, nowLearnTeamId,
						everLearnTeamId, userId, weChatId, telephone, userName, sex, password, birthday, country, city,
						height, weight, play, ice_player, snow_play, roleId, handingId, image);

				return player;
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
		return player;
	}

	public Player getPlayersByTeleponeNumber(String telephoneNumber) {
		// List<Player> players=new ArrayList<Player>();

		String sql = "SELECT * FROM player,user WHERE player.userId=user.userId AND user.telephone='" + telephoneNumber
				+ "'";
		try {
			conn = util.openConnection();
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println(sql);
			if (rs.next()) {
				int playerId = rs.getInt("playerId");// 球员编号
				int firstlearningAge = rs.getInt("firstlearningAge");// 初学年龄,
				int nowLearnClubId = rs.getInt("nowLearnClubId");// '现俱乐部',
				int everLearnCloudId = rs.getInt("everLearnCloudId");// '曾执教俱乐部',
				int nowLearnTeamId = rs.getInt("nowLearnTeamId");// '现执教球队',
				int everLearnTeamId = rs.getInt("everLearnTeamId");// '曾执教球队',

				int userId = rs.getInt("userId");// '登录编号',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				int sex = rs.getInt("sex");// '1代表男生0表示女生,默认为1男生',
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_player = rs.getString("ice_playe");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				int roleId = rs.getInt("roleId");// '角色编号',
				int handingId = rs.getInt("handingId");// '持杆方式',
				String image = rs.getString("image");// '头像',

				player = new Player(playerId, firstlearningAge, nowLearnClubId, everLearnCloudId, nowLearnTeamId,
						everLearnTeamId, userId, weChatId, telephone, userName, sex, password, birthday, country, city,
						height, weight, play, ice_player, snow_play, roleId, handingId, image);

				return player;
			} else {
				return null;
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
		return player;
	}

	public Player getPlayerById(int playerId) {

		String sql = "SELECT * FROM player,user WHERE player.userId=user.userId AND user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, playerId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				// int playerId = rs.getInt("playerId");// 球员编号
				int firstlearningAge = rs.getInt("firstlearningAge");// 初学年龄,
				int nowLearnClubId = rs.getInt("nowLearnClubId");// '现俱乐部',
				int everLearnCloudId = rs.getInt("everLearnCloudId");// '曾执教俱乐部',
				int nowLearnTeamId = rs.getInt("nowLearnTeamId");// '现执教球队',
				int everLearnTeamId = rs.getInt("everLearnTeamId");// '曾执教球队',

				int userId = rs.getInt("userId");// '登录编号',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				int sex = rs.getInt("sex");// '1代表男生0表示女生,默认为1男生',
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_player = rs.getString("ice_playe");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				int roleId = rs.getInt("roleId");// '角色编号',
				int handingId = rs.getInt("handingId");// '持杆方式',
				String image = rs.getString("image");// '头像',

				player = new Player(playerId, firstlearningAge, nowLearnClubId, everLearnCloudId, nowLearnTeamId,
						everLearnTeamId, userId, weChatId, telephone, userName, sex, password, birthday, country, city,
						height, weight, play, ice_player, snow_play, roleId, handingId, image);

				return player;
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
		return player;
	}

	public Player updatePlayer(int playerId, String playRadioValue, String ice_playRadioValue,
			String snow_playRadioValue, String roleRadioValue, String handRadioValue) {

		player = getPlayerById(playerId);

		System.out.println(player);

		String sql = "UPDATE user SET user.play=?, user.ice_play=?,user.snow_play=?, user.role=?,hand=? WHERE user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, playRadioValue);
			preparedStatement.setString(2, ice_playRadioValue);
			preparedStatement.setString(3, snow_playRadioValue);
			preparedStatement.setString(4, roleRadioValue);
			preparedStatement.setString(5, handRadioValue);
			preparedStatement.setInt(6, playerId);
			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				player = getPlayerById(playerId);
				System.out.println(player);
				return player;
			} else
				return null;
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
		return player;
	}

	public Player insertPlayer(String telephoneNumber, String playerName, String playerPassword) {
		// INSERT INTO Persons (LastName, Address) VALUES ('Wilson',
		// 'Champs-Elysees')

		String sql = "INSERT INTO player (telephoneNumber, playerName,playerPassword) VALUES (?,?,?)";
		try {

			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, telephoneNumber);
			preparedStatement.setString(2, playerName);
			preparedStatement.setString(3, playerPassword);
			System.out.println(sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println(sql);
				player = getPlayersByTeleponeNumber(telephoneNumber);
				System.out.println(player);
				return player;
			} else
				System.out.println("插入失败");
			return null;
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

		return null;
	}

	public Player updatePlayerByPlayerId(int playerId, int sex, double height, double weight, String country,
			String city, String xianxiaolijvlebu, String xianxiaoliqiudui) {

		player = getPlayerById(playerId);
		System.out.println(player);

		String sql = "UPDATE player SET sex=?, height=?,weight=?, country=?,city=?,xianxiaolijvlebu=?,xianshuqiudui=? WHERE playerId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, sex);
			preparedStatement.setDouble(2, height);
			preparedStatement.setDouble(3, weight);
			preparedStatement.setString(4, country);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, xianxiaolijvlebu);
			preparedStatement.setString(7, xianxiaoliqiudui);

			preparedStatement.setInt(8, playerId);

			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			System.out.println("sql:" + sql);

			if (i == 1) {
				player = getPlayerById(playerId);
				System.out.println(player);
				return player;
			} else
				return null;
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
		return player;
	}

	public Player updatePlayerByPlayerId(int playerId, String playerName, double height, double weight, String country,
			String city) {
		player = getPlayerById(playerId);
		System.out.println(player);

		String sql = "UPDATE player SET playerName=?, height=?,weight=?, country=?,city=? WHERE playerId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, playerName);
			preparedStatement.setDouble(2, height);
			preparedStatement.setDouble(3, weight);
			preparedStatement.setString(4, country);
			preparedStatement.setString(5, city);

			preparedStatement.setInt(6, playerId);

			System.out.println("sql:" + sql);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				player = getPlayerById(playerId);
				System.out.println(player);
				return player;
			} else
				return null;
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
		return player;
	}

	public Player insertPlayer(int userId) {
		player = getPlayerByUserId(userId);
		if (player == null) {
			String sql = "INSERT INTO player (userId) VALUES (?)";
			try {

				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, userId);

				System.out.println(sql);
				int i = preparedStatement.executeUpdate();
				if (i == 1) {
					System.out.println(sql);
					player = getPlayerByUserId(userId);
					System.out.println(player);
					return player;
				} else
					System.out.println("插入失败");
				return null;
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

			return null;
		} else {
			System.out.println("该用户在球员表中已存在");
			return null;
		}
	}

	private Player getPlayerByUserId(int userId) {
		String sql = "SELECT * FROM player,user WHERE player.userId=user.userId AND user.userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int playerId = rs.getInt("playerId");// 球员编号
				int firstlearningAge = rs.getInt("firstlearningAge");// 初学年龄,
				int nowLearnClubId = rs.getInt("nowLearnClubId");// '现俱乐部',
				int everLearnCloudId = rs.getInt("everLearnCloudId");// '曾执教俱乐部',
				int nowLearnTeamId = rs.getInt("nowLearnTeamId");// '现执教球队',
				int everLearnTeamId = rs.getInt("everLearnTeamId");// '曾执教球队',

				// int userId = rs.getInt("userId");// '登录编号',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String telephone = rs.getString("telephone");// '手机号码',
				String userName = rs.getString("userName");// '用户姓名',
				int sex = rs.getInt("sex");// '1代表男生0表示女生,默认为1男生',
				String password = rs.getString("password");// '密码',
				Date birthday = rs.getDate("birthday");// '出生日期',
				String country = rs.getString("country");// '国籍',
				String city = rs.getString("city");// '城市',
				double height = rs.getDouble("height");// '身高',
				double weight = rs.getDouble("weight");// '体重',
				String play = rs.getString("play");// '爱好：玩雪，玩冰，都玩',
				String ice_player = rs.getString("ice_play");// '游戏项目',
				String snow_play = rs.getString("snow_play");// '单板，双板，都玩',
				int roleId = rs.getInt("roleId");// '角色编号',
				int handingId = rs.getInt("handlingId");// '持杆方式',
				String image = rs.getString("image");// '头像',

				player = new Player(playerId, firstlearningAge, nowLearnClubId, everLearnCloudId, nowLearnTeamId,
						everLearnTeamId, userId, weChatId, telephone, userName, sex, password, birthday, country, city,
						height, weight, play, ice_player, snow_play, roleId, handingId, image);

				return player;
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
		return player;
	}

	public Player updatePlayer(int userId, int nowTeachClubId, int nowTeachTeamId) {
		player = getPlayerByUserId(userId);
		if (player != null) {
			String sql = "UPDATE player SET nowLearnClubId=?, nowLearnTeamId=? WHERE userId=?";
			try {
				conn = util.openConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, nowTeachClubId);
				preparedStatement.setInt(2, nowTeachTeamId);
				preparedStatement.setInt(3, userId);

				System.out.println(sql);
				int i = preparedStatement.executeUpdate();
				if (i == 1) {
					System.out.println(sql);
					player = getPlayerByUserId(userId);
					System.out.println(player);
					System.out.println("更新成功");
					return player;
				} else {
					System.out.println("更新失败");
					return null;
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

			return player;
		} else {
			System.out.println("该用户在球员表中不存在");
			return null;
		}
	}

}
