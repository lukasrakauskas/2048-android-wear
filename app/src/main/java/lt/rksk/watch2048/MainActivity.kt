package lt.rksk.watch2048

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import lt.rksk.watch2048.databinding.ActivityMainBinding

@SuppressLint("ClickableViewAccessibility")
class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: Game
    private lateinit var texts: List<List<TextView>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        game = Game()
        texts = listOf(
            listOf(binding.tile1, binding.tile2, binding.tile3, binding.tile4),
            listOf(binding.tile5, binding.tile6, binding.tile7, binding.tile8),
            listOf(binding.tile9, binding.tile10, binding.tile11, binding.tile12),
            listOf(binding.tile13, binding.tile14, binding.tile15, binding.tile16)
        )

        binding.root.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                game.swipeLeft()
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                game.swipeRight()
            }

            override fun onSwipeUp() {
                super.onSwipeUp()
                game.swipeUp()
            }

            override fun onSwipeDown() {
                super.onSwipeDown()
                game.swipeDown()
            }
        })

        game.setListener(object : Game.GameListener {
            override fun onUpdateBoard(board: Board) {
                for ((rowIndex, row) in board.matrix.withIndex()) {
                    for ((columnIndex, tile) in row.withIndex()) {
                        val textView = texts[rowIndex][columnIndex]
                        textView.text = tile.value.toString()
                        textView.setBackgroundColor(Color.parseColor(tile.color))
                    }
                }
            }
        })
    }
}