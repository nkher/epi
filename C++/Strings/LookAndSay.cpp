#include <iostream>
#include <string>

using namespace std;

string look_and_say(int);
string look_and_say_helper(const string&);

string look_and_say(int n) {
    string s = "1";
    for (int i=1; i<n; i++) {
      s = look_and_say_helper(s);
    }
    return s;
}

string look_and_say_helper(const string& s) {
    string ret;
    for (int i=0; i<s.size(); i++) {
      int count = 1;
      while ( i+1 < s.size() && s[i] == s[i+1] ) {
        count++;
        i++;
      }
      ret += to_string(count) + s[i];
    }
    return ret;
}
