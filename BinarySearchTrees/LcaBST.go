package main

import (
    "fmt"
    "../Structures/bst"
)

func main() {

  var root *bst.BstNode
  root = bst.Insert(root, 19)
  root = bst.Insert(root, 7)
  root = bst.Insert(root, 43)
  root = bst.Insert(root, 3)
  root = bst.Insert(root, 11)
  root = bst.Insert(root, 23)
  root = bst.Insert(root, 47)
  root = bst.Insert(root, 2)
  root = bst.Insert(root, 5)
  root = bst.Insert(root, 17)
  root = bst.Insert(root, 37)
  root = bst.Insert(root, 53)
  root = bst.Insert(root, 13)
  root = bst.Insert(root, 29)
  root = bst.Insert(root, 41)
  root = bst.Insert(root, 31)

  fmt.Println(root.Left.Left.Data, " ", root.Left.Right.Right.Data)

  nodeC, nodeG := root.Left.Left, root.Left.Right.Right
  fmt.Println("LCA of 3 and 17 is: ", FindLCA(root, nodeC, nodeG).Data)
}

func FindLCA(root *bst.BstNode, node1 *bst.BstNode, node2 *bst.BstNode) *bst.BstNode {

    var small, big *bst.BstNode
    if node1.Data > node2.Data {
      small, big = node2, node1
    } else {
      big, small = node2, node1
    }

    curr := root
    for curr.Data < small.Data || curr.Data > big.Data {

      for curr.Data < small.Data {
        curr = curr.Right
      }

      for curr.Data > big.Data {
        curr = curr.Left
      }
    }
    return curr
}
