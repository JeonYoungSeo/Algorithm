import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //0번째는 인원수로 판단, 1번째 이후는 알고있는지 여부
        int[][] party = new int[M+1][N+2];
        boolean[] trueth = new boolean[N+1];
        //진실 아는사람 입력
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int i=0; i<num; i++){
            int n = Integer.parseInt(st.nextToken());
            trueth[n] = true;
        }

        //파티 인원 입력
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            party[i][0] = len;
            for(int j=1; j<=len; j++){
                party[i][j] = Integer.parseInt(st.nextToken());
                if(j!=0 && trueth[party[i][j]]){
                    party[i][0] = 0;
                }
            }
        }

        boolean end = false;

        while(!end){
            end = true;
            for(int i=1; i<=M; i++){
                if(party[i][0]!=0) continue;
                int j=0;
                while(true){
                    j++;
                    if(j>N && party[i][j]==0) break;
                    trueth[party[i][j]] = true;
                }
                party[i][0] = -1;
            }

            for(int i=1; i<=M; i++){
                if(party[i][0]<=0) continue;
                for(int j=1; j<=party[i][0]; j++){
                    if(trueth[party[i][j]]){
                        party[i][0]=0;
                        end = false;
                    }
                }
            }
        }

        int result = 0;

        for(int i=1; i<=M; i++){
            if(party[i][0] > 0){
                result++;
            }
        }

        System.out.println(result);

    }
}
