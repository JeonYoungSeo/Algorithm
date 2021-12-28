import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        //나이트의 움직임
        int[] my = {-1,-2,-2,-1,1,2,2,1};
        int[] mx = {-2,-1,1,2,-2,-1,1,2};
        out :
        while(T-->0){
            int l = Integer.parseInt(br.readLine());
            int[][] map = new int[l][l];
            boolean[][] visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            Queue<int[]> que = new LinkedList<>();

            que.add(new int[] {sy,sx});

            int result = 0;

            while(!que.isEmpty()){
                int size = que.size();

                while(size-->0){
                    int[] curr = que.poll();

                    if(curr[0] == ey && curr[1] == ex){
                        System.out.println(result);
                        continue out;
                    }

                    for(int i=0; i<8; i++){
                        int y = curr[0] + my[i];
                        int x = curr[1] + mx[i];

                        if(y < 0 || x<0 || y>=l || x>=l) continue ;

                        if(!visited[y][x]) {
                            visited[y][x] = true;
                            que.add(new int[]{y, x});
                        }
                    }
                }
                result ++;
            }
        }

    }
}
