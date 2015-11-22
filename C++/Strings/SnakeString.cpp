#include <iostream>
#include <string>

using namespace std;

char** snake_string(const string& str) {

  size_t n = str.size();

  /* Creating a 3 * n -- 2D array */
  char** res = new char*[3];

  for (int j=0; j<3; j++) {
    res[j] = new char[n];
  }
  /* Creating a 3 * n -- 2D array */

  for (int i=1; i<n; i=i+4) {
    res[0][i] = str[i];
  }

  for(int i=0; i<n; i=i+2) {
    res[1][i] = str[i];
  }

  for (int i=3; i<n; i=i+4) {
    res[2][i] = str[i];
  }

  return res;
}
