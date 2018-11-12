package pl.otogra.model;

public class Game {
	private long id;
	private String title;
	private String description;
	private int year;
	private int price;
	private int score;

	public Game() {
	}

	public Game(String title, String description, int year, int price, int score) {
		this.title = title;
		this.description = description;
		this.year = year;
		this.price = price;
		this.score = score;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", description=" + description + ", year=" + year + ", price="
				+ price + ", score=" + score + "]";
	}

}
