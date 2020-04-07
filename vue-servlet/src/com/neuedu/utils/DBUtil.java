package com.neuedu.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBUtil {
//	 * 1銆佸缓绔嬭繛鎺�
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		BasicDataSource dataSource=new BasicDataSource();
		//鍥涗釜蹇呴�夐」
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/java24?characterEncoding=UTF-8&useUnicode=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//鍏朵粬璁剧疆(鍙�夎缃�)
		dataSource.setInitialSize(8);
		dataSource.setMaxWaitMillis(5000);
		dataSource.setMaxTotal(20);
		dataSource.setMinIdle(3);
		Connection conn=dataSource.getConnection();
		return conn;
		/*// 1鍔犺浇椹卞姩
		Class.forName("com.mysql.jdbc.Driver");
		// 2杩炴帴鍑嗗
		String url = "jdbc:mysql://localhost:3306/java24?characterEncoding=UTF-8&useUnicode=true";
		String username = "root";
		String password = "root";
		// 3寤鸿繛鎺�
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;*/
		
		

					 
	}
//	 * 2銆併�愪簨鍔°�戝紑鍚簨鍔�
	public static void beginTransaction(Connection conn) throws SQLException{
		conn.setAutoCommit(false);
	}
	
//	 * 3銆佹墽琛屾暟鎹簱鐩稿叧鎿嶄綔---鐢ㄦ埛寮�鍙�
	
//	 * 4銆併�愪簨鍔°�戞彁浜や簨鍔�
	public static void commit(Connection conn) throws SQLException{
		conn.commit();
	}
//	 * 5銆併�愪簨鍔°�戝洖婊氫簨鍔�
	public static void rollback(Connection conn) throws SQLException{
		conn.rollback();
	}
//	 * 6銆佸叧闂繛鎺�
	public static void closeDB(ResultSet rs,Statement st,Connection conn) throws SQLException{
		//鍏抽棴姣忎竴涓兘闇�瑕佸厛鍋氶潪绌哄垽鏂紝闃叉鍑虹幇绌烘寚閽堝紓甯�
		if(rs!=null){
			rs.close();
		}
		if(st!=null){
			st.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
