package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.UtilClass;

public class LoginDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int verify(String username, String password) {

		int val = 0;
		try {
			con = UtilClass.getConnection();
			ps = con.prepareStatement("select count(*) from Login_UltraP where identification_no=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				val = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return val;

	}

}
