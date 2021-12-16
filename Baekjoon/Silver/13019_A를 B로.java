import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //A랑 B입력
        StringBuilder A = new StringBuilder(br.readLine());
        StringBuilder B = new StringBuilder(br.readLine());
        //알파벳 순서대로 갯수 세주기
        int[] num = new int[26];
        //A알파벳 갯수는 증가로 표시
        for(int i=0; i<A.length(); i++){
            num[A.charAt(i)-'A']++;
        }
           //B알파벳은 갯수를 --해줌
        for(int i=0; i<A.length(); i++){
            num[B.charAt(i)-'A']--;
        }
        //갯수가 같으면 0
        for(int i=0; i<26; i++){
            if(num[i]!=0){ //0이 아닌거 나오면 만들수 없음
                System.out.println(-1);
                return;
            }
        }
        //정답
        int result = 0;

        int pos = A.length()-1; //A의 위치
        int curr = pos; //B의 위치
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
