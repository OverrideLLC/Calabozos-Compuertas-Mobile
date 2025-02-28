package org.book.platform

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

actual class AudioPlayer actual constructor(context: Any?) {
    private val context: Context = context as Context
    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(this.context).build()

    actual fun play(url: String) {
        val mediaItem = MediaItem.fromUri(url)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()
    }

    actual fun pause() {
        exoPlayer.pause()
    }

    actual fun stop() {
        exoPlayer.stop()
    }
}