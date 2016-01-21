package main

import (
    "fmt"
)

func main() {

    var str = []rune{'a', 'b', 's', 't', 'r', 'a', 'c', 't'}
    str = ReplaceAndRemove(str)

    for i:=0; i< len(str); i++ {
      fmt.Printf(string(str[i]))
    }
    fmt.Println()

    var str2 = []rune{'a', 'b', 's', 'b', 'r', 'a', 'c', 't', ' ', ' ', ' ', ' ', ' ', ' '}
    str2 = ReplaceAndRemove(str2)

    for i:=0; i< len(str2); i++ {
      fmt.Printf(string(str2[i]))
    }
    fmt.Println()
}

// removing a and replacing b
func ReplaceAndRemove(str []rune) []rune {
    numB, writeInd, newLen := 0, 0, 0
    for i:=0; i< len(str); i++ {
      if str[i] == 'a' {
        continue
      } else if str[i] == 'b' {
        numB++
      }
      str[writeInd] = str[i]
      newLen++
      writeInd++
    }
    writeInd = newLen + (2 * numB)
    newLen--
    strNew := make([]rune, writeInd)
    writeInd -= 1
    for newLen >= 0 {
        if str[newLen] == 'b' {
            strNew[writeInd] = 'e'
            strNew[writeInd-1] = 'e'
            strNew[writeInd-2] = 'b'
            writeInd -= 3
        } else {
            strNew[writeInd] = str[newLen]
            writeInd -= 1
        }
        newLen -= 1
    }
    return strNew
}
