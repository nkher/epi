#include "../ValidIpAdd.cpp"

int main() {

  string str = "19216811";

  vector<string> vec = get_valid_ipadd(str);

  for (int i=0; i<vec.size(); i++) {
      cout << vec[i] + " " << endl;
  }

  return 0;
}

/*

How to run

g++ -std=c++11 validipadd_test.cpp -o validipadd
./validipadd

*/
