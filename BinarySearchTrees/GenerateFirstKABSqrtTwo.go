package main

import (
    "fmt"
    "math"
)

type ABSqrtTwo struct {
  A int
  B int
  Val float64
}

func main() {

    array := GenerateFirstKABSqrtTwo(5)

    for i := range array {
        fmt.Println(array[i].Val)
    }
}

func NewObj(a, b int) *ABSqrtTwo {
  obj := new(ABSqrtTwo)
  obj.A = a
  obj.B = b
  obj.Val = float64(a) + (float64(b) * math.Sqrt(2))
  return obj
}

func GenerateFirstKABSqrtTwo(k int) []*ABSqrtTwo {

    var array []*ABSqrtTwo
    firstObject := NewObj(0, 0)
    array = append(array, firstObject)
    i, j, n := 0, 0, 0

    for n=0; n<k; n++ {

      resultiPlus1 := NewObj(array[i].A + 1, array[i].B)
      resultjPlusSqrt2 := NewObj(array[j].A, array[j].B + 1)

      if resultiPlus1.Val < resultjPlusSqrt2.Val {
          array = append(array, resultiPlus1)
          i++
      } else if resultiPlus1.Val > resultjPlusSqrt2.Val {
          array = append(array, resultjPlusSqrt2)
          j++
      } else {
        i++; j++;
        array = append(array, resultiPlus1)
      }
    }

    return array
}
