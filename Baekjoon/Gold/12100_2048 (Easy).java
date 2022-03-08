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

        Queue<int[][]> que = new LinkedList<>();
        que.add(map);
        int cnt = 5;
        while(cnt-->0){
            int size = que.size();
            while(size-->0){
                int[][] curr = que.poll();
                //상하좌우
                int[][] up = up(curr);
                if(!Arrays.deepEquals(curr,up)){
                    que.add(up);
                }
                int[][] down = down(curr);
                if(!Arrays.deepEquals(curr,down)){
                    que.add(down);
                }

                int[][] left = left(curr);
                if(!Arrays.deepEquals(curr,left)){
                    que.add(left);
                }
                int[][] right = right(curr);
                if(!Arrays.deepEquals(curr,right)){
                    que.add(right);
                }
//                System.out.println("curr");
//                for(int[] line : curr){
//                    for(int n : line){
//                        System.out.print(n+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                System.out.println("left");
//                for(int[] line : left){
//                    for(int n : line){
//                        System.out.print(n+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                System.out.println(Arrays.deepEquals(curr,right));
//                System.out.println("right");
//                for(int[] line : right){
//                    for(int n : line){
//                        System.out.print(n+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                System.out.println(Arrays.deepEquals(curr,up));
//                System.out.println("up");
//                for(int[] line : up){
//                    for(int n : line){
//                        System.out.print(n+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                System.out.println("down");
//                for(int[] line : down){
//                    for(int n : line){
//                        System.out.print(n+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }
        }
        System.out.println(result);

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
                    result = Math.max(answer[y][pos-1], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[y][pos] = stack.pop();
                    }
                }else{
                    answer[y][pos] = stack.pop();
                }
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
                    result = Math.max(answer[y][pos+1], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[y][pos] = stack.pop();
                    }
                }else{
                    answer[y][pos] = stack.pop();
                }
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
                    result = Math.max(answer[pos+1][x], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[pos][x] = stack.pop();
                    }
                }else{
                    answer[pos][x] = stack.pop();
                }
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
                    result = Math.max(answer[pos-1][x], result);
                    stack.pop();
                    if(!stack.isEmpty()){
                        answer[pos][x] = stack.pop();
                    }
                }else{
                    answer[pos][x] = stack.pop();
                }
                pos++;
            }
        }

        return answer;
    }
}
