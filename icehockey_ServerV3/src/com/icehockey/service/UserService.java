package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.HandlingDao;
import com.icehockey.dao.RoleDao;
import com.icehockey.dao.UserDao;
import com.icehockey.entity.Coach;
import com.icehockey.entity.Handling;
import com.icehockey.entity.Judge;
import com.icehockey.entity.Player;
import com.icehockey.entity.Role;
import com.icehockey.entity.User;

public class UserService {

	UserDao dao = new UserDao();
	RoleDao roleDao = new RoleDao();
	HandlingDao handlingDao = new HandlingDao();

	PlayerService playerService = new PlayerService();
	CoachService coachService = new CoachService();
	JudgeService judgeService = new JudgeService();

	List<User> users = null;

	User user = null;
	Player player = null;
	Coach coach = null;
	Judge judge = null;
	Role role = null;
	Handling handling = null;

	public User queryByTelepone(String telephone) {
		user = dao.getUsersByTelephone(telephone);
		return user;
	}

	public User insertUser(String telephone, String userName, String password) {
		user = dao.insertUser(telephone, userName, password);
		user = queryByTelepone(telephone);
		if (user != null) {
			System.out.println(user);
			System.out.println("用户表插入成功");
			/*
			 * player=pService.insertPlayer(user.getUserId()); if(player!=null){
			 * System.out.println(player); System.out.println("球员表插入成功"); }
			 */
		}
		return user;
	}

	public User loginByWechatId(String wechatId, String password) {
		user = dao.getUsersByWechatId(wechatId);
		System.out.println(user.toString());
		if (user != null) {
			if (password.equals(user.getPassword())) {
				System.out.println("登陆成功");
			} else {
				System.out.println("密码错误");
			}
		} else {
			System.out.println("该用户不存在");
		}
		return user;
	}

	public User loginByTelepone(String telephone, String password) {
		user = dao.getUsersByTelephone(telephone);
		if (user != null) {
			if (password.equals(user.getPassword())) {
				System.out.println("登陆成功");
				return user;
			} else {
				System.out.println("密码错误");
				user = null;
			}
		} else {
			System.out.println("该用户不存在");
			user = null;
		}
		return user;
	}

	public User queryUserByUserId(int userId) {
		user = dao.getUserByUserId(userId);
		return user;
	}

	public User updateUserByUserId(int userId, String playValue, String ice_playValue, String snow_playValue,
			String roleValue, String handlingValue) {
		role = roleDao.getRoleByRoleValue(roleValue);
		System.out.println(role);
		handling = handlingDao.getHandlingByHandlingValue(handlingValue);
		System.out.println(role);
		if (role != null) {
			System.out.println(role.toString());
			if (handling != null) {
				System.out.println(handling.toString());
				user = dao.updateUser(userId, playValue, ice_playValue, snow_playValue, role.getRoleId(),
						handling.getHandlingId());
				System.out.println("第一次登录页面更新成功");

			} else {
				System.out.println(handlingValue + "该持杆方式不存在");
				user = null;
			}
		} else {
			System.out.println(roleValue + "该角色不存在");
			user = null;
		}
		return user;
	}

	public User insertUser(int userId, int sex, double height, double weight, String country, String city,
			String xianxiaolijvlebu, String xianshuqiudui) {
		user = dao.getUserByUserId(userId);
		if (user != null) {
			System.out.println("更新前" + user.toString());

			int roleId = user.getRoleId();
			role = roleDao.getRoleByRoleId(roleId);
			String roleName = roleDao.getRoleByRoleId(roleId).getRoleName();

			user = updateUser(userId, sex, height, weight, country, city);
			System.out.println(user.toString());

			if ("教练".equals(roleName)) {// 教练
				coach = coachService.updateCoach(userId, xianxiaolijvlebu, xianshuqiudui);
				if (coach != null) {
					System.out.println(coach);
				} else {
					System.out.println("教练信息更新失败");
				}
			} else if ("裁判员".equals(roleName)) {// 裁判员
				judge = judgeService.insertJudge(userId);
				System.out.println(judge);
			} else {// 球员，守门员
				player = playerService.updatePlayer(userId, xianxiaolijvlebu, xianshuqiudui);
				if (player != null) {
					System.out.println(player);
				} else {
					System.out.println("球员信息更新失败");
				}
			}

			return user;
		} else {
			System.out.println(userId + "用户不存在");
			return null;
		}

	}

	private User updateUser(int userId, int sex, double height, double weight, String country, String city) {
		user = dao.getUserByUserId(userId);
		if (user != null) {
			user = dao.updateUserByUserId(userId, sex, height, weight, country, city);
		} else {
			System.out.println("该用户不存在user表");
			user = null;
		}
		return user;
	}

	public User updateUser(int userId, String userName, double height, double weight, String country, String city) {
		user = dao.getUserByUserId(userId);
		if (user != null) {
			user = dao.updateUserByUserId(userId, userName, height, weight, country, city);
		} else {
			System.out.println("该用户不存在user表");
			user = null;
		}
		return user;
	}

}
