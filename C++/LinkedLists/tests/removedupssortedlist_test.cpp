#include "../RemoveDupsSortedList.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> h1 = nullptr;

  h1 = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  h1->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  h1->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {2, nullptr});
  h1->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {2, nullptr});
  h1->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {3, nullptr});
  h1->next->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {4, nullptr});
  h1->next->next->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {4, nullptr});
  h1->next->next->next->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {5, nullptr});

  print(h1);

  h1 = remove_dups(h1);

  print(h1);

  return 0;
}



/*

How to run

g++ -std=c++11 removedupssortedlist_test.cpp -o removedupssortedlist
./removedupssortedlist

*/
