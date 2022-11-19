package lt.rksk.watch2048

class Game {
    private val board = Board()
    private var score = 0
    private var isGameOver = false
    private var message: String? = null

    private lateinit var listener: GameListener

    interface GameListener {
        fun onUpdateBoard(board: Board)
    }

    fun swipeRight() {
        val row = (0..4).random()
        val column = (0..4).random()

        val tile = board.matrix[row][column]
        val value = if (tile.value > 0) {
            tile.value * 2
        } else {
            2
        }

        println("$row, $column = $value")

        board.matrix[row][column].value = value

        listener.onUpdateBoard(board)
    }

    fun swipeLeft() {}
    fun swipeUp() {}
    fun swipeDown() {}

    fun setListener(gameListener: GameListener) {
        listener = gameListener
    }
}