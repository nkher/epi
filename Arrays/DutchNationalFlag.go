package main

import (
    "fmt"
    "epi/utils"
)

func main() {

  var arr = []int{2, 1, 3, 3, 4, 1, 3, 2, 2, 1, 2, 3, 1}

  fmt.Println("Slice Before Rearrangement : ", arr)
  fmt.Println("Passing in an index of 3 and hence pivot = 3")

  arr = DutchNationalFlag(arr, 3)

  fmt.Println("Slice After Rearrangement : ", arr)
}

// This function takes in an array of length 'n' and an integer
// in between [0..n-1] which is the pivot. It rearranges the elements
// of the array around the pivot such that the elements before the
// pivot would be all the smaller elements of the array and the larger
// ones would be after the pivot. It does this in O(n) time and O(1)
// space.
func DutchNationalFlag(arr []int, index int)[]int {

  n := len(arr)
  smaller, equal, larger := 0, 0, n-1
  pivot := arr[index]

  for equal <= larger {

    if arr[equal] < pivot {
      utils.Swap(arr, smaller, equal)
      smaller++
      equal++

    } else if arr[equal] == pivot {
      equal++

    } else {
      utils.Swap(arr, equal, larger)
      larger--
    }

  }

  return arr
}
