#include <iostream>
using namespace std;

const int si = 51;
int N ;
void cnt(int num, char arr[], bool (&check)[si]);
int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N = 0;
    cin >> N ;

    bool Is[1000001];

    int arr[N];

    for(int i=0; i<N; i++){
        int n = 0;
        cin >> n;

        Is[n] = true;
        arr[i] = n;
    }

    int answer = 0;

    for(int i=0; i<=1000000; i++){
        if(!Is[i]) continue;

        int pre = -1;
        int size = 1;
        for(int j=0; j<N; j++){
            if(arr[j] == i) continue;

            if(pre == arr[j]){
                size ++;
            }else{
                size = 1;
            }

            pre = arr[j];
            answer = (answer>size)? answer : size;
        }
    }

    cout << answer << endl;
  
}
