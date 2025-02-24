package org.book.platform

import platform.AVFoundation.*
import platform.Foundation.*

actual class AudioPlayer actual constructor(context: Any?) {
    private var player: AVPlayer? = null

    actual fun play(url: String) {
        val nsUrl = NSURL.URLWithString(url) ?: return
        player = AVPlayer.playerWithURL(nsUrl)
        player?.play()
    }

    actual fun pause() {
        player?.pause()
    }

    actual fun stop() {
        player?.pause()
        player = null
    }
}