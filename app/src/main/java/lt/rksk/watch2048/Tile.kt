package lt.rksk.watch2048

data class Tile(var value: Int = 0) {
    private val colors = mapOf(
        0 to "#DDCCBB",
        2 to "#EEEEEE",
        4 to "#EEEECC",
        8 to "#FFBB88",
        16 to "#FF9966",
        32 to "#FF7755",
        64 to "#FF5533",
        128 to "#EECC77",
        256 to "#EECC66",
        512 to "#EECC55",
        1024 to "#EECC34",
        2048 to "#EECC22"
    )

    val color get() = colors[this.value]
}
