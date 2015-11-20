#include <iostream>

#include "../stoi.cpp"

int main() {

  string s = "987654567";
  int num = string_to_int(s);

  cout << num+2 << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 stoi_test.cpp -o stoi
./stoi

*/
