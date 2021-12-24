import java.util.*;
import java.io.*;


public class Main
{

    static int h,w;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = (num!=1)?num:-1;
            }
        }

        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int fr = Integer.parseInt(st.nextToken());
        int fc = Integer.parseInt(st.nextToken());

        map[sr][sc] = 1;

        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {sr,sc});

        int[] my = {-1,1,0,0};
        int[] mx = {0,0,-1,1};

        while(!que.isEmpty()){
            int ea = que.size();

            while(ea-->0) {

                int[] curr = que.poll();

                if (curr[0] == fr && curr[1] == fc) {
                    System.out.println(map[curr[0]][curr[1]] - 1);
                    return;
                }


                out:
                for (int i = 0; i < 4; i++) {
                    int ny = curr[0] + my[i];
                    int nx = curr[1] + mx[i];


                    if (ny < 1 || ny + h - 1 > N || nx < 1 || nx + w - 1 > M) continue;
                    if (map[ny][nx] != 0) continue;

                    switch (i) {
                        case 0://상
                            for (int m = 0; m < w; m++) {
                                if (nx + m > M || map[ny][nx + m] == -1) continue out;
                            }
                            map[ny][nx] = map[curr[0]][curr[1]] + 1;
                            que.add(new int[]{ny, nx});
                            break;
                        case 1://하
                            for (int m = 0; m < w; m++) {
                                if (nx + m > M || map[ny + h - 1][nx + m] == -1) continue out;
                            }
                            map[ny][nx] = map[curr[0]][curr[1]] + 1;
                            que.add(new int[]{ny, nx});
                            break;
                        case 2://좌
                            for (int m = 0; m < h; m++) {
                                if (ny + m > N || map[ny + m][nx] == -1) continue out;
                            }
                            map[ny][nx] = map[curr[0]][curr[1]] + 1;
                            que.add(new int[]{ny, nx});
                            break;
                        case 3://우
                            for (int m = 0; m < h; m++) {
                                if (ny + m > N || map[ny + m][nx + w - 1] == -1) continue out;
                            }
                            map[ny][nx] = map[curr[0]][curr[1]] + 1;
                            que.add(new int[]{ny, nx});
                            break;
                    }

                }
            }
//            for(int i=1; i<=N; i++){
//                for(int j=1; j<=M; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();

        }

        System.out.println("-1");


    }

}
