#include <iostream>

#include "../ReplaceAndRemove.cpp"

int main() {

  string str = "aybbac";
  string s = replace_and_remove(str);

  cout << s << endl;

  return 0;
}


/*

How to run

g++ -std=c++11 replaceandremove_test.cpp -o replace_and_remove
./replace_and_remove

*/
