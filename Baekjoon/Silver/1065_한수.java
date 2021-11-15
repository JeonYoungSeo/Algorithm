import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i=1; i<=N; i++){
            if(i<100){
                result ++;
                continue;
            }
            if(i<1000){
              //1,2번째자리의 차와 2,3번째 자리의차 가 같다면 등차
                if((i/100-(i%100/10))==((i%100/10)-i%10)){
                    result++;
                }
            }
        }

        System.out.println(result);


    }
}
