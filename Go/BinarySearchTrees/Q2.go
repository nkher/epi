package main

import (
  "fmt"
  "../Structures"
)

func main() {

  var array = []int{15, 25, 35, 50, 60, 75, 100}

  var root *bst.BstNode
  root = createMinimalBST(array)
  bst.Inorder(root);

  fmt.Println("Height of created tree is : ", bst.Height(root))

  fmt.Println(root.Right.Left.Data) // for verification
}

func createMinimalBST(array []int) *bst.BstNode {
    return addToTree(array, 0, len(array)-1)
}

func addToTree(array []int, start int, end int) *bst.BstNode {
    if end < start {
        return nil
    }
    mid := (start+end)/2
    node := &bst.BstNode{nil, array[mid], nil}
    node.Left = addToTree(array, start, mid-1)
    node.Right = addToTree(array, mid+1, end)
    return node
}
