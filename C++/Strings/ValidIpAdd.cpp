#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* Declarations */
bool is_valid_ip(const string&);
vector<string> get_valid_ipadd(const string&);

vector<string> get_valid_ipadd(const string& str) {

  vector<string> result;
  for (size_t i=1; i<4 && i<str.size(); i++) {
    auto first = str.substr(0, i);

    if (is_valid_ip(first)) {
      for (size_t j=1; j<4 && i+j<str.size(); j++) {
        auto second = str.substr(i, j);

        if (is_valid_ip(second)) {
          for (size_t k=1; k<4 && i+j+k<str.size(); k++) {
            auto third = str.substr(i+j, k);
            auto fourth = str.substr(i+j+k);
            if (is_valid_ip(third) && is_valid_ip(fourth)) {
              result.emplace_back(first + "." + second + "." + third + "." + fourth);
            }
          }
        }
      }
    }
  }

  return result;
}

bool is_valid_ip(const string& str) {
  if (str.size() > 3) return false;

  if (str.front() == '0' && str.size() > 1) {
    return false;
  }

  int number = stoi(str);
  return (number >= 0 && number <= 255);
}
