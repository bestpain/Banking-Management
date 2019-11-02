package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Customer;
import com.service.AccountService;
import com.util.UtilClass;

public class CustomerDAO {
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	Connection con = null;
	AccountDAO dao = new AccountDAO();

	public int registerCustomer(Customer customer) {
		int res = 0;
		con = UtilClass.getConnection();
		try {

			ps = con.prepareStatement("insert into Customer_Ultra values(?,seq_customer_ultra.nextval,?,?,?,?,?)");
			ps.setInt(1, customer.getSSN());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			res = ps.executeUpdate();
			if (res > 0) {
				return 1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}
		return 0;
	}

	public Customer getCustomerDetails(int ssnid, int custid) {
		con = UtilClass.getConnection();
		Customer cust = null;
		try {
			if (ssnid > 0 && custid > 0) {
				System.out.println(ssnid);
				System.out.println(custid);
				ps = con.prepareStatement(
						"select SSN,Customer_id,Name,age,address from Customer_Ultra where ssn=? and customer_id=?");

				ps.setInt(1, ssnid);
				ps.setInt(2, custid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					cust = new Customer();
					cust.setSSN(rs.getInt(1));
					System.out.println(rs.getInt(1));
					cust.setCustId(rs.getInt(2));
					cust.setName(rs.getString(3));
					cust.setAge(rs.getInt(4));
					cust.setAddress(rs.getString(5));
				}
				if (cust != null) {
					return cust;
				}
			}

			else if (ssnid > 0 && custid == 0) {
				System.out.println(ssnid);
				System.out.println(custid);
				ps = con.prepareStatement("select SSN,Customer_id,Name,age,address from Customer_Ultra where ssn=? ");
				ps.setInt(1, ssnid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					cust = new Customer();
					cust.setSSN(rs.getInt(1));
					System.out.println(rs.getInt(1));
					cust.setCustId(rs.getInt(2));
					cust.setName(rs.getString(3));
					cust.setAge(rs.getInt(4));
					cust.setAddress(rs.getString(5));
				}
				if (cust != null) {
					return cust;
				}
			} else if (ssnid == 0 && custid > 0) {
				System.out.println(ssnid);
				System.out.println(custid);
				ps = con.prepareStatement(
						"select SSN,Customer_id,Name,age,address from Customer_Ultra where customer_id=?  ");
				ps.setInt(1, custid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					cust = new Customer();
					cust.setSSN(rs.getInt(1));
					System.out.println(rs.getInt(1));
					cust.setCustId(rs.getInt(2));
					cust.setName(rs.getString(3));
					cust.setAge(rs.getInt(4));
					cust.setAddress(rs.getString(5));
				}
				if (cust != null) {
					return cust;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}
		return null;
	}

	public int updateCustomer(int custid, String name, String address, int age) {
		con = UtilClass.getConnection();
		int res = 0;
		try {
			ps = con.prepareStatement("update Customer_Ultra set Name=?,Age=?,Address=? where customer_id=?");
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, address);
			ps.setInt(4, custid);
			res = ps.executeUpdate();
			if (res > 0) {
				return 1;
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteCustomer(int custid) {
		int res = 0;
		int temp = 0;
		int ans = 0;
		
		con = UtilClass.getConnection();
		
		try {

			ans = dao.deleteAccountH(custid);
			if (ans > 0) {
				ps1 = con.prepareStatement("delete from Customer_Status_Ultra where customer_id=" + custid);
				temp = ps1.executeUpdate();
				if (temp > 0) {
					ps = con.prepareStatement("delete from Customer_Ultra where customer_id=" + custid);
					res = ps.executeUpdate();

					if (res > 0) {
						return 1;
					}
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}

		return 0;
	}

	public int createCustomerStatus(int ssnid) {
		con = UtilClass.getConnection();
		int temp = 0;
		int a = 0;
		try {
			ps = con.prepareStatement("select customer_id from Customer_Ultra where ssn=" + ssnid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				temp = rs.getInt(1);
			}
			if (temp > 0) {
				ps1 = con.prepareStatement(
						"insert into Customer_Status_Ultra(SSNID,Customer_id,Status,Message,Last_Updated) values(?,?,'completed','create',sysdate)");
				ps1.setInt(1, ssnid);
				ps1.setInt(2, temp);
				a = ps1.executeUpdate();
				if (a > 0) {
					return 1;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
			UtilClass.closeStatement(ps1);
		}
		return 0;
	}

	public int updateCustomerStatus(int custid) {
		con = UtilClass.getConnection();
		int temp = 0;
		int a = 0;
		try {
			ps = con.prepareStatement(
					"update Customer_Status_Ultra set Status='completed',Message='updated',Last_Updated=sysdate where customer_id=?");
			ps.setInt(1, custid);
			a = ps.executeUpdate();
			if (a > 0) {
				return 1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}
		return 0;
	}

	public int updateCustomerStatusInProgress(int custid) {
		con = UtilClass.getConnection();

		int a = 0;
		try {
			ps = con.prepareStatement(
					"update Customer_Status_Ultra set Status='inprogress',Message='update',Last_Updated=sysdate where customer_id=?");
			ps.setInt(1, custid);
			a = ps.executeUpdate();
			if (a > 0) {
				return 1;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}
		return 0;
	}

	/*public int deleteCustomerStatusInProgress(int custid) {
		con = UtilClass.getConnection();

		int a = 0;
		try {
			ps = con.prepareStatement(
					"update Customer_Status_Ultra set Status='deleted',Message='inprogress',Last_Updated=sysdate where customer_id=?");
			ps.setInt(1, custid);
			a = ps.executeUpdate();
			if (a > 0) {
				return 1;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			UtilClass.closeConnection(con);
			UtilClass.closeStatement(ps);
		}
		return 0;

	}*/

	public ArrayList<Customer> getCustomerStatus() {
		con = UtilClass.getConnection();
		ArrayList<Customer> custList = new ArrayList<>();
		try {
			ps = con.prepareStatement("select ssnid,status,message,last_updated from Customer_Status_Ultra");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setSSN(rs.getInt(1));
				c.setStatus(rs.getString(2));
				c.setMessage(rs.getString(3));
				c.setLastupdate(rs.getString(4));
				custList.add(c);
			}
			if (custList != null) {
				return custList;
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Integer>  deleteCustomerAccount(int custid) {
		
		int ans = 0;
		
		int accid = 0;
		con = UtilClass.getConnection();
		ArrayList<Integer> accidList = new ArrayList<>();
		try {

			ps2 = con.prepareStatement("select account_id from Account_Ultra where customer_id=" + custid);
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				accid = rs.getInt(1);
				accidList.add(accid);
			}
			System.out.println("inside delete cust dao");
			for (Integer a : accidList) {
				System.out.println(a);
				ans = dao.deleteAccount(a);
			}
			System.out.println(ans);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return accidList;

	}
}
