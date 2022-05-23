#include <iostream>
using namespace std;

int main(){

    int n, size;
    
    cin >> n;

    int arr[n];

    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    cin >> size;

    long answer = 0;

    for(int i=0; i<n; i++){

        answer += arr[i]/size;
        if(arr[i]% size!=0){
            answer += 1;
        }
    }

    cout << answer*size << endl;

}
