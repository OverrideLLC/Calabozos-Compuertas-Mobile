package org.book.platform

expect class AudioPlayer(context: Any?) {
    fun play(url: String)
    fun pause()
    fun stop()
}