package main

import (
    "fmt"
)

var NumTelDig = []string{"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"}

func main() {

    phoneNo := "4326696"
    combinations := PhoneCombinations(phoneNo)

    for i := range combinations {
      fmt.Println(combinations[i])
    }
}

func PhoneCombinations(phoneNo string) []string {
    var partialComb = make([]rune, len(phoneNo))
    var combinations []string
    combinations = phoneCombinationsHelper(phoneNo, 0, partialComb, combinations)
    return combinations
}

func phoneCombinationsHelper(phoneNo string, dig int, partialComb []rune, combinations []string) []string {
    if dig == len(phoneNo) {
        combinations = append(combinations, getStringFromRune(partialComb))
    } else {
        currNum := int(phoneNo[dig]) - '0'
        chars := NumTelDig[currNum]
        for i:=0; i< len(chars); i++ {
          partialComb[dig] = rune(chars[i])
          combinations = phoneCombinationsHelper(phoneNo, dig+1, partialComb, combinations)
        }
    }
    return combinations
}

func getStringFromRune(arr []rune) string {
  var str string
  for i:=0; i < len(arr); i++ {
    str += string(arr[i])
  }
  return str
}
