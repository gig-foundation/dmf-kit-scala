package gig.dmf

import java.util

/**
 * Borrows rationale and implementation details from Akka's variation.
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 07, 2020
 */
sealed trait ByteString extends IndexedSeq[Byte] {
  def toArray: Array[Byte]
}

object ByteString {

  case class Compact(override val toArray: Array[Byte]) extends ByteString {

    override def apply(index: Int) = toArray(index)

    override def length = toArray.length

    override def hashCode() = util.Arrays.hashCode(toArray)

    override def equals(other: Any) =
      other match {
        case other: Compact => util.Arrays.equals(toArray, other.toArray)
      }

  }

  def apply(buffer: Array[Byte]): ByteString =
    Compact(buffer)

}
