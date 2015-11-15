#include <iostream>
#include  <vector>

using std::vector;
using std::cout;
using std::endl;

// declarations
int max(int, int);

bool check_if_winnable(vector<int> boardgame) {
	int furthestReach = 0;
	for (int i=0; i<=furthestReach && furthestReach <= boardgame.size(); i++) {
		furthestReach = max(boardgame[i] + i, furthestReach);
	}
	return furthestReach > boardgame.size();
}

int max(int i, int j) {
	if (i > j) {
		return i;
	}
	return j;
}

int main() {

	int a[10] = {3,3,0,0,2,0,1};
	cout << "Length is : " << (sizeof(a)/sizeof(*a)) << endl;

	vector<int> bg1(a, a+8);

	bool res = check_if_winnable(bg1);

	if (res) {
		cout << "Winnable !!" << endl;
	}
	else {
		cout << "Not Winnable !!" << endl;
	}

	return 0;
}
