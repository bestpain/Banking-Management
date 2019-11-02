package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Account;
import com.model.Customer;
import com.util.UtilClass;

public class AccountDAO {
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	Connection con = null;
	ResultSet rs = null;

	public int createAccount(int custid, String acctype, double balance) {
		int res = 0;
		ArrayList<String> acct = new ArrayList<>();
		con = UtilClass.getConnection();
		try {
			ps1 = con.prepareStatement("select account_type from Account_Ultra where customer_id=" + custid);
			rs = ps1.executeQuery();
			while (rs.next()) {
				acct.add(rs.getString(1));
			}
			System.out.println("yes");
			System.out.println(acct);
			if (acct.isEmpty()) {
				ps = con.prepareStatement(
						"insert into Account_Ultra(Customer_id,account_id,account_type,balance,cr_date,cr_lastdate) values(?,seq_account_ultra.nextval,?,?,sysdate,default)");
				ps.setInt(1, custid);
				ps.setString(2, acctype);
				ps.setDouble(3, balance);
				res = ps.executeUpdate();
				if (res > 0) {
					return 1;
				}
			} else {
				for (String s : acct) {
					if (s.equalsIgnoreCase(acctype)) {
						return 0;
					} else {
						ps = con.prepareStatement(
								"insert into Account_Ultra(Customer_id,account_id,account_type,balance,cr_date,cr_lastdate) values(?,seq_account_ultra.nextval,?,?,sysdate,default)");
						ps.setInt(1, custid);
						ps.setString(2, acctype);
						ps.setDouble(3, balance);
						res = ps.executeUpdate();
						if (res > 0) {
							return 1;
						}

					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}
		return 0;
	}

	public ArrayList<Account> getAccountDetails(int ssnid, int custid) {
		con = UtilClass.getConnection();
		ArrayList<Account> accList = new ArrayList<>();
		try {
			if (ssnid > 0 && custid > 0) {
				System.out.println(ssnid);
				System.out.println(custid);
				ps = con.prepareStatement(
						"select ACCOUNT_ULTRA.Customer_id,ACCOUNT_ULTRA.Account_id,ACCOUNT_ULTRA.account_type,ACCOUNT_ULTRA.balance,ACCOUNT_ULTRA.cr_date,ACCOUNT_ULTRA.cr_lastdate from ACCOUNT_ULTRA inner join Customer_Ultra on Customer_Ultra.customer_id=ACCOUNT_ULTRA.customer_id where Customer_Ultra.ssn=? and ACCOUNT_ULTRA.customer_id=?");

				ps.setInt(1, ssnid);
				ps.setInt(2, custid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Account acc = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getString(6));
					accList.add(acc);
				}
				if (accList != null) {
					return accList;
				}
			}

			else if (ssnid > 0 && custid == 0) {
				System.out.println(ssnid);
				System.out.println(custid);
				ps = con.prepareStatement(
						"select ACCOUNT_ULTRA.Customer_id,ACCOUNT_ULTRA.Account_id,ACCOUNT_ULTRA.account_type,ACCOUNT_ULTRA.balance,ACCOUNT_ULTRA.cr_date,ACCOUNT_ULTRA.cr_lastdate from ACCOUNT_ULTRA inner join Customer_Ultra on Customer_Ultra.customer_id=ACCOUNT_ULTRA.customer_id where Customer_Ultra.ssn=?");
				ps.setInt(1, ssnid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Account acc = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getString(6));
					accList.add(acc);
				}
				if (accList != null) {
					return accList;
				}
			} else if (ssnid == 0 && custid > 0) {
				System.out.println(ssnid);
				System.out.println(custid);
				ps = con.prepareStatement(
						"select ACCOUNT_ULTRA.Customer_id,ACCOUNT_ULTRA.Account_id,ACCOUNT_ULTRA.account_type,ACCOUNT_ULTRA.balance,ACCOUNT_ULTRA.cr_date,ACCOUNT_ULTRA.cr_lastdate from ACCOUNT_ULTRA inner join Customer_Ultra on Customer_Ultra.customer_id=ACCOUNT_ULTRA.customer_id where ACCOUNT_ULTRA.customer_id=?");
				ps.setInt(1, custid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Account acc = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getString(6));
					accList.add(acc);
				}
				if (accList != null) {
					return accList;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}
		return null;
	}

	public int deleteAccount(int accid) {
		double res = 0;
		int temp = 0;
		int cnt = 0;
		Account a = null;
		con = UtilClass.getConnection();
		try {
			ps = con.prepareStatement("select balance from ACCOUNT_ULTRA where account_id=" + accid);

			rs = ps.executeQuery();
			if (rs.next())
				res = rs.getDouble(1);
			if (res > 0) {
				ps2 = con.prepareStatement("update Account_Ultra set balance=0.0 where account_id=" + accid);

				cnt = ps2.executeUpdate();

			}
			if (cnt > 0) {
				ps1 = con.prepareStatement(
						"update Account_Status_Ultra set status='inactive',message='Account Deactivated' where account_id="
								+ accid);

				temp = ps1.executeUpdate();

				if (temp > 0) {
					return 1;
				}
			}
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}

		return 0;
	}

	public int createAccountStatus(int custid, String accType) {
		con = UtilClass.getConnection();
		int temp = 0;

		int a = 0;
		try {
			ps = con.prepareStatement("select account_id from Account_Ultra where customer_id=? and account_type=?");
			ps.setInt(1, custid);
			ps.setString(2, accType);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				temp = rs.getInt(1);

			}
			if (temp > 0) {
				ps1 = con.prepareStatement(
						"insert into Account_Status_Ultra(Customer_id,Account_id,Account_type,Status,Message,Last_Updated) values(?,?,?,'active','create',sysdate)");
				ps1.setInt(1, custid);
				ps1.setInt(2, temp);
				ps1.setString(3, accType);
				a = ps1.executeUpdate();
				if (a > 0) {
					return 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
			UtilClass.closeStatement(ps1);
		}
		return 0;
	}

	public ArrayList<Account> getAccountStatus() {
		con = UtilClass.getConnection();
		ArrayList<Account> acctList = new ArrayList<>();
		try {
			ps = con.prepareStatement("select * from Account_Status_Ultra");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account a = new Account();
				a.setCustId(rs.getInt(1));
				a.setAccId(rs.getInt(2));
				a.setAccType(rs.getString(3));
				a.setStatus(rs.getString(4));
				a.setMessage(rs.getString(5));
				a.setLastup(rs.getString(6));
				acctList.add(a);
			}
			if (acctList != null) {
				return acctList;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Account> getAccountBalance(int custid) {
		ArrayList<Account> accList = new ArrayList<Account>();
		con = UtilClass.getConnection();
		int temp = 0;
		try {
			ps = con.prepareStatement("select account_type,balance from Account_Ultra where customer_id=" + custid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account a = new Account();
				a.setAccType(rs.getString(1));
				a.setBalance(rs.getDouble(2));
				accList.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accList;

	}

	public int deleteAccountH(int custid) {
		con = UtilClass.getConnection();
		int temp = 0;
		int temp1 = 0;
		try {
			ps = con.prepareStatement("delete from Account_Status_Ultra where customer_id=" + custid);
			temp = ps.executeUpdate();
			if (temp > 0) {
				ps1 = con.prepareStatement("delete from Account_Ultra where customer_id=" + custid);
				temp1 = ps1.executeUpdate();
				if (temp1 > 0) {
					return 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
