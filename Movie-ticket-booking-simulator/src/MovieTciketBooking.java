import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MovieTciketBooking {

	public static void main(String[] args) throws IOException {
		  File file=new File("D:\\ECLIPSE WORK\\Movie-ticket-booking-simulator\\src\\SeatingArrangement.txt");    //creates a new file instance  
		  FileReader fr=new FileReader(file);   //reads the file  
		  BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		  StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		  String line;  
		  int flag = 0;
		  String seatingArrangement = "";
		  
		  ArrayList<Movie> movies = new ArrayList<>();
		  while((line=br.readLine())!=null)  
		  {  
			  
		  
			  String[] str = line.split(" ");
			  Movie movie = new Movie();
			  movie.setDate(str[0]);
			  movie.setTime(str[1]);
			  movie.setSeatingArrangement(str[2]);
			  movie.setMovieName(str[3]);
			  movie.setPrice(Integer.parseInt(str[4]));
			  movies.add(movie);
			  
			
		  }
		 List<BookingStatus> booking  = new ArrayList<>();
		 
		 
	   System.out.println("WELCOME TO MOVIEING BOOKING SYSTEM")	 ;
	   System.out.println("Press 1 to login /2 to update password");
	   BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	   String option = reader.readLine();
	   if(option.equals("1"))
	   {   
		  
		int loginStatus = login();
		//adupdatePassword();
		if(loginStatus == 1) {
		int show = showSeatingArrangement(movies);
		if(show == 1) {
		booking =  bookTicket(movies,booking);
		calculateAmount(movies);
		}
		else {
			System.out.println("no seating arragment for above selection");
			
		}
		checkStatus(booking);
		}
     
		 if(loginStatus == 0) {
			 
			 System.out.println("existing system due to wrong crendentail");
		 }
	   }
	   else {
		   
		   updatePassword();
	   }

	}
	
	public   static int login() throws IOException {
		
		 BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));
		 System.out.println("Please enter your username");
		        // Reading data using readLine
		        String name = reader.readLine();
		  System.out.println("Please enter your password");    
		  String password = reader.readLine(); 
		        
		
		
		 boolean isFound = false;
		    String record = null;
		    FileReader in = null;
		    try{
		        in = new FileReader ("D:\\ECLIPSE WORK\\Movie-ticket-booking-simulator\\src\\credentails.txt");
		        BufferedReader bin = new BufferedReader(in);
		        record = bin.readLine();
		      String[] crendentail =   record.split(" ");
		       if(crendentail[0].equals(name) && crendentail[1].equals(password)) {
		    	   
		    	   isFound = true;
		       }
		       else
		    	   isFound  = false;

		    bin.close();
		    bin = null;
		 }catch(IOException ioe){
		   System.out.println("IPO wRONG password;");
		 }   
		
		    
		    if(isFound) {
		    	
		    	
		    	System.out.println("login successfull, WELCOME ");
		    	return 1;
		    	
		    }
		    else 
		    {
		    	
		    	System.out.println("username  or password is wrong");
		    }
			return 0;
		
		// TODO Auto-generated method stub
		
		
	}
	
	public static void updatePassword() throws IOException {
		
		 BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));
		 System.out.println("Please enter your username");
		        // Reading data using readLine
		        String name = reader.readLine();
		  System.out.println("Please enter your password to be updated");    
		  String password = reader.readLine(); 
		        
	      String text = name+ " "+ password;
	      String path = "D:\\ECLIPSE WORK\\Movie-ticket-booking-simulator\\src\\credentails.txt";
	      Files.write( Paths.get(path), text.getBytes());
		
		// TODO Auto-generated method stub
		
		
		
	}
	
	public static void calculateAmount(List<Movie> movies) throws IOException {
		BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 System.out.println("Please enter number of seats  to book");
 String number = reader.readLine();

 System.out.println("Please enter in which row you want to book ticket");
 String seat = reader.readLine();
 
 System.out.println("please enter name of the movie");
 String movieName = reader.readLine();
 String arr[] = null;
 int flag = 0;
 int amount = 0;
 
 for(Movie movie: movies) {
	 if(movie.getMovieName().equals(movieName)) {
	arr=  movie.getSeatingArrangement().split(",");
	//System.out.println(movie.getSeatingArrangement().split(","));
 
for(String str : arr) {
	String arr1[] = str.split("-");

	if(arr1[0].equals(seat) && Integer.parseInt(arr1[1]) > Integer.parseInt(number)){
		amount = movie.getPrice()*Integer.parseInt(number);
	
		flag  =1;
		break;
	}
	else {
		
		flag = 0;
	}
}
 }
 }

if(flag==1){
	
	System.out.println("total booking amount is "+amount);
}
else {
	
	System.out.println("tickets not avialble for this seating arrangement");
}

}
	
	public static List<BookingStatus> bookTicket(List<Movie> movies,List<BookingStatus> booking) throws IOException {
		

		 BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));
		 System.out.println("Please enter number of seats  to book");
		 String number = reader.readLine();
		
		 System.out.println("Please enter in which row you want to book ticket");
		 String seat = reader.readLine();
		 
		 System.out.println("please enter name of the movie");
		 String movieName = reader.readLine();
		 String arr[] = null;
		 int flag = 0;
		 
		 for(Movie movie: movies) {
			 if(movie.getMovieName().equals(movieName)) {
			arr=  movie.getSeatingArrangement().split(",");
			//System.out.println(movie.getSeatingArrangement().split(","));
		 
		for(String str : arr) {
			String arr1[] = str.split("-");
		
			if(arr1[0].equals(seat) && Integer.parseInt(arr1[1]) > Integer.parseInt(number)){
				flag  =1;
				break;
			}
			else {
				
				flag = 0;
			}
		}
		 }
		 }
		
		if(flag==1){
			
			System.out.println("tickets bookes successfully");
			Random rn = new Random();
			int answer = rn.nextInt(10) + 1;
			BookingStatus status = new BookingStatus();
			
			status.setBookingId(String.valueOf(answer));
			status.setStatus("confirmed");
			booking.add(status);
			
			System.out.println("your booking id is" +answer);
			
			
		}
		else {
			
			System.out.println("tickets not avialble for this seating arrangement");
		}
		return booking;
		
	}
	
	public static void checkStatus( List<BookingStatus>checkStatus) throws IOException {
		
		 BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));
		 System.out.println("Please enter bookingId to check status");
		        // Reading data using readLine
		        String bookingId = reader.readLine();
		
		for(BookingStatus status : checkStatus) {
		if(status.getBookingId().equals(bookingId))	{
			System.out.println("status is "+status.getStatus());
			
		}
		else
		{
			
			System.out.println("booking id is wrong, please enter valid bookingid");
		}
			
		}
		
	}
	
	public  static int showSeatingArrangement(List<Movie> movies) throws IOException {
		
		 BufferedReader reader = new BufferedReader(
		            new InputStreamReader(System.in));
		 System.out.println("Please enter date");
		        // Reading data using readLine
		        String date = reader.readLine();
		  System.out.println("Please enter show time");  
		  
		  String time = reader.readLine();
		String seatingArrangement= "";
		int flag  = 0;
		 
		  
		 
		  for(Movie movie : movies) {
			  
			  if(movie.getDate().equals(date)&& movie.getTime().equals(time)) {
				  flag = 1;
				  seatingArrangement = movie.getSeatingArrangement();
				  break;
				  
				  
				  
			  }
			  
			  
			  
			  
			  
		  }
		  
		  if(flag == 1) {
			  System.out.println("seating arrangement is "+seatingArrangement);
			  return 1;
			  
		  }
		  else {
			  
			  System.out.println("no data available for  given time and date");
			  return 0;
		  } 
		  
		  //System.out.println(movies);
	
	}
}
