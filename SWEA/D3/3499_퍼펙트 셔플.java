	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());   //받을 카드 갯수
            List<String> A = new ArrayList<String>(); // 1번째 
            List<String> B = new ArrayList<String>(); //2번째
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mid = (N%2==0)? N/2 : (N/2)+1;                                                    
            for(int i=0; i<N; i++){
                if(i<mid) A.add(st.nextToken());
                else B.add(st.nextToken());
            }
            
            bw.write("#"+test_case+" ");
            
            mid = N/2;
            for(int i=0; i<mid; i++){
                bw.write(A.get(0)+" ");
                A.remove(0);
                bw.write(B.get(0)+" ");
                B.remove(0);
            }
            if(!A.isEmpty()) bw.write(A.get(0));
            bw.newLine();
		}
        bw.flush();
        bw.close();
        br.close();
	}
}
