import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N*2];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<2*N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }


        //로봇의 위치 표시
        boolean[] robot = new boolean[2*N];

        int result = 1;
        int broken = 0;
        while(true){
            //한칸씩 회전
            int temp = belt[2*N-1];
            boolean temp2 = robot[2*N-1];

            for(int i=2*N-1; i>=1; i--){
                belt[i] = belt[i-1];
                robot[i] = robot[i-1];
            }
            belt[0] = temp;
            robot[0] = temp2;
            robot[N-1] = false;

            //2 로봇 이동

            for(int i=2*N-1; i>=1; i--){
                if(!robot[i] && robot[i-1] && belt[i] != 0){
                    robot[i] = true;
                    robot[i-1] = false;
                    belt[i]--;
                    if(belt[i]==0) broken++;
                }
            }

            if(!robot[0] && robot[2*N-1] && belt[0] != 0){
                robot[0] = true;
                robot[2*N-1] = false;
                belt[0]--;
                if(belt[0]==0) broken++;
            }
            robot[N-1] = false;

            //3. 로봇 탑승
            if(!robot[0] && belt[0]!=0){
                belt[0]--;
                if(belt[0]==0) broken++;
                robot[0] = true;
            }


            //4. 종료 or 반복

            if(broken>=K) break;

            result++;
        }

        System.out.println(result);

    }
}
