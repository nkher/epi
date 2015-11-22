#include "../StringCompression.cpp"

int main() {

  string res = "aabbbaaakkuhkllooldegbfff";

  cout << run_length_encoding(res) << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 stringcompression_test.cpp -o stringcompression
./stringcompression

*/
