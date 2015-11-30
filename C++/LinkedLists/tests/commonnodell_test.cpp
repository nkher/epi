#include "../CommonNodeLinkedList.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> h1 = nullptr, h2 = nullptr;

  h1 = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  h1->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {5, nullptr});
  h1->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {10, nullptr});
  h1->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {15, nullptr});
  h1->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {120, nullptr});


  h2 = make_shared<LinkedListNode<int>>(LinkedListNode<int> {2, nullptr});
  h2->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {6, h1->next});

  shared_ptr<LinkedListNode<int>> common_node = find_common_node(h1, h2);

  if (!common_node) cout << "No common node." << endl;
  else cout << "Common node is : " << common_node->data << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 commonnodell_test.cpp -o commonnodell
./commonnodell

*/
