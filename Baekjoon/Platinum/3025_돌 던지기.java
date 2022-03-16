import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[m][n];

        Stack<int[]> stack[] = new Stack[n];
        for(int i=0; i<n; i++){
            stack[i] = new Stack<>();
            stack[i].add(new int[] {m-1, i});
        }
        for(int i=m-1; i>=0; i--){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            int pos = Integer.parseInt(br.readLine())-1;
            int[] tmp = stack[pos].peek();
            int y = tmp[0];
            int x = tmp[1];
            while (!stack[pos].isEmpty() && map[y][x] !='.'){
                stack[pos].pop();
                tmp = stack[pos].peek();
                y = tmp[0];
                x = tmp[1];
            }
            while(true) {
                while (y >= 1 && map[y - 1][x] == '.') {
                    y--;
                    stack[pos].add(new int[]{y, x});
                }

                if (y == 0 || map[y - 1][x] == 'X') {
                    map[y][x] = 'O';
                    break;
                }

                if(x-1>=0 && map[y][x-1] == '.' && map[y-1][x-1]=='.'){
                    x--;
                    y--;
                    stack[pos].add(new int[] {y,x});
                    continue;
                }

                if(x+1<n && map[y][x+1] == '.' && map[y-1][x+1]=='.'){
                    x++;
                    y--;
                    stack[pos].add(new int[] {y,x});
                    continue;
                }

                map[y][x] = 'O';
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=m-1; i>=0; i--){
            for(int j=0; j<n; j++){
                result.append(map[i][j]);
            }
            result.append("\n");
        }

        System.out.println(result);


    }
}
