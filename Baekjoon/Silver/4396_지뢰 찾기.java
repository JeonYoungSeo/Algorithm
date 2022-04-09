import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = line.charAt(j);
            }
        }

        boolean find = false;
        char[][] com = new char[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                com[i][j] = line.charAt(j);
                if(com[i][j]=='x' && map[i][j]=='*'){
                    find= true;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(com[i][j] == 'x' && map[i][j]=='.'){
                    com[i][j] = find(map,i,j);
                }else if((com[i][j]=='x'||find) && map[i][j]=='*'){
                    com[i][j] = '*';
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                answer.append(com[i][j]);
            }
            answer.append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
    }
    static int[] my = {-1,-1,-1,0,0,1,1,1};
    static int[] mx = {-1,0,1,-1,1,-1,0,1};

    private static char find(char[][] map, int y, int x) {
        int result =0 ;

        for(int i=0; i<8; i++){
            int ny = y+my[i];
            int nx = x+mx[i];

            if(ny<0 || nx<0 || ny>=n || nx>=n) continue;

            if(map[ny][nx] == '*')
                result++;
        }

        return (char)('0'+result);
    }
}
