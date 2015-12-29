#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <string>

using namespace std;

vector<vector<string>> find_anagrams(const vector<string>& dictionary) {

  vector<vector<string>> result;
  unordered_map<string, vector<string>> map;
  for(const string& str : dictionary) {
    string x(str);
    sort(x.begin(), x.end());
    map[x].emplace_back(str);
  }

  // filling the result
  for (const pair<string, vector<string>>& p : map) {
    if (p.second.size() >= 2) {
      result.emplace_back(p.second);
    }
  }
  return result;
}

// test
int main() {

  vector<string> dictionary = {"debit card", "bad credit", "the morse code",
  "here come dots", "the eyes", "they see", "THL"};

  vector<vector<string>> result = find_anagrams(dictionary);

  for (vector<string>& v : result) {
    for (string& s : v) {
      cout << s << ", ";
    }
    cout << endl;
  }

  return 0;
}


/*

How to run
-------------
g++ -std=c++11 FindAnagrams.cpp -o findanagrams
./findanagrams

*/
