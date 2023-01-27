package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.Drama;
import dto.Top10Join;

public class Top10Repository {
	private static Top10Repository repository = new Top10Repository();
	public static Top10Repository getInstance() {
		return repository;
	}
	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public List<Top10Join> findTop10(Integer id) {
		List<Top10Join> top10Join = new ArrayList<>();
		conn = new DBConnection().getConn();
		
		String sql = "select "
				+ "d.title as dramaName,"
				+ "p.pName as VOD,"
				+ "d.episodeCount as numberOfEpisode,"
				+ "d.genre as genre,"
				+ "d.rating as rating,"
				+ "d.contentRating as contentRating,"
				+ "d.actor as cast,"
				+ "d.ranking as ranking "
				+ "from Drama as d "
				+ "inner join User as u on 2023 - u.birthYear >= left(d.contentRating, 2)"
				+ "left join platform as p on p.pId = d.originalNetwork "
				+ "where u.userId = ? "
				+ "limit 10";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
 				String dramaName = rs.getString("dramaName");
 				String VOD = rs.getString("VOD");
 				Integer numberOfEpisode = rs.getInt("numberOfEpisode");
 				String genre = rs.getString("genre");
 				String contentRating = rs.getString("contentRating");
 				float rating = rs.getFloat("rating");
 				String cast = rs.getString("cast");
 				String ranking = rs.getString("ranking");
 				Top10Join row = new Top10Join(dramaName, VOD, numberOfEpisode, contentRating, rating, genre, cast, ranking);
 				top10Join.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return top10Join;
	}
	
	public List<Drama> SearchDirector(String str) {
		List<Drama> searchDirector = new ArrayList<>();
		conn = new DBConnection().getConn();
		
		String sql = "select *"
				+ "from Drama"
				+ "where director like '%?%'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Drama row = new Drama(rs);
				searchDirector.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchDirector;
	}
	
	public List<Drama> SearchActor(String str) {
		List<Drama> searchActor = new ArrayList<>();
		conn = new DBConnection().getConn();
		
		String sql = "select * "
				+ "from Drama "
				+ "where actor like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + str + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Drama row = new Drama(rs);
				searchActor.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchActor;
	}
}
