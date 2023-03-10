package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import db.DBConnection;
import dto.Drama;
import dto.Top10Join;

public class DramaRepository {

	private static DramaRepository repository = new DramaRepository();

	public static DramaRepository getInstance() {
		return repository;
	}

	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public void createDramaTable() {

		String sql = "create table Drama(" + "dramaId int primary key auto_increment," + "title varchar(255) not null,"
				+ "onDate varchar(255)," + "releaseYear int," + "originalNetwork varchar(20)," + "onDay varchar(255),"
				+ "episodeCount int," + "duration varchar(50)," + "contentRating varchar(255)," + "rating float,"
				+ "genre varchar(255)," + "tags varchar(250)," + "director varchar(30)," + "actor varchar(250),"
				+ "productionCompany varchar(255)," + "ranking varchar(7)" + ")";
		String[] sqls = new String[] { "drop table if exists Drama ", sql };
		for (String str : sqls) {
			try {
				conn = new DBConnection().getConn();
				stmt = conn.createStatement();
				stmt.executeUpdate(str);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public String insertTable(List<String> list) {
		String sql = "insert into Drama(" + "title," + "onDate," + "releaseYear," + "originalNetwork," + "onDay,"
				+ "episodeCount," + "duration," + "contentRating," + "rating," + "genre," + "tags," + "director,"
				+ "actor," + "productionCompany," + "ranking" + ") " + " values (" + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?" + ")";

		try {

			conn = new DBConnection().getConn();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < 15; i++) {
				pstmt.setString(i + 1, list.get(i).replace("\"", ""));
			}
			pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "?????? ??????";
	}

	public void updateOriginalNetwork() {
		String safeMode = "SET SQL_SAFE_UPDATES = 0;";
		String sql = "update Drama " + "set originalNetwork=" + "replace(originalNetwork, ?, ?)";
		try {
			conn = new DBConnection().getConn();
			pstmt = conn.prepareStatement(sql);
			stmt = conn.createStatement();
			stmt.executeUpdate(safeMode);
			List<String> Vod = Arrays.asList("Netflix", "Wavve", "KBS2", "MBC", "SBS", "tvN", "ENA", "jTBC", "Viki",
					"OCN", "Hulu", "iQiyi");
			for (int i = 0; i < Vod.size(); i++) {
				String str = Vod.get(i);
				pstmt.setString(1, str);
				if (str.equals("Netflix"))
					pstmt.setString(2, "1");
				else if (str.equals("Wavve"))
					pstmt.setString(2, "2");
				else if (str.equals("KBS2") || str.equals("MBC") || str.equals("SBS"))
					pstmt.setString(2, "3");
				else {
					pstmt.setString(2, "4");
				}
				pstmt.executeUpdate();
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
