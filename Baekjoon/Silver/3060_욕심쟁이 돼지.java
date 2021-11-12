import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        out : while(T-->0){
            long N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] pig = new long[6];
            for(int i=0; i<6; i++){
                pig[i] = Long.parseLong(st.nextToken());
            }

            long feed = 0;
            int day = 1;

            while(true){
                feed+=N;

                for(int i=0; i<6; i++){
                    feed-=pig[i];
                }

                if(feed<0){
                    System.out.println(day);
                    continue out;
                }

                day++;
                long[] temp = new long[6];
                for(int i=0; i<6; i++){
                    temp[i] = pig[(i+1)%6]+pig[(i+5)%6]+pig[(i+3)%6]+pig[i];
                }

                for(int i=0; i<6; i++){
                    pig[i] = temp[i];
                }
                feed = 0;
            }

        }


    }
}
