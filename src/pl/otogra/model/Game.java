package pl.otogra.model;

public class Game {
	private long id;
	private String title;
	private String description;
	private int year;
	private double price;
	private double score;
	private String photo;
	private User user;

	public Game() {
	}

	public Game(String title, String description, int year, double price, double score,String photo,User user) {
		this.title = title;
		this.description = description;
		this.year = year;
		this.price = price;
		this.score = score;
		this.photo=photo;
		this.user=user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", description=" + description + ", year=" + year + ", price="
				+ price + ", score=" + score +" photo "+photo+ "]";
	}

	



}
