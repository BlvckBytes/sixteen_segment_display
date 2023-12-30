package me.blvckbytes.segmentstates

import java.io.File
import javax.imageio.ImageIO

object SegmentStates {

  @JvmStatic
  fun main(args: Array<String>) {
    println("There are ${SegmentState.values().size} segment states")
    val outputDirectory = "${System.getProperty("user.home")}/Desktop"
    ImageIO.write(StateRenderer.renderAllStates(), "jpg", File("$outputDirectory/state_image.jpg"))
  }
}