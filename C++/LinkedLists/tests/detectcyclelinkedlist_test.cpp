#include "../DetectCycleLinkedList.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> head = nullptr;

  head = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  head->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {5, nullptr});
  head->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {10, nullptr});
  head->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {7, nullptr});
  head->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {3, nullptr});
  head->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {20, head->next->next});

  shared_ptr<LinkedListNode<int>> res = detect_cycle(head);

  if (!res) {
    cout << "No Cycle in linked list" << endl;
  }
  else {
    cout << "Cycle has a linked list at : " << res->data << endl;
  }

  return 0;
}

/*

How to run

g++ -std=c++11 detectcyclelinkedlist_test.cpp -o detectcyclelinkedlist
./detectcyclelinkedlist

*/
