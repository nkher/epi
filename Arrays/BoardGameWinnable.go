package main

import "fmt"

func main() {

    var boardGame = []int {3, 3, 1, 0, 2, 0, 1}
    fmt.Println("Boardgame Winnable ?? : ", CheckWinnable(boardGame))

    boardGame = []int {3, 3, 0, 0, 2, 0, 1}
    fmt.Println("Boardgame Winnable ?? : ", CheckWinnable(boardGame))

    boardGame = []int {2, 2, 1, 1, 0, 2, 3}
    fmt.Println("Boardgame Winnable ?? : ", CheckWinnable(boardGame))
}

// This function checks if the given board game is Winnable or not.
// The board is represented as an integer array where we start from the 0th
// index and the game is won if we are able to reach the last index.
// The value at each index is the maximum number of indices/steps we can jump.
func CheckWinnable(boardGame []int) bool {
  furthestReach := 0
  for i:=0; i<=furthestReach && furthestReach < len(boardGame); i++ {
      if (boardGame[i] + i > furthestReach) {
        furthestReach = boardGame[i] + i
      }
  }
  return furthestReach >= len(boardGame)
}
