package lt.rksk.watch2048

class Board {
    var matrix = listOf(
        listOf(0, 0, 0, 0),
        listOf(0, 0, 0, 0),
        listOf(0, 0, 0, 0),
        listOf(0, 0, 0, 0)
    ).map { line -> line.map { number -> Tile(number) } }
}