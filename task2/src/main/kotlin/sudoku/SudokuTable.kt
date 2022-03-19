package sudoku

class SudokuTable() {
    private var table = arrayOf<Array<Char>>()

    init {
        for (i in 0..8) {
            var array = arrayOf<Char>()
            for (j in 0..8) {
                array += '-'
            }
            table += array
        }
    }

    fun set(x: Int, y: Int, value: Char) {
        if( x in 1..9 && y in 1..9) {
            table[x - 1][y - 1] = value
        }
    }

    fun print() {
        for(stroke in table) {
            for(item in stroke) {
                print("$item ")
            }
            println()
        }
    }

    fun save(): SudokuSave {
        var clone = arrayOf<Array<Char>>()
        for (stroke in table) {
            clone += stroke.clone()
        }
        return SudokuSave(clone)
    }

    fun load(save: SudokuSave) {
        table = save.table
    }

    fun checkStrokes(): Boolean {
        for (stroke in table) {
            val frequencies = stroke.groupingBy { it }.eachCount()
            for (frequency in frequencies) {
                if (frequency.key != '-' && frequency.value > 1) {
                    return false
                }
            }
        }
        return true
    }

    fun checkColumns(): Boolean {
        for(j in 0..8) {
            var column = arrayOf<Char>()
            for(i in 0..8) {
                column += table[i][j]
            }
            val frequencies = column.groupingBy { it }.eachCount()
            for (frequency in frequencies) {
                if (frequency.key != '-' && frequency.value > 1) {
                    return false
                }
            }
        }
        return true
    }

    private fun notInBox(arr: Array<Array<Char>>, startRow: Int, startCol: Int) :Boolean {
        var st = arrayOf<Char>()

        for (row in 0..2) {
            for (col in 0..2) {
                st += arr[row + startRow][col + startCol]
            }
        }

        val frequencies = st.groupingBy { it }.eachCount()
        for (frequency in frequencies) {
            if (frequency.key != '-' && frequency.value > 1) {
                return false
            }
        }
        return true
    }

    fun checkSquares(): Boolean {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (!notInBox(table, i*3, j*3)) return false
            }
        }
        return true
    }

    fun checkRules(): Boolean {
        return checkStrokes() && checkColumns() && checkSquares()
    }

    fun checkWin(): Boolean {
        for (stroke in table) {
            if(stroke.contains('-')) {
                return false
            }
        }
        return checkRules()
    }
}