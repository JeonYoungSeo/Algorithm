#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N,M;

    cin >> N >> M ;

    int arr[N];

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    int left=0, right = 0;
    int answer = 0;
    int sum = 0;
    while(left!=N+1){

        if(sum > M){
            sum -= arr[left++];
        }else if(sum==M){
            answer++;
            sum -= arr[left++];
        }else{
            sum+= arr[right++];
        }


    }

    cout << answer << endl;
    
  
}
