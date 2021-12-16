import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder A = new StringBuilder(br.readLine());
        StringBuilder B = new StringBuilder(br.readLine());

        int[] num = new int[26];

        for(int i=0; i<A.length(); i++){
            num[A.charAt(i)-'A']++;
        }

        for(int i=0; i<A.length(); i++){
            num[B.charAt(i)-'A']--;
        }

        for(int i=0; i<26; i++){
            if(num[i]!=0){
                System.out.println(-1);
                return;
            }
        }

        int result = 0;


        int pos = A.length()-1;
        int curr = pos;
        int cnt = 0;

        while(curr>=0 && pos>=0){
            if(B.charAt(curr) == A.charAt(pos)){
                cnt++;
                curr--;
            }
            pos--;

        }

        System.out.println(A.length()-cnt);

    }

}
