package gig.dmf.persistence

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Block {
  def elements: Iterable[Element]
}

object Block {

  def apply(elements: Iterable[Element]): Block =
    StrictBlock(elements.toIndexedSeq)

  def apply(element: Element, elements: Element*): Block =
    StrictBlock(element +: elements.toVector)

}

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 23, 2020
 */
case class StrictBlock(elements: IndexedSeq[Element]) extends Block
