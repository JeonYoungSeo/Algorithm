#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L ;

    cin >> N >> L ;

    int arr[N];

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    sort(arr, arr+N);

    bool con = false;
    int answer = 0;
    for(int i=0; i<N; i++){
        int cur = i;
        while(i<N && arr[i]-arr[cur]<L){
            i++;
        }
        i--;
        answer++;
    }

    cout << answer << endl;

  
}
