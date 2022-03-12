import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int house = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Math.abs(house-n)+1;
        long[][] map = new long[h][h];

        for(int i=0; i<h; i++){
            if(i==0){
                for(int j=0; j<h; j++){
                    map[i][j] = 1;
                }
                continue;
            }
            for(int j=0; j<h; j++){
                if(i>j) continue;

                map[i][j] = map[i-1][j]+map[i][j-1];
            }

        }

        System.out.println(map[h-1][h-1]);

    }
}
