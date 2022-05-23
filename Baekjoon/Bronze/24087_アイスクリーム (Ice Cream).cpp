#include <iostream>
using namespace std;

int main(){

    int S,A,B;

    cin >> S;
    cin >> A;
    cin >> B;

    int answer = 250;

    while(S>A){
        answer += 100;
        A += B;
    }

    cout << answer;

}
