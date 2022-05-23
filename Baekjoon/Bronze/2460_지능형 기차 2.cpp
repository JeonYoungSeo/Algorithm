#include <iostream>
using namespace std;

int main(){


    int in, out ;

    int answer = 0;
    int people = 0;

    for(int i=0; i<10; i++){
        cin >> out >> in;

        people += in;
        people -= out;

        answer = (answer<people)? people: answer;

    }

    cout << answer << endl;
}
