package pl.otogra.model;

import java.sql.Timestamp;
import java.util.Date;

public class Review {
	private long id;
	private long userId;
	private long gameId;
	private Timestamp time;
	private int score;
	private String comment;

	public Review() {
	}

	public Review(long userId, long gameId,int score, String comment) {
		this.userId = userId;
		this.gameId = gameId;
		this.time = new Timestamp(new Date().getTime());
		this.score = score;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", userId=" + userId + ", gameId=" + gameId + ", date=" + time + ", score=" + score
				+ ", comment=" + comment + "]";
	}
}
