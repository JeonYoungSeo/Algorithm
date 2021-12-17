import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[10];

        String str = br.readLine();

        for(int i=0; i<str.length(); i++){
            cnt[str.charAt(i)-'0']++;
        }

        cnt[6] += cnt[9];
        cnt[9] = 0;
        cnt[6] = (cnt[6] %2 == 0)?cnt[6]/2:cnt[6]/2+1;

        int result = 0;

        for(int i=0; i<9; i++){
            result = Math.max(result, cnt[i]);
        }


        System.out.println(result);
    }
}
