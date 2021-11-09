import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static int[][] sdoku, result;
    static boolean[][] sero,garo;
    static boolean[][] square;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //스도쿠 배열과 각각의 경우 방문 배열
        sdoku = new int[10][10];
        sero = new boolean[10][10];
        garo = new boolean[10][10];
        square = new boolean[10][10];
        for(int i=1; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++) {
                //값 넣어주고
                sdoku[i][j] = Integer.parseInt(st.nextToken());
                if(sdoku[i][j]==0) continue;
                garo[i][sdoku[i][j]] = true;
                sero[j][sdoku[i][j]] = true;
                square[((i-1)/3)*3+((j-1)/3)+1][sdoku[i][j]] = true;
            }
        }
        //1,1부터 시작
        make(1,1);

        for(int i=1; i<10; i++) {
            for(int j=1; j<10; j++) {
                bw.write(sdoku[i][j]+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean make(int y, int x) {
        //0인 곳 찾아간다, 다만 끝까지 갓을경우 check를 true로 만들고 끝낸다.
        while(sdoku[y][x]!=0) {
            x++;
            if(x==10) {
                x=1;
                y++;
                if(y>9) {
                    //끝까지 왓는지 검사
                    return true;
                }
            }
        }

        boolean check = false;

        for(int i=1; i<=9; i++) {
            //이미 쓴 숫자면 pass
            if(garo[y][i] || sero[x][i] || square[((y-1)/3)*3+((x-1)/3)+1][i]) continue;
            //방문 체크 후 다음 칸 정하러 간다.
            sdoku[y][x] = i;
            garo[y][i] = true;
            sero[x][i] = true;
            square[((y-1)/3)*3+((x-1)/3)+1][i] = true;
            check = make(y,x);
            //완성됬을경우 그냥 끝냄
            if(check) return check;
            //방문해제
            garo[y][i] = false;
            sero[x][i] = false;
            square[((y-1)/3)*3+((x-1)/3)+1][i] = false;
            sdoku[y][x] = 0;
        }
        return check;
    }
}
