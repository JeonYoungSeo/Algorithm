import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int size = 4*(N-1)+1;

        map = new char[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                map[i][j] = ' ';
            }
        }
        sqr(0,0,size);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void sqr(int y, int x, int size) {
        if(size<0) return;

        int cnt = size;
        while(cnt-->0){
            map[y+cnt][x+size-1] = '*'; //우
            map[y+size-1][x+cnt] = '*'; //하
            map[y][x+cnt] = '*'; //상
            map[y+cnt][x] = '*'; //좌
        }

        sqr(y+2,x+2, size-4);


        return;
    }

}
