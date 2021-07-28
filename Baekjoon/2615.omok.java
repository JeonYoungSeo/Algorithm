import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

		int[][] idx = new int[19][19];
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				idx[j][i] = sc.nextInt();
			}
			sc.nextLine();
		}
		
		int[] r_y = {0,1,1,1};
		int[] r_x = {1,0,1,-1};
		
		for(int x=0; x<19; x++) {
			for(int y=0; y<19; y++) {
				if(idx[y][x] == 0) {
					continue;
				}
				int count = 1;
			    for(int z=0; z<4; z++) {
                    if(y+(r_y[z])>18||y+(r_y[z])<0||x+(r_x[z])>18||x+(r_x[z])<0) continue;
			    		for(int i=1; i<=4; i++) {
			    			if(y+(r_y[z]*i)>18||y+(r_y[z]*i)<0||x+(r_x[z]*i)>18||x+(r_x[z]*i)<0){
                                count =1;
                                break;
                            } 
			    			if(idx[y+(r_y[z]*i)][x+(r_x[z]*i)]==idx[y][x]) {
			    				count++;
			    			}else{
                                count=1; 
                                break;
                            }
     		    		}
			    		if(count==5) {
                            //앞뒤 검사
                            if(y-(r_y[z])>18||y-(r_y[z])<0||x-(r_x[z])>18||x-(r_x[z])<0){
                                if(y+(r_y[z]*5)>18||y+(r_y[z]*5)<0||x+(r_x[z]*5)>18||x+(r_x[z]*5)<0){
                                    System.out.println(idx[y][x]);
			    		            System.out.printf("%d %d%n",x+1,y+1);
			    		            return;
                                }
                                if(idx[y+(r_y[z]*5)][x+(r_x[z]*5)]==idx[y][x]){
                                    continue;
                                }else{
                                    System.out.println(idx[y][x]);
        			    		    System.out.printf("%d %d%n",x+1,y+1);
		        	    		    return;
                                }
                            }
                            else{
                                if(idx[y-r_y[z]][x-r_x[z]]==idx[y][x]){
                                    count =1;
                                    continue;
                                }
                                if(y+(r_y[z]*5)>18||y+(r_y[z]*5)<0||x+(r_x[z]*5)>18||x+(r_x[z]*5)<0){
                                    System.out.println(idx[y][x]);
			    		            System.out.printf("%d %d%n",x+1,y+1);
			    		            return;
                                }
                                if(idx[y+(r_y[z]*5)][x+(r_x[z]*5)]==idx[y][x]){
                                    continue;
                                }else{
                                    System.out.println(idx[y][x]);
        			    		    System.out.printf("%d %d%n",x+1,y+1);
		        	    		    return;
                                }
                            }
			    		}else count =1;
			    }
            }
		}
        System.out.println(0);
    }
}
