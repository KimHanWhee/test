package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Drama {
	private String name;
	private String airedDate;
	private Integer releasedYear;
	private String VOD;
	private String airedOn;
	private Integer numberOfEpisode;
	private String duration;
	private String contentRating;
	private float rating;
	private String genre;
	private String tag;
	private String director;
	private String cast;
	private String productionCompany;
	private String rank;
	
	public Drama(ResultSet rs) {
		try {
			this.name = rs.getString("title");
			this.airedDate = rs.getString("onDate");
			this.releasedYear = rs.getInt("releaseYear");
			this.VOD = rs.getString("originalNetwork");
			this.airedOn = rs.getString("onDay");
			this.numberOfEpisode = rs.getInt("episodeCount");
			this.duration = rs.getString("duration");
			this.contentRating = rs.getString("contentRating");
			this.rating = rs.getInt("rating");
			this.genre = rs.getString("genre");
			this.tag = rs.getString("tags");
			this.director = rs.getString("director");
			this.cast = rs.getString("actor");
			this.productionCompany = rs.getString("productionCompany");
			this.rank = rs.getString("ranking");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAiredDate() {
		return airedDate;
	}
	public void setAiredDate(String airedDate) {
		this.airedDate = airedDate;
	}
	public Integer getReleasedYear() {
		return releasedYear;
	}
	public void setReleasedYear(Integer releasedYear) {
		this.releasedYear = releasedYear;
	}
	public String getVOD() {
		return VOD;
	}
	public void setVOD(String vOD) {
		VOD = vOD;
	}
	public String getAiredOn() {
		return airedOn;
	}
	public void setAiredOn(String airedOn) {
		this.airedOn = airedOn;
	}
	public Integer getNumberOfEpisode() {
		return numberOfEpisode;
	}
	public void setNumberOfEpisode(Integer numberOfEpisode) {
		this.numberOfEpisode = numberOfEpisode;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getContentRating() {
		return contentRating;
	}
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getProductionCompany() {
		return productionCompany;
	}
	public void setProductionCompany(String productionCompany) {
		this.productionCompany = productionCompany;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Drama [name=" + name + ", airedDate=" + airedDate + ", releasedYear=" + releasedYear + ", VOD=" + VOD
				+ ", airedOn=" + airedOn + ", numberOfEpisode=" + numberOfEpisode + ", duration=" + duration
				+ ", contentRating=" + contentRating + ", rating=" + rating + ", genre=" + genre + ", tag=" + tag
				+ ", director=" + director + ", cast=" + cast + ", productionCompany=" + productionCompany + ", rank="
				+ rank + "]\n";
	}

	
}
