#include "../MergeSortedLists.cpp"

int main() {

  shared_ptr<LinkedListNode<int>> h1 = nullptr, h2 = nullptr;

  h1 = make_shared<LinkedListNode<int>>(LinkedListNode<int> {1, nullptr});
  h1->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {5, nullptr});
  h1->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {10, nullptr});


  h2 = make_shared<LinkedListNode<int>>(LinkedListNode<int> {2, nullptr});
  h2->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {6, nullptr});
  h2->next->next = make_shared<LinkedListNode<int>>(LinkedListNode<int> {14, nullptr});

  shared_ptr<LinkedListNode<int>> res = merge_two_sortedlists(h1, h2);

  auto temp = res;

  while (temp) {
    cout << temp->data << " ";
    temp = temp->next;
  }

  return 0;
}


/*

How to run

g++ -std=c++11 mergesortedlists_test.cpp -o mergesortedlists
./mergesortedlists

*/
