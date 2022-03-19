package sudoku

import java.util.*

class History{
    private val stack = ArrayDeque<SudokuSave>()
    fun save(sudokuTable: SudokuTable) {
        stack.push(sudokuTable.save())
    }
    fun load(sudokuTable: SudokuTable) {
        if(!stack.isEmpty()) {
            sudokuTable.load(stack.pop())
        }
    }
}