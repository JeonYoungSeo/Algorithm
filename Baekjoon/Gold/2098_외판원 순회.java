import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] cost;
    static int[][] min;
    static int N,size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = 0;
        for(int i=0; i<N; i++){
            size += 1 << i;
        }
        min = new int[size+1][N];
        cost = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
                if(i==j) cost[i][j] = 0;
            }
        }
        int result = tsp(0, 0,  1); //cost, 출발도시, 방문한 도시

        System.out.println(result);
    }

    private static int tsp(int value, int city, int visit) {

        if(size == visit){
            if(cost[city][0]==0){
                return 987654321;
            }
            return value+cost[city][0];
        }
        if(min[visit][city]!=0){
            return value+min[visit][city];
        }
        int result = 987654321;

        for(int i=0; i<N; i++){
            if((visit & 1<<i)>0 || cost[city][i]==0) continue;
            int temp = tsp(value+cost[city][i],i,visit+(1<<i));
            result = Math.min(result, temp);
        }
        min[visit][city] = result-value;
        return result;
    }
}
