import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // test case 수

        for (int tc = 1; tc <= T; tc++) {
            char[] people = br.readLine().toCharArray();

            if(people.length == 1) {
                System.out.println("#"+tc+" "+0);
                continue;
            }

            int clapPeople = 0; // 박수친 사람 수
            int res = 0; // 정답
            for (int i = 0; i < people.length; i++) {
                //i번째 i만큼 박수치지 않으면 i만큼 박수치게 관중 추가
                if(people[i] == '0') continue;
                if(clapPeople < i) {
                    res+= i-clapPeople;
                    clapPeople = i;
                }
                clapPeople += people[i]-'0';

            }

            System.out.println("#"+tc+" "+res);
        }
    }
}
