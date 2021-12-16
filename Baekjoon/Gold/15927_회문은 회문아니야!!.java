import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();
        int[] cnt = new int[26];
        for(int i=0; i<=len/2; i++){
            if(str.charAt(i) != str.charAt(len-1-i)){
                System.out.println(len);
                return;
            }

            cnt[str.charAt(i)-'A']++;
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(cnt[i]!=0) count++;
        }

        if(count==1){
            System.out.println(-1);
        }else{
            System.out.println(len-1);
        }
    }

}
