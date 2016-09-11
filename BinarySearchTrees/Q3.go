package main

import (
    "fmt"
    "../Structures"
)

func main() {

    var root *bst.BstNode
    root = bst.Insert(root, 500)
    root = bst.Insert(root, 200)
    root = bst.Insert(root, 100)
    root = bst.Insert(root, 50)
    root = bst.Insert(root, 250)
    root = bst.Insert(root, 300)
    root = bst.Insert(root, 900)
    root = bst.Insert(root, 1000)
    root = bst.Insert(root, 1000)
    root = bst.Insert(root, 700)
    root = bst.Insert(root, 800)

    firstGreater := findFirstLargerKey(root, 500)
    fmt.Println("First Greater is : ",  firstGreater.Data)
}

func FindFirstLargerKey(node *bst.BstNode, key int) *bst.BstNode {
    var firstSoFar, curr *bst.BstNode = nil, node

    for curr != nil {
      if curr.Data > key {
        firstSoFar = curr
        curr = curr.Left
      } else {
        curr = curr.Right
      }
    }
    return firstSoFar
}
