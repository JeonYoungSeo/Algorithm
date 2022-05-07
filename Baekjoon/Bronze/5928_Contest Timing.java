import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Calendar date = Calendar.getInstance();
        date.set(2011,11,11,11,11);
        Calendar date2 = Calendar.getInstance();
        date2.set(2011,11,A,B,C);

        long diff = (date2.getTimeInMillis()-date.getTimeInMillis())/1000/60;

        if(diff<0){
            System.out.println(-1);
        }else {
            System.out.println(diff);
        }


    }
}
