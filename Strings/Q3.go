package main

import (
    "fmt"
    "strings"
)

func main() {

    fmt.Println(CheckPalindrome("nitin"))
    fmt.Println(CheckPalindrome("nittin"))
    fmt.Println(CheckPalindrome("nitiNe"))
    fmt.Println(CheckPalindrome("nitiN"))
}

func CheckPalindrome(str string) bool {
    for i, j := 0, len(str)-1; i < j; i, j = i+1, j-1 {
      if strings.ToLower(string(str[i])) != strings.ToLower(string(str[j])) {
          return false
      }
    }
    return true
}
