#include "../CyclicRightShiftLL.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> h1 = nullptr;

  h1 = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  h1->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {5, nullptr});
  h1->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {10, nullptr});
  h1->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {15, nullptr});
  h1->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {20, nullptr});
  h1->next->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {25, nullptr});
  h1->next->next->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {2, nullptr});
  h1->next->next->next->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {7, nullptr});

  cout << "Before : ";
  print(h1);

  shared_ptr<LinkedListNode<int>> res = cyclic_right_shift(h1, 3);

  cout << "After : ";
  print(res);

  return 0;
}

/*

How to run

g++ -std=c++11 cyclicrightshiftll_test.cpp -o cyclicrightshiftll
./cyclicrightshiftll

*/
