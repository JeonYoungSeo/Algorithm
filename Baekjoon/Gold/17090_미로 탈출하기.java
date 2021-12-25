import java.util.*;
import java.io.*;

public class Main
{
    static char[][] map;
    static int N,M;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][M];

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 'O'){
                    result ++;
                    continue;
                }else if(map[i][j] == 'X'){
                    continue;
                }

                if(escape(i,j, visited)=='O'){
                    result ++;
                }
            }
        }

        System.out.println(result);

    }

    private static char escape(int y, int x, boolean[][] visited) {
        if(y<0 || x<0 || y>=N || x>=M){
            return 'O';
        }
        if(visited[y][x]){
            if(map[y][x] == 'O'){
                return 'O';
            }else{
                map[y][x] = 'X';
                return 'X';
            }
        }

        if(map[y][x] == 'O')
            return 'O';
        else if(map[y][x] == 'X')
            return 'X';

        char result = 'X';
        visited[y][x] = true;

        switch (map[y][x]){
            case 'U':
                result = escape(y-1,x,visited);
                break;
            case 'R':
                result = escape(y,x+1,visited);
                break;
            case 'D':
                result = escape(y+1,x,visited);
                break;
            case 'L':
                result = escape(y,x-1,visited);
                break;
        }

        map[y][x] = result;

        return result;
    }

}
