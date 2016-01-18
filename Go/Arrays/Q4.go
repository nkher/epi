package main

import "fmt"

func main() {

    var boardGame = []int {3, 3, 1, 0, 2, 0, 1}
    fmt.Println("Boardgame Winnable ?? : ", checkWinnable(boardGame))

    boardGame = []int {3, 3, 0, 0, 2, 0, 1}
    fmt.Println("Boardgame Winnable ?? : ", checkWinnable(boardGame))

    boardGame = []int {2, 2, 1, 1, 0, 2, 3}
    fmt.Println("Boardgame Winnable ?? : ", checkWinnable(boardGame))
}

func checkWinnable(boardGame []int) bool {
  furthestReach := 0
  for i:=0; i<=furthestReach && furthestReach < len(boardGame); i++ {
      if (boardGame[i] + i > furthestReach) {
        furthestReach = boardGame[i] + i
      }
  }
  return furthestReach >= len(boardGame)
}
