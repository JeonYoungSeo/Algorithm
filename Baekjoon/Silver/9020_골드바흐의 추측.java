import java.io.*;
import java.util.StringTokenizer;


/* 백준 9020 골드바흐의 추측
* 에라토스테네스의 체로 소수를 먼저 구해준뒤 적절한 값을 찾아주었다. 
*/


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];

        for(int i=2; i<=100; i++){
            if(prime[i]) continue;
            int num = i+i;
            while(num<=10000){

                prime[num] = true;
                num += i;
            }
        }


        while(T-->0){
            int n = Integer.parseInt(br.readLine());

            int dif = 0;
            while(true){
                if(!prime[(n/2)+dif] && !prime[(n/2)-dif]){
                    System.out.println(((n/2)-dif)+" "+((n/2)+dif));
                    break;
                }
                dif++;
            }

        }

    }
}
