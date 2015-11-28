#include "../ReverseLinkedList.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> head = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  head->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {2, nullptr});
  head->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {3, nullptr});
  head->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {4, nullptr});

  cout << "Before : " << endl;
  print(head);

  shared_ptr<LinkedListNode<int>> res = reverse_list(head);

  cout << "After : " << endl;
  print(res);

  return 0;
}

/*

How to run

g++ -std=c++11 reverselinkedlist_test.cpp -o reverselinkedlist
./reverselinkedlist

*/
