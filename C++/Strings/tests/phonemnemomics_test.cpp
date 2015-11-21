#include <iostream>
#include "../PhoneMnemonic.cpp"

int main() {

  string pn = "45789";
  vector<string> vec = phone_mnemonic(pn);

  for (int i=0; i<vec.size(); i++) {
    cout << vec[i] << " ";
  }

  cout << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 phonemnemomics_test.cpp -o phonemnemomics
./phonemnemomics

*/
