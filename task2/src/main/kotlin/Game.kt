import sudoku.SudokuTable
import sudoku.History

class Game {
    private val sudoku = SudokuTable()
    private val history = History()
    private fun save() = history.save(sudoku)
    private fun load() = history.load(sudoku)

    fun play() {
        while (!sudoku.checkWin()) {
            sudoku.print()
            val input = readln().split(' ')
            when(input[0]) {
                "exit" -> return
                "undo" -> {
                    load()
                    continue
                }
            }

            val numberRegex = Regex("\\d+")
            if(input.size != 3 ||
                !input[0].matches(numberRegex) ||
                !input[0].matches(numberRegex)
            ) {
                    println("Wrong input")
                    continue
                }
            val (x, y) = input.slice(0..1).map {it.toInt()}
            when(val value = input[2][0]) {
                '-', in '1'..'9' -> {
                    save()
                    sudoku.set(x, y, value)
                }
                else -> println("wrong value")
            }
            if(!sudoku.checkRules()) {
                println("Rules are not followed")
            }
            if(sudoku.checkWin()) {
                println("Congratulations! You won!")
                return
            }
        }
    }
}