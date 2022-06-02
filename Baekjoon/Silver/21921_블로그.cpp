#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, X;

    cin >> N >> X;

    int arr[N];

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    int sum = 0;
    int answer = 0;
    int size = 0;
    int ctn = 0;
    for(int i=0; i<N; i++){
        if(size != X){
            size++;
            sum += arr[i];
        }else{
            sum += arr[i];
            sum -= arr[i-X];
        }
        
        if(answer == sum){
            ctn++;
        }else if(answer < sum){
            ctn = 1;
        }
        answer = (answer<sum)? sum : answer;
    }

    if(answer == 0){
        cout << "SAD" << endl;
    }else{
        cout << answer << endl;
        cout << ctn << endl;
    }
    
}
