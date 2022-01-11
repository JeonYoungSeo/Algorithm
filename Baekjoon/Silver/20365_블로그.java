import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder subResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String color = br.readLine();

        int B = 0, R=0; //블루로 변화 레드로 변화

        for(int i=1; i<N; i++){
            if(color.charAt(i)=='B' && color.charAt(i-1)=='R'){
                B++;
            }else if(color.charAt(i)=='R' && color.charAt(i-1)=='B'){
                R++;
            }
        }

        if(color.charAt(0)=='B'){
            B++;
        }else{
            R++;
        }

        System.out.println(Math.min(B, R)+1);
    }
}
