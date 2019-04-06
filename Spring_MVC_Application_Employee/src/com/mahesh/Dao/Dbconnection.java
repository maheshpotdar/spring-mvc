package com.mahesh.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mahesh.Model.User;

@Repository
// spring mvc understand this class related to dbconnection(Database).
public class Dbconnection {

	String sql;
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public void insertUser(@ModelAttribute User user) {
		// Insert user
		sql = "INSERT INTO user_register(username,password,mobile,address,designation) VALUES(?,?,?,?,?)";
		int val = jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassWord(), user.getMobile(),
				user.getAddress(), user.getDesignation() });
		System.out.println("Inserted successfully.");
	}

	public List<User> getUserList() {
		sql = "SELECT * FROM user_register";
		return jdbcTemplate.query(sql, new UserListRowMapper());
	}

	public User getIdwiseUser(int empId) {
		sql = "SELECT * FROM user_register WHERE id=" + empId;
		return jdbcTemplate.queryForObject(sql, new UserListRowMapper());
	}

	public int updateUser(User user, int userId) {
		int aprvValue = 0;
		sql = "UPDATE user_register SET username=?,password=?,mobile=?,address=?,designation=?,aprv=? WHERE id=?";
		System.out.println("user.getAprv(): " + user.getAprv());
		if (user.getAprv() == true)
			aprvValue = 1;
		else
			aprvValue = 0;
		return jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassWord(), user.getMobile(),
				user.getAddress(), user.getDesignation(), aprvValue, userId });
	}

	public int deleteUser(int userId) {
		sql = "DELETE FROM user_register WHERE id=?";
		return jdbcTemplate.update(sql, new Object[] { userId });
	}

	// public User userRegist(User register) {
	// // 1.username and password present or not
	// //
	// boolean check = false;
	// int retResult = 0;
	// String userOrNot = "", sql2 = "";
	// // password unique so get only 1 result
	// sql2 = "SELECT adminOrUser FROM register WHERE passWord=?";
	//
	// int adminOruser111 = jdbcTemplate.queryForObject(sql2, Integer.class,
	// new Object[] { register.getPassWord() });// 1
	//
	// sql = "SELECT * from register WHERE userName='"
	// + register.getUserName() + "' and passWord='"
	// + register.getPassWord() + "' and adminOrUser="
	// + adminOruser111;
	//
	// return jdbcTemplate.queryForObject(sql, new LoginRegisterRowMapper());//
	// 5
	//
	// // return jdbcTemplate.queryForList(sql, Register.class);
	// // problem thats why this kind of technique used
	// // // no insert user
	// // value
	// // but_return
	// // time error
	// // occured_so
	// // use this
	// // style.
	// // no available only String sql,object[] ==> for user input taken for
	// /*
	// * // select. System.out.println(sql + " user " + register.getUserName()
	// * + " pass" + register.getPassWord());
	// */
	// // return jdbcTemplate.queryForList(sql, Register.class);// no insert
	// // user
	// // value
	// // but_return
	// // time error
	// // occured_so
	// // use this
	// // style.
	// }

	public int insertRegiForm(User user) {
		sql = "INSERT INTO user_register(username,password,mobile,address,designation,adminOruser,aprv) VALUES(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassWord(), user.getMobile(),
				user.getAddress(), user.getDesignation(), 1, 1 });
	}

	public int getAdminOrUserValue() {
		int val = 0;
		sql = "SELECT adminOruser FROM user_register WHERE adminOruser=1";
		try {
			val = jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (Exception e) {
			val = 0;
		}
		return val;
	}

	/*
	 * private static final class LoginRegisterRowMapper implements RowMapper<User>
	 * {
	 * 
	 * @Override public User mapRow(ResultSet res, int row) throws SQLException {
	 * return new User(res.getString("mobile"), res.getString("address"),
	 * res.getString("userName"), res.getString("passWord"),
	 * res.getInt("adminOrUser")); } }
	 */

	public boolean isValidUser(User user) {
		boolean value = false;
		sql = "SELECT * FROM user_register WHERE username=?";
		User dbUser = jdbcTemplate.queryForObject(sql, new Object[] { user.getUserName() }, new UserListRowMapper());
		// Note:
		// database madhala user ani user ne enter kelela user equal ahet
		// tar
		// yes .
		return dbUser.getUserName().equals(user.getUserName()) && dbUser.getPassWord().equals(user.getPassWord());
	}

	public String getRoleOfUser(User user) {
		sql = "SELECT adminOruser FROM user_register WHERE username=?";

		int role = jdbcTemplate.queryForObject(sql, new Object[] { user.getUserName() }, Integer.class);

		return (role == 1) ? "admin" : "user";
	}

	private static final class UserListRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet res, int row) throws SQLException {
			User user = new User();
			user.setId(res.getInt("id"));
			user.setUserName(res.getString("username"));
			user.setPassWord(res.getString("password"));
			user.setAddress(res.getString("address"));
			user.setMobile(res.getString("mobile"));
			user.setDesignation(res.getString("designation"));
			return user;
		}

	}

	public int isApproved(User user, String role) {
		sql = "SELECT aprv FROM user_register WHERE username=? and adminOruser=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { user.getUserName(), role }, Integer.class);
	}

}
