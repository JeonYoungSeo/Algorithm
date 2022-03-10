import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static boolean visited[];
    static int N;
    static int[] order;
    static int[][] point;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        point = new int[N][10];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=1; j<=9; j++){
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[10];
        order = new int[9];
        order[3] = 1;
        visited[1] = true;

        int result = permu(0);

        System.out.print(result);

    }

    private static int permu(int cnt) {
        if(cnt==3){
            return permu(cnt+1);
        }
        if(cnt==9){
            //계산함수 호출
            return cal_val();
        }
        int result = 0;
        for(int i=1; i<=9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            order[cnt] = i;
            result = Math.max(result,permu(cnt+1));
            visited[i] = false;
        }
        return result;
    }

    private static int cal_val() {

        int inning = 0;
        int num = 0;
        int result = 0;
        int[] roo = new int[5];
        int out = 0;
        while(inning != N){
            switch (point[inning][order[num++]]){
                case 0:
                    out++;
                    break;
                case 1:
                    roo[4] = roo[3];
                    roo[3] = roo[2];
                    roo[2] = roo[1];
                    roo[1] = 1;
                    break;
                case 2:
                    roo[4] = roo[3];
                    roo[4] += roo[2];
                    roo[3] = roo[1];
                    roo[2] = 1;
                    roo[1] = 0;
                    break;
                case 3:
                    roo[4] = roo[3];
                    roo[4] += roo[2];
                    roo[4] += roo[1];
                    roo[3] = 1;
                    roo[2] = 0;
                    roo[1] = 0;
                    break;
                case 4:
                    roo[4] = roo[3]+roo[2]+roo[1]+1;
                    roo[3] = roo[2] = roo[1] = 0;
                    break;
            }
            result += roo[4];
            roo[4] = 0;
            if(num==9){
                num=0;
            }
            if(out==3){
                out=0;
                inning++;
                roo[1] = roo[2] = roo[3] = 0;
            }
        }
        return result;
    }
}
