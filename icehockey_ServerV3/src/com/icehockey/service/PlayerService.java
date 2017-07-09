package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.ClubDao;
import com.icehockey.dao.CoachDao;
import com.icehockey.dao.PlayerDao;
import com.icehockey.dao.TeamDao;
import com.icehockey.entity.Club;
import com.icehockey.entity.Coach;
import com.icehockey.entity.Player;
import com.icehockey.entity.Team;

public class PlayerService {
	PlayerDao dao = new PlayerDao();
	List<Player> players = null;
	Player player = null;

	ClubService clubService = new ClubService();
	TeamService teamService = new TeamService();

	CoachDao coachDao = new CoachDao();
	ClubDao clubDao = new ClubDao();
	TeamDao teamDao = new TeamDao();

	Club club = null;
	Coach coach = null;
	Team team = null;

	public Player loginByTeleponeNumber(String telephoneNumber, String playerPassword) {
		// 通过电话和密码登录，登录成功返回Player对象，登陆失败返回null
		player = dao.getPlayersByTeleponeNumber(telephoneNumber);
		return player;

	}

	public Player queryByTeleponeNumber(String telephoneNumber) {
		// 通过电话和密码登录，登录成功返回Player对象，登陆失败返回null
		player = dao.getPlayersByTeleponeNumber(telephoneNumber);
		return player;

	}

	public Player loginByWechatNumber(String WechatNumber, String playerPassword) {
		// 通过电话和密码登录，登录成功返回Player对象，登陆失败返回null
		player = dao.getPlayersByWechatNumber(WechatNumber);
		return player;

	}

	public Player QueryByWechatNumber(String WechatNumber) {
		// 通过电话和密码登录，登录成功返回Player对象，登陆失败返回null
		player = dao.getPlayersByWechatNumber(WechatNumber);
		return player;

	}

	public Player insertPlayer(String telephoneNumber, String playerName, String playerPassword) {

		player = dao.insertPlayer(telephoneNumber, playerName, playerPassword);
		return player;

	}

	public Player updatePlayerByPlayerId(int playerId, int sex, double height, double weight, String country,
			String city, String xianxiaolijvlebu, String xianshuqiudui) {
		player = dao.updatePlayerByPlayerId(playerId, sex, height, weight, country, city, xianxiaolijvlebu,
				xianshuqiudui);
		return player;
	}

	public Player updatePlayerByPlayerId(int playerId, String playerName, double height, double weight, String country,
			String city) {
		player = dao.updatePlayerByPlayerId(playerId, playerName, height, weight, country, city);

		return player;
	}

	public Player queryPlayerByPlayerId(int playerId) {
		player = dao.getPlayerById(playerId);
		return player;
	}

	public Player insertPlayer(int userId) {
		player = dao.insertPlayer(userId);
		return player;

	}

	public Player updatePlayer(int userId, String xianxiaolijvlebu, String xianshuqiudui) {

		club = clubService.getClubByClubName(xianxiaolijvlebu);
		int nowTeachClubId = 0;
		int nowTeachTeamId = 0;
		if (club != null) {
			System.out.println(club);
			nowTeachClubId = club.getClubId();
		} else {
			System.out.println(xianxiaolijvlebu + "俱乐部不存在");
		}
		team = teamService.getTeamByTeamName(xianshuqiudui);
		if (team != null) {
			System.out.println(team);
			nowTeachTeamId = team.getTeamId();
		} else {
			System.out.println(xianxiaolijvlebu + "球队不存在");
		}

		player = dao.updatePlayer(userId, nowTeachClubId, nowTeachTeamId);
		if (player != null) {
			System.out.println(player);
		} else {
			System.out.println("球员俱乐部球队信息更新失败");
			player = null;
		}
		return player;
	}

}
