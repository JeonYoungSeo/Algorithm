import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static double[][] cost;
    static double[][] min;
    static int N,size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = 0;
        for(int i=0; i<N; i++){
            size += 1 << i;
        }
        min = new double[size+1][N];
        cost = new double[N][N];
        double[][] dist = new double[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            dist[i][0] =Double.parseDouble(st.nextToken());
            dist[i][1] =Double.parseDouble(st.nextToken());

        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j) continue;
                double x = Math.abs(dist[i][0]-dist[j][0]);
                double y = Math.abs(dist[i][1]-dist[j][1]);
                double temp = Math.sqrt(x*x+y*y);
                cost[i][j] = temp;
                cost[j][i] = temp;
            }
        }
        double result = tsp(0, 0,  1); //cost, 출발도시, 방문한 도시

        System.out.println(result);
    }

    private static double tsp(double value, int city, int visit) {

        if(size == visit){
            if(cost[city][0]==0){
                return 987654321;
            }
            return value+cost[city][0];
        }
        if(min[visit][city]!=0){
            return value+min[visit][city];
        }
        double result = 987654321;

        for(int i=0; i<N; i++){
            if((visit & 1<<i)>0 || cost[city][i]==0) continue;
            double temp = tsp(value+cost[city][i],i,visit+(1<<i));
            result = Math.min(result, temp);
        }
        min[visit][city] = result-value;
        return result;
    }
}
