#include "../StringDecompression.cpp"

int main() {

  // string str = "ab3a3k";
  string str = "ab3a3k2uhkl2o2ldegbf3";
  string res = decompress(str);

  cout << res << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 stringdecompression_test.cpp -o stringdecompression
./stringdecompression

*/
