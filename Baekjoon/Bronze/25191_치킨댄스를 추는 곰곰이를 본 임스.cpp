#include <iostream>
#include <algorithm>
using namespace std;

int main(){

    int chicken, beer, cola;

    cin >> chicken;

    cin >> cola >> beer;

    int answer = 0;

    answer = min(chicken, cola/2 + beer);

    cout << answer << endl;


}
