import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int size = (N-2)*2+1;

        int r = 2*N+size;
        int c = size+2;

        char[][] map = new char[c][r];

        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                map[i][j] = ' ';
            }
        }

        for(int i=0; i<c; i++){
            int x = N-Math.abs(N-1-i)-1;

            if(i==0 || i==c-1) {
                for (int j = x; j < x + N; j++) {
                    map[i][j] = '*';
                }
            }else{
                map[i][x] = '*';
                map[i][x+N-1] = '*';
            }
        }

        for(int i=0; i<c; i++){
            for(int j=0; j<r/2; j++){
                map[i][r-1-j] = map[i][j];
            }
        }


        for(int i=0; i<c; i++){
            for(int j=r-1; j>=0; j--){
                if(map[i][j]=='*') break;

                map[i][j] = '\n';
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                if(map[i][j]=='\n') break;
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }



        System.out.println(sb);

    }

}
