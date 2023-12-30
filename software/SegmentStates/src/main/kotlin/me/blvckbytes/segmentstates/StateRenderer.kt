package me.blvckbytes.segmentstates

import org.apache.batik.transcoder.TranscoderInput
import org.apache.batik.transcoder.image.JPEGTranscoder
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.StringWriter
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

object StateRenderer {

  private val transformerFactory = TransformerFactory.newInstance()
  private val xmlDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()

  private const val SEGMENT_ON_COLOR = "#00FF15"
  private const val SEGMENT_OFF_COLOR = "#141414"
  private const val RASTERIZED_SVG_WIDTH = 100
  private const val RASTERIZED_SVG_QUALITY = .5

  private const val STATE_IMAGE_NUMBER_OF_COLUMNS = 15
  private const val STATE_IMAGE_SPACING = 30
  private const val STATE_IMAGE_BACKGROUND = "#000000"

  fun renderAllStates(): BufferedImage {
    val renderedStates = mutableListOf<BufferedImage>()
    var stateWidth: Int? = null
    var stateHeight: Int? = null

    for (state in SegmentState.values()) {
      val renderedState = renderSvg(generateColorizedSvg(state.segments))

      if (stateWidth == null)
        stateWidth = renderedState.width
      else if (stateWidth != renderedState.width)
        throw IllegalStateException("Expected a uniform width accross all rendered states")

      if (stateHeight == null)
        stateHeight = renderedState.height
      else if (stateHeight != renderedState.height)
        throw IllegalStateException("Expected a uniform width accross all rendered states")

      renderedStates.add(renderedState)
    }

    if (stateWidth == null || stateHeight == null)
      throw IllegalStateException("No states to draw")

    val numberOfStates = renderedStates.size
    val numberOfRows = (numberOfStates + STATE_IMAGE_NUMBER_OF_COLUMNS - 1) / STATE_IMAGE_NUMBER_OF_COLUMNS

    val imageWidth = (
      (STATE_IMAGE_NUMBER_OF_COLUMNS - 1) * STATE_IMAGE_SPACING +
      STATE_IMAGE_NUMBER_OF_COLUMNS * stateWidth +
      2 * STATE_IMAGE_SPACING
    )

    val imageHeight = (
      (numberOfRows - 1) * STATE_IMAGE_SPACING +
      numberOfRows * stateHeight +
      2 * STATE_IMAGE_SPACING
    )

    val stateImage = BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB)
    val graphics = stateImage.createGraphics()

    graphics.color = Color.decode(STATE_IMAGE_BACKGROUND)
    graphics.fillRect(0, 0, imageWidth, imageHeight)

    var currentRow = 0
    var currentColumn = 0

    for (state in renderedStates) {
      val x = currentColumn * stateWidth + currentColumn * STATE_IMAGE_SPACING + STATE_IMAGE_SPACING
      val y = currentRow * stateHeight + currentRow * STATE_IMAGE_SPACING + STATE_IMAGE_SPACING

      graphics.drawImage(state, null, x, y)

      if (++currentColumn == STATE_IMAGE_NUMBER_OF_COLUMNS) {
        currentColumn = 0
        ++currentRow
      }
    }

    return stateImage
  }

  private fun findSvgElementById(element: Element, id: String): Element? {
    if (element.attributes.getNamedItem("id")?.nodeValue == id)
      return element

    val children = element.childNodes

    for (i in 0 until children.length) {
      val child = children.item(i)

      if (child !is Element)
        continue

      return findSvgElementById(child, id) ?: continue
    }

    return null
  }

  private fun stringifyDocument(doc: Document): String {
    return StringWriter().use {
      val transformer = transformerFactory.newTransformer()
      transformer.setOutputProperty(OutputKeys.INDENT, "yes")
      transformer.transform(DOMSource(doc), StreamResult(it))
      it.toString()
    }
  }

  private fun generateColorizedSvg(segments: EnumSet<Segment>): String {
    return SegmentStates.javaClass.getResourceAsStream("/segments.svg").use {
      val svgDocument = xmlDocumentBuilder.parse(it)
      val svgElement = svgDocument.documentElement

      val segmentsElement = findSvgElementById(svgElement, "segments")
        ?: throw IllegalStateException("Could not locate the segments-containing element")

      for (segment in Segment.values()) {
        val segmentElement = findSvgElementById(segmentsElement, segment.name.lowercase())
          ?: throw IllegalStateException("Could not locate the element representing segment $segment")

        segmentElement.setAttribute("fill", if (segments.contains(segment)) SEGMENT_ON_COLOR else SEGMENT_OFF_COLOR)
      }

      stringifyDocument(svgDocument)
    }
  }

  private fun renderSvg(svg: String): BufferedImage {
    return ByteArrayInputStream(svg.toByteArray()).use {
      val transcoderInput = TranscoderInput(it)
      val transcoder = AccessibleImageTranscoder()

      transcoder.addTranscodingHint(JPEGTranscoder.KEY_WIDTH, RASTERIZED_SVG_WIDTH.toFloat())
      transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, RASTERIZED_SVG_QUALITY.toFloat())
      transcoder.transcode(transcoderInput, null)

      transcoder.lastImage ?: throw IllegalStateException("Could not access last transcoded image")
    }
  }
}