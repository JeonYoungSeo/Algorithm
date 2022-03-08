import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        result = 0;
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                result = Math.max(result, map[i][j]);
            }
        }
        move(10,map);

        System.out.println(result);

    }
    static int max;
    private static void move(int cnt, int[][] map) {
        if(cnt==0){
            return ;
        }

        max=0;
        int[][] temp = up(map);
        if(!Arrays.deepEquals(map,temp) && result< max*Math.pow(2,cnt-1))
            move(cnt-1, temp);

        max=0;
        temp = down(map);
        if(!Arrays.deepEquals(map,temp) && result< max*Math.pow(2,cnt-1))
            move(cnt-1, temp);

        max=0;
        temp = left(map);
        if(!Arrays.deepEquals(map,temp) && result< max*Math.pow(2,cnt-1))
           move(cnt-1, temp);

        max=0;
        temp = right(map);
        if(!Arrays.deepEquals(map,temp) && result< max*Math.pow(2,cnt-1))
           move(cnt-1, temp);

    }

    private static int[][] left(int[][] curr) {
        int[][] answer = new int[N][N];

        for(int y=0;y<N; y++) {
            Stack<Integer> stack = new Stack<>();
            for (int x = N - 1; x >= 0; x--) {
                if(curr[y][x] == 0) continue;

                stack.add(curr[y][x]);
            }

            int pos = 1;
            if(!stack.isEmpty()) answer[y][0]=stack.pop();
            while(!stack.isEmpty()){
                if(answer[y][pos-1] == stack.peek()){
                    answer[y][pos-1] *= 2;
                    max = Math.max(answer[y][pos-1], max);
                    result = Math.max(answer[y][pos-1], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[y][pos] = stack.pop();
                    }
                }else{
                    answer[y][pos] = stack.pop();
                }
                max = Math.max(answer[y][pos], max);
                pos++;
            }
        }

        return answer;
    }

    private static int[][] right(int[][] curr) {
        int[][] answer = new int[N][N];

        for(int y=0; y<N; y++) {
            Stack<Integer> stack = new Stack<>();
            for (int x = 0; x < N; x++) {
                if(curr[y][x] == 0) continue;

                stack.add(curr[y][x]);
            }

            int pos = N-2;
            if(!stack.isEmpty()) answer[y][N-1]=stack.pop();
            while(!stack.isEmpty()){
                if(answer[y][pos+1] == stack.peek()){
                    answer[y][pos+1] *= 2;
                    max = Math.max(answer[y][pos+1], max);
                    result = Math.max(answer[y][pos+1], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[y][pos] = stack.pop();
                    }
                }else{
                    answer[y][pos] = stack.pop();
                }
                max = Math.max(answer[y][pos], max);
                pos--;
            }
        }

        return answer;
    }

    private static int[][] down(int[][] curr) {
        int[][] answer = new int[N][N];

        for(int x=0; x<N; x++) {
            Stack<Integer> stack = new Stack<>();
            for (int y = 0; y < N; y++) {
                if(curr[y][x] == 0) continue;

                stack.add(curr[y][x]);
            }

            int pos = N-2;
            if(!stack.isEmpty()) answer[N-1][x]=stack.pop();
            while(!stack.isEmpty()){
                if(answer[pos+1][x] == stack.peek()){
                    answer[pos+1][x] *= 2;
                    max = Math.max(max, answer[pos+1][x]);
                    result = Math.max(answer[pos+1][x], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[pos][x] = stack.pop();
                    }
                }else{
                    answer[pos][x] = stack.pop();
                }
                max = Math.max(max, answer[pos][x]);
                pos--;
            }
        }

        return answer;
    }

    private static int[][] up(int[][] curr) {
        int[][] answer = new int[N][N];

        for(int x=0; x<N; x++) {
            Stack<Integer> stack = new Stack<>();
            for (int y = N - 1; y >= 0; y--) {
                if(curr[y][x] == 0) continue;

                stack.add(curr[y][x]);
            }

            int pos = 1;
            if(!stack.isEmpty()) answer[0][x]=stack.pop();
            while(!stack.isEmpty()){
                if(answer[pos-1][x] == stack.peek()){
                    answer[pos-1][x] *= 2;
                    max = Math.max(max, answer[pos-1][x]);
                    result = Math.max(answer[pos-1][x], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[pos][x] = stack.pop();
                    }
                }else{
                    answer[pos][x] = stack.pop();
                }
                max = Math.max(max, answer[pos][x]);
                pos++;
            }
        }

        return answer;
    }
}
