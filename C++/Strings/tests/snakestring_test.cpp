#include "../SnakeString.cpp"

int main() {

  string str = "Hello World !";

  char** res = snake_string(str);

  int n = str.size();

  for (int i=0; i<3; i++) {
    for (int j=0; j<n; j++) {
      cout << res[i][j] << " ";
    }
    cout << endl;
  }

  cout << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 snakestring_test.cpp -o snakestring
./snakestring

*/
