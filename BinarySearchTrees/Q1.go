package main

import (
    "fmt"
    "../Structures"
)

func main() {

  var root *bst.BstNode
  root = &bst.BstNode{nil, 10, nil}
  root.Left = &bst.BstNode{nil, 5, nil}
  root.Right = &bst.BstNode{nil, 15, nil}
  root.Left.Left = &bst.BstNode{nil, 3, nil}
  root.Right.Right = &bst.BstNode{nil, 20, nil}
  root.Left.Right = &bst.BstNode{nil, 7, nil}
  root.Right.Left = &bst.BstNode{nil, 12, nil}

  // root.Left.Left.Left = &bst.BstNode{nil, 100, nil} // to make it an invalid BST

  fmt.Println("Valid BST ?? : ", CheckValidBST(root))

}

func CheckValidBST(root *bst.BstNode) bool {
    return checkValidBSTHelper(root, 1<<32 - 1, 0)
}

func checkValidBSTHelper(node *bst.BstNode, max int, min int) bool {
    if node != nil {
      if node.Data < min || node.Data > max {
        return false
      }

      if !checkValidBSTHelper(node.Left, node.Data, min) || !checkValidBSTHelper(node.Right, max, node.Data) {
        return false
      }
    }
    return true
}
