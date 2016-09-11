package main

import (
    "fmt"
)

var hashmap = make(map[string]int)

func main() {
    fillMap()
    fmt.Println("Integer for LIX is : ",RomanToInteger("LIX"))
    fmt.Println("Integer for IC is : ",RomanToInteger("IC"))
}

func RomanToInteger(str string) int {
    n := len(str)
    sum := hashmap[string(str[n-1])]

    for i:=n-2; i >= 0; i-- {

      if hashmap[string(str[i])] < hashmap[string(str[i+1])] {
        sum -= hashmap[string(str[i])]
      } else {
        sum += hashmap[string(str[i])]
      }
    }
    return sum
}

func fillMap() {
  hashmap["I"] = 1
  hashmap["V"] = 5
  hashmap["X"] = 10
  hashmap["L"] = 50
  hashmap["C"] = 100
  hashmap["D"] = 500
  hashmap["M"] = 1000
}
