#include "../ReverseSubList.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> head = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  head->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {2, nullptr});
  head->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {3, nullptr});
  head->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {4, nullptr});
  head->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {5, nullptr});

  cout << "Before :  ";
  print(head);
  cout << endl;
  reverse_sublist(head, 1, 3);
  cout << "After :  ";
  print(head);
  cout << endl;
  
  return 0;
}

/*

How to run

g++ -std=c++11 reversesublist_test.cpp -o reversesublist
./reversesublist

*/
