import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
	    Date today = new Date();
	    
	    SimpleDateFormat year = new SimpleDateFormat("yyyy");
	    SimpleDateFormat month = new SimpleDateFormat("MM");
	    SimpleDateFormat day = new SimpleDateFormat("dd");
    	
    	System.out.println(year.format(today));
    	System.out.println(month.format(today));
    	System.out.println(day.format(today));
   	}
}
