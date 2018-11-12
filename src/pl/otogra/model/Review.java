package pl.otogra.model;

import java.sql.Timestamp;

public class Review {
	private long id;
	private Timestamp date;
	private int score;
	private String comment;

	public Review() {
	}

	public Review(Timestamp date, int score, String comment) {
		this.date = date;
		this.score = score;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", date=" + date + ", score=" + score + ", comment=" + comment + "]";
	}

}
