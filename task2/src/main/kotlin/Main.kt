fun main() {
    val sudoku = SudokuTable()
    val history = History()
    sudoku.set(5, 4, '3')
    history.save(sudoku)
    sudoku.print()
    println()
    sudoku.set(4 ,4,'3')
    sudoku.print()
    println(sudoku.checkRules())
    history.load(sudoku)
    sudoku.print()
    println(sudoku.checkRules())
}