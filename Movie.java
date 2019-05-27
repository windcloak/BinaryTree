
public class Movie implements Comparable<Movie>{

	private String movieTitle;
	private int releaseYear;
	private String rating;
	private int movieReview;
	
	//Constructor
	public Movie(String Title, int Year, String rating, int Review) {
		movieTitle = Title;
		releaseYear = Year;
		this.rating = rating;
		movieReview = Review;
	}
	
	public String getTitle() {
		return movieTitle;
	}
	
	public int getYear() {
		return releaseYear;
	}
	
	public String getRating() {
		return rating;
	}
	
	public int getReview() {
		return movieReview;
	}
	
	public int compareTo(Movie other) {
		//movie 1 < movie 2
		int c = this.movieTitle.compareTo(other.movieTitle);
		if (c<0) {
			return -1;
		}
		else if (c==0) {
			return 0;
		}
		else { //c>0
			return 1;
		}
	}
	
	public String toString() {
		String s = String.format("%-8s %-10s \r\n%-8s %-10d \r\n%-8s %-10s \r\n%-8s %-10d %n", "Title:",movieTitle,"Year:",releaseYear,"Rating:",rating,"Review:",movieReview);
		return s;
	}
	
	
	public String printString() {	
		return "Title: " + movieTitle + ", Year: " + releaseYear + ", Rating: " + rating + ", Review: " + movieReview + ";";
	}
}
