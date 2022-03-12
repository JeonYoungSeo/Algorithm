import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        String[] memo = new String[1001];
        memo[1] = "1";
        memo[2] = "2";

        for(int i=3; i<=1000; i++){
            int len = memo[i-1].length();
            if(memo[i-1].charAt(0)=='1' && memo[i-1].charAt(len-1)=='1'){
                memo[i] = memo[i-2]+"2";
            }else if(memo[i-1].charAt(len-1)=='1'){
                memo[i] = "1"+memo[i-1];
            }else{
                memo[i] = memo[i-1]+"1";
            }
        }


        while(N-->0){
            int num = Integer.parseInt(br.readLine());

            System.out.println(memo[num]);
        }

    }
}
