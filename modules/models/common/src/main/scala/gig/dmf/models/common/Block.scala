package gig.dmf.models.common

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
trait Block {
  type Elem <: Element
  def elements: Iterable[Elem]
}

object Block {

  def apply[E <: Element](elements: Iterable[E]): Block =
    StrictBlock(elements.toIndexedSeq)

  def apply[E <: Element](element: E, elements: E*): Block =
    StrictBlock(element +: elements.toVector)

}

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 23, 2020
 */
case class StrictBlock[E <: Element](elements: IndexedSeq[E]) extends Block {
  override type Elem = E
}
