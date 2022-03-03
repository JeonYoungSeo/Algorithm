import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = ' ';
            }
        }

        star(0,0,N,map);

        StringBuilder result = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result.append(map[i][j]);
            }
            result.append("\n");
        }
        System.out.println(result);

    }

    private static void star(int y, int x, int size, char[][] map) {

        if(size==3){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    map[y+i][x+j] = '*';
                }
            }
            map[y+1][x+1] = ' ';
            return;
        }
        int plus = size/3;
        star(y,x,plus, map);
        star(y+plus,x,plus, map);
        star(y+plus*2,x,plus, map);
        star(y,x+plus,plus, map);
        star(y,x+plus*2,plus, map);
        star(y+plus*2,x+plus,plus, map);
        star(y+plus,x+plus*2,plus, map);
        star(y+plus*2,x+plus*2,plus, map);


    }
}
