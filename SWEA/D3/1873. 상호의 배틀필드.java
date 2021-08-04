import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());  
            char[][] field = new char[H][W];
            int cur_x = 0;
            int cur_y = 0 ;
            for(int i=0; i<H; i++){
                String line = br.readLine();
                for(int j=0; j<W; j++){
                    field[i][j] = line.charAt(j);
                    if(field[i][j] == '<' || field[i][j] == '>' || field[i][j] == '^' || field[i][j] == 'v'){
                        cur_x = j;
                        cur_y = i;
                    }
                }
            }
            
            int c_count= Integer.parseInt(br.readLine());
            String command = br.readLine();
            
            int count = 0 ;
            int[] move_x = {0,0,-1,1};
            int[] move_y = {-1,1,0,0};
            char[] tank = {'^', 'v','<','>'};
            
            while(count<c_count){
                int direc = 4;                
                if(command.charAt(count) =='U') direc = 0;
                else if(command.charAt(count) =='D') direc = 1;
                else if(command.charAt(count) =='L') direc = 2;
                else if(command.charAt(count) =='R') direc = 3;
                
                if(direc<4){
                    field[cur_y][cur_x] = tank[direc];
                    if(cur_y+move_y[direc]>=0 && cur_y+move_y[direc]<H && cur_x+move_x[direc]>=0 && cur_x+move_x[direc]<W && field[cur_y+move_y[direc]][cur_x+move_x[direc]] == '.'){
                        field[cur_y][cur_x] = '.';
                        cur_y += move_y[direc];
                        cur_x += move_x[direc];
                        field[cur_y][cur_x] = tank[direc];
                    }
                }else {
                    if(field[cur_y][cur_x] =='^') direc = 0;
                    else if(field[cur_y][cur_x] =='v') direc = 1;
                    else if(field[cur_y][cur_x] =='<') direc = 2;
                    else if(field[cur_y][cur_x] =='>') direc = 3;
                    
                    int shoot_x = cur_x;
                    int shoot_y = cur_y;
                    while(shoot_y+move_y[direc]>=0 && shoot_y+move_y[direc]<H && shoot_x+move_x[direc]>=0 && shoot_x+move_x[direc]<W){
                        shoot_y += move_y[direc];
                        shoot_x += move_x[direc];
                        
                        if(field[shoot_y][shoot_x] == '#') break;
                        if(field[shoot_y][shoot_x] == '*'){
                            field[shoot_y][shoot_x] = '.';
                            break;
                        }
                    }
                }
                count ++;
            }
            bw.write("#"+test_case+" ");
            for(char[] fields : field){
                for(char thing : fields){
                    bw.write(thing);
                }
                bw.newLine();
            }
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
