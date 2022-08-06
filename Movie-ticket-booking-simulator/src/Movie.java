
public class Movie {
	private String date;
	private String time;
	private String seatingArrangement;
	private  String movieName;
	private int price;
	private String bookingStatus;
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSeatingArrangement() {
		return seatingArrangement;
	}
	public void setSeatingArrangement(String seatingArrangement) {
		this.seatingArrangement = seatingArrangement;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int i) {
		this.price = i;
	}
	@Override
	public String toString() {
		return "Movie [date=" + date + ", time=" + time + ", seatingArrangement=" + seatingArrangement + ", movieName="
				+ movieName + ", price=" + price + ", bookingStatus=" + bookingStatus + "]";
	}

	
	
	
	
	
	
	

}
