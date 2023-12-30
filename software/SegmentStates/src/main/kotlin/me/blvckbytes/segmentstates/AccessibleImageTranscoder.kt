package me.blvckbytes.segmentstates

import org.apache.batik.transcoder.TranscoderOutput
import org.apache.batik.transcoder.image.ImageTranscoder
import java.awt.image.BufferedImage
import kotlin.Int

class AccessibleImageTranscoder : ImageTranscoder() {

  var lastImage: BufferedImage? = null

  init {
    hints[KEY_FORCE_TRANSPARENT_WHITE] = false
  }

  override fun createImage(width: Int, height: Int): BufferedImage {
    return BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
  }

  override fun writeImage(img: BufferedImage?, output: TranscoderOutput?) {
    lastImage = img
  }
}