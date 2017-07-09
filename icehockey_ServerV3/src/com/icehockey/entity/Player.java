package com.icehockey.entity;

import java.util.Date;

public class Player {

	private int playerId;// 球员编号
	private int firstlearningAge;// '初学年龄',
	private int nowLearnClubId;// '现俱乐部',
	private int everLearnCloudId;// '曾执教俱乐部',
	private int nowLearnTeamId;// '现执教球队',
	private int everLearnTeamId;// '曾执教球队',

	private int userId;// '登录编号',
	private String weChatId;// '微信账号',
	private String telephone;// '手机号码',
	private String userName;// '用户姓名',
	private int sex;// 1代表男生0表示女生,默认为1男生',
	private String password;// '密码',
	private Date birthday;// '出生日期',
	private String country;// '国籍',
	private String city;// '城市',
	private double height;// '身高',
	private double weight;// '体重',
	private String play;// '爱好：玩雪，玩冰，都玩',
	private String ice_play;// '游戏项目',
	private String snow_play;// '单板，双板，都玩',
	private int roleId;// '角色编号',
	private int handingId;// '持杆方式',
	private String image;// '头像',

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getFirstlearningAge() {
		return firstlearningAge;
	}

	public void setFirstlearningAge(int firstlearningAge) {
		this.firstlearningAge = firstlearningAge;
	}

	public int getNowLearnClubId() {
		return nowLearnClubId;
	}

	public void setNowLearnClubId(int nowLearnClubId) {
		this.nowLearnClubId = nowLearnClubId;
	}

	public int getEverLearnCloudId() {
		return everLearnCloudId;
	}

	public void setEverLearnCloudId(int everLearnCloudId) {
		this.everLearnCloudId = everLearnCloudId;
	}

	public int getNowLearnTeamId() {
		return nowLearnTeamId;
	}

	public void setNowLearnTeamId(int nowLearnTeamId) {
		this.nowLearnTeamId = nowLearnTeamId;
	}

	public int getEverLearnTeamId() {
		return everLearnTeamId;
	}

	public void setEverLearnTeamId(int everLearnTeamId) {
		this.everLearnTeamId = everLearnTeamId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getWeChatId() {
		return weChatId;
	}

	public void setWeChatId(String weChatId) {
		this.weChatId = weChatId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play;
	}

	public String getIce_play() {
		return ice_play;
	}

	public void setIce_player(String ice_play) {
		this.ice_play = ice_play;
	}

	public String getSnow_play() {
		return snow_play;
	}

	public void setSnow_play(String snow_play) {
		this.snow_play = snow_play;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getHandingId() {
		return handingId;
	}

	public void setHandingId(int handingId) {
		this.handingId = handingId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstlearningAge=" + firstlearningAge + ", nowLearnClubId="
				+ nowLearnClubId + ", everLearnCloudId=" + everLearnCloudId + ", nowLearnTeamId=" + nowLearnTeamId
				+ ", everLearnTeamId=" + everLearnTeamId + ", userId=" + userId + ", weChatId=" + weChatId
				+ ", telephone=" + telephone + ", userName=" + userName + ", sex=" + sex + ", password=" + password
				+ ", birthday=" + birthday + ", country=" + country + ", city=" + city + ", height=" + height
				+ ", weight=" + weight + ", play=" + play + ", ice_play=" + ice_play + ", snow_play=" + snow_play
				+ ", roleId=" + roleId + ", handingId=" + handingId + ", image=" + image + "]";
	}

	public Player(int playerId, int firstlearningAge, int nowLearnClubId, int everLearnCloudId, int nowLearnTeamId,
			int everLearnTeamId, int userId, String weChatId, String telephone, String userName, int sex,
			String password, Date birthday, String country, String city, double height, double weight, String play,
			String ice_player, String snow_play, int roleId, int handingId, String image) {
		super();
		this.playerId = playerId;
		this.firstlearningAge = firstlearningAge;
		this.nowLearnClubId = nowLearnClubId;
		this.everLearnCloudId = everLearnCloudId;
		this.nowLearnTeamId = nowLearnTeamId;
		this.everLearnTeamId = everLearnTeamId;
		this.userId = userId;
		this.weChatId = weChatId;
		this.telephone = telephone;
		this.userName = userName;
		this.sex = sex;
		this.password = password;
		this.birthday = birthday;
		this.country = country;
		this.city = city;
		this.height = height;
		this.weight = weight;
		this.play = play;
		this.ice_play = ice_player;
		this.snow_play = snow_play;
		this.roleId = roleId;
		this.handingId = handingId;
		this.image = image;
	}

}
