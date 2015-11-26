#include "../IndexOf.cpp"

int main() {

  string text = "GEEKS FOR GEEKS";
  string pat = "GEEKS";

  index_of(text, pat);

  return 0;
}


/*

How to run

g++ -std=c++11 indexof_test.cpp -o indexof
./indexof

*/
