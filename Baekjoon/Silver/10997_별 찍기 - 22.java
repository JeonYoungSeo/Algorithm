import java.io.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.println('*');
            return;
        }

        int Xsize = 4*(N-1)+1;
        int Ysize = 4*(N-1)+3;

        map = new char[Ysize][Xsize];
        for(int i=0; i<Ysize; i++){
            for(int j=0; j<Xsize; j++){
                map[i][j] = ' ';
            }
        }

        int y = 0;
        int x = Xsize-1;
        int size = Xsize+1;
        int size2 = Ysize-1;
        map[y][x] = '*';

        while(size>1){
            for(int i=1; i<=size; i++){
                x--;
                if(x<0){
                    x=0;
                    break;
                }
                map[y][x] = '*';
            }
            size-=2;
            for(int i=1; i<=size2; i++){
                y++;
                map[y][x] = '*';
            }
            size2-=2;

            for(int i=1; i<=size; i++){
                x++;
                map[y][x] = '*';
            }
            size-=2;
            for(int i=1; i<=size2; i++){
                y--;
                map[y][x] = '*';
            }
            size2-=2;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Ysize; i++){
            for(int j=0; j<Xsize; j++){
                if(i==1 && j==1){
                    break;
                }
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
