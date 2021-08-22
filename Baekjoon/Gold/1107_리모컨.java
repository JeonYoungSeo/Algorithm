import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int min_count=Integer.MAX_VALUE;
	static int channel;
	static boolean broken[];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	//원하는 채널
        channel  = Integer.parseInt(br.readLine());
        //고장난 버튼 갯수
        int broke = Integer.parseInt(br.readLine());
        //고장난 버튼 표시
        broken = new boolean[10];
        //고장난 버튼은 true로
        if(broke!=0) { 
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i =0; i<broke; i++) 
        		broken[Integer.parseInt(st.nextToken())] = true;
        }
	 
        if(channel<104 && channel>99) {//해당범위일땐 -하는게 최소값
        	min_count = channel-100;
        }else if(channel>97 && channel <100) {//해당 범위일땐 +하는게 최솟값
        	min_count = 100-channel;
        }else if (broke==10){//버튼을 사용할수 없을때에는 +,-로만 이동해야한다.
        	min_count = (int)Math.abs(channel-100); 
        }
        else {
	    // +,-버튼만 눌럿을때보단 적게 나와야겠지 ? 
	    min_count = (int)Math.abs(channel-100);
	    int channel3;
	    int channel2 = channel3 = channel; // +할대와 -할때 따로 구함
	    String ch2;
	    String ch3;
            int p=0; //+,- 버튼 몇번 눌럿는지
            while(true) {
            	ch2 = Integer.toString(channel2+p);
            	
            	boolean check2= false,check3=true;
		//누를수없는 버튼 하나라도 있으면 넘어가자
            	for(int i=0; i<ch2.length(); i++) {
            		if(broken[ch2.charAt(i)-'0']) 
            			check2 = true;
            	}
            	if(!check2) {
            		min_count = (min_count>ch2.length()+p)?ch2.length()+p:min_count;
            	}
            	
            	if(channel3-p>=0) {
            		check3 = false;
            		ch3 = Integer.toString(channel3-p);
            		for(int i=0; i<ch3.length(); i++) {
                		if(broken[ch3.charAt(i)-'0'])
                			check3 = true;
                	}
            		if(!check3) {
                		min_count = (min_count>ch3.length()+p)?ch3.length()+p:min_count;
                	}
            	}
            	if(!check2 || !check3) break;
            	p++;
            }
        }
        System.out.println(min_count);
        
    }
}
