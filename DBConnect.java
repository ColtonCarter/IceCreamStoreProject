package icecreamshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
			
		private static Connection conn;
		
		public DBConnect(String dbURL, String user, String password) throws SQLException{
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
		
		}
		
		public void shutdown() throws SQLException{
		
			if(conn != null){
				conn.close();
			}
			
			
		}
		
		public void insert(String fName, String lName, String fave) throws SQLException {
			Statement insert = conn.createStatement();
			insert.executeUpdate("INSERT INTO customer (firstName, lastName, faveFlavor) " + "VALUES ('" + fName + "' , '" + lName + "', '" + fave  + "')");
		}
		
		public int placeOrder(String custID, String type, String flavor, int scoops, double total) throws SQLException {
			Statement insert = conn.createStatement();
			String SQL = "select * from customer WHERE customerID = " + custID + "";
			ResultSet records = insert.executeQuery(SQL);
			if (records.next()){
				return 0;
			}
			else {
			insert.executeUpdate("INSERT INTO orders (customerID, cone_type, cone_flavor, numScoops, status, total) VALUES ('" + custID + "' , '" + type + "' , '" + flavor + "' , '" + scoops + "' , 'Incomplete' , '" + total + "')");
			}
			return 1;
		}
		
			
			public List<Order> getOrders() throws SQLException{
				
				try(
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from orders");
			
				){
			
					List<Order> orderList = new ArrayList<>();
					while (rs.next()){
			
						String num = rs.getString("order_num");
						String type = rs.getString("cone_type");
						String flavor = rs.getString("cone_flavor");
						String scoops = rs.getString("numScoops");
						String status = rs.getString("status");
						String total = rs.getString("total");
			
						Order order = new Order(num, type, flavor, scoops, status, total);
						orderList.add(order);
					}
					return orderList;
				}
				
		}
			
			
			public List<Customer> getCustomers() throws SQLException{
				
				try(
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from customer");
			
				){
			
					List<Customer> customerList = new ArrayList<>();
					while (rs.next()){
			
						String fname = rs.getString("firstName");
						String lname = rs.getString("lastName");
						String custID = rs.getString("customerID");
						String flavor = rs.getString("faveFlavor");
			
						Customer order = new Customer(fname, lname, custID, flavor);
						customerList.add(order);
					}
					return customerList;
				}
				
		}

			public void update(String order_num) throws SQLException {
				
				Statement update_order = conn.createStatement();
				update_order.executeUpdate("UPDATE orders SET status = 'Complete' WHERE order_num = " + order_num + "");
				
				
			}
}
			