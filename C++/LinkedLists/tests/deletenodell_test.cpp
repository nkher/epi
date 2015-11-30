#include "../DeleteNodeLL.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> h1 = nullptr;

  h1 = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  h1->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {5, nullptr});
  h1->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {10, nullptr});
  h1->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {15, nullptr});
  h1->next->next->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {120, nullptr});

  print(h1);

  // shared_ptr<LinkedListNode<int>>* to_del = &h1;
  bool res = delete_node_alternate(h1->next->next);

  if (res)
    cout << "Node deleted." << endl;
  else
    cout << "Node not deleted." << endl;

  print(h1);

  return 0;
}




/*

How to run

g++ -std=c++11 deletenodell_test.cpp -o deletenodell
./deletenodell

*/
