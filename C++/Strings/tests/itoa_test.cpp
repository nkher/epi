#include <iostream>

#include "../itoa.cpp"

using std::cout;
using std::endl;

int main() {

  int num = 456789035;
  string s = itoa(num);

  cout << s << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 itoa_test.cpp -o itoa
./itoa

*/
