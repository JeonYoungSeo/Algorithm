#include <iostream>
using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, k, m;

    cin >> N >> k >> m;
    if(k>m){
        int tmp = k;
        k = m;
        m = tmp;
    }
    int arr[N+1];

    for(int i=1; i<=N; i++){
        arr[i] = i;
    }

    int answer = 1;
    while(N!=1){
        int num = 1;
        for(int i=1; i<=N; i+=2){
            if(N%2!=0 && i+1==N){
                arr[num++] = arr[i];
            }

            if(arr[i]==k && arr[i+1]==m){
                cout << answer << "\n";
                return 0;
            }else if(arr[i] == m || arr[i+1]==m){
                arr[num++] = m;
            }else if(arr[i] == k || arr[i+1] == k){
                arr[num++] = k;
            }else{
                arr[num++] = arr[i];
            }
        }

        if(N%2==0){
            N/=2;
        }else{
            N = N/2+1;
        }

        answer++;


    }
    
    cout << "-1\n";


}
