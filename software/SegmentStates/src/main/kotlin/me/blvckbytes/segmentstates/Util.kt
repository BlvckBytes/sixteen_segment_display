package me.blvckbytes.segmentstates

import java.util.*

object Util {

  fun <T : Enum<T>> enumSetFromArray(array: Array<out T>): EnumSet<T> {
    @Suppress("UNCHECKED_CAST")
    val result = EnumSet.noneOf(array.javaClass.componentType as Class<T>)

    for (item in array)
      result.add(item)

    return result
  }
}