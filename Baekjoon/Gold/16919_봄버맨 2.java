import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        N = (N%8==0)?8:N%8;
        char[][] map = new char[R][C];
        char[][] pre = new char[R][C];

        //초기 맵 입력
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
                pre[i][j] = map[i][j];
            }
        }

        int[] my = {-1,0,0,0,1};
        int[] mx = {0,-1,0,1,0};

        boolean first = true;
        boolean change = false;
        while(N-->0){
            if(first){
                first = false;
                continue;
            }
            if(!change) {
                //맵 저장하면서 폭탄 채움
                for(int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        pre[i][j] = map[i][j];
                        map[i][j] = 'O';
                    }
                }
                change = !change;
                continue;
            }

            //폭탄 터뜨리기
            for(int y=0; y<R; y++){
                for(int x=0; x<C; x++){
                    if(pre[y][x] == 'O'){
                        for(int c=0; c<5; c++){
                            int ny = y+my[c];
                            int nx = x+mx[c];

                            if(ny < 0 || nx < 0 || ny>=R || nx >=C) continue;

                            map[ny][nx] = '.';
                        }
                    }
                }
            }
            change = !change;
        }

        for(char[] line : map){
            for(char c : line){
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
