#include <iostream>
#include <string>
#include <vector>
#include <array>

using namespace std;

vector<string> phone_mnemonic(const string&);
void phone_mnemonic_helper(const string&, int, string*, vector<string>*);

const int kNumTelDigits = 10;
const array<string, kNumTelDigits> map = { {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" } };

vector<string> phone_mnemonic(const string& phone_number) {
  string partial_mnemonic(phone_number.size(), 0); // create a string of the same size
  vector<string> mnemonics;
  phone_mnemonic_helper(phone_number, 0, &partial_mnemonic, &mnemonics);
  return mnemonics;
}

void phone_mnemonic_helper(const string& pn, int dig, string* partial_mnemonic, vector<string>* mnemonics) {

  if (dig == pn.size()) {
    mnemonics->emplace_back(*partial_mnemonic);
  }
  else {
      for (const char& c : map[pn[dig] - '0']) {
        (*partial_mnemonic)[dig] = c;
        phone_mnemonic_helper(pn, dig+1, partial_mnemonic, mnemonics);
      }

      // Another way of writing the above loop
      /* int num = pn[dig] - '0';
      string chars = map[num];
      for (const char& c : chars) {
          (*partial_mnemonic)[dig] = c;
          phone_mnemonic_helper(pn, dig+1, partial_mnemonic, mnemonics);
      } */
  }
}
