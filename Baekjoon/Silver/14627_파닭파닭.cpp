#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long S, C;

    cin >> S >> C;

    int arr[S];

    int left = 1;
    int right = 0;
    long long total = 0;
    for(int i=0; i<S; i++){
        cin >> arr[i];
        right = max(right, arr[i]);
        total += arr[i];
    }

    int mid = (left+right)/2;
    while(left<=right){
        int sum = 0;
        for(int i=0; i<S; i++){
            sum += arr[i]/mid;
        }

        if(sum<C){
            right = mid-1;
        }else{
            left = mid+1;
        }

        mid = (left+right)/2;
    }

    cout << total - mid * C << endl;
    
  
}
