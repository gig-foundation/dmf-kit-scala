package gig.dmf.models.common

import scala.collection.immutable._
import scala.reflect.ClassTag

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
trait Block[F[_]] {
  type Elem <: Element
  def elements: F[Elem]
}

object Block {

  case class Strict[E <: Element: ClassTag](elements: IndexedSeq[E]) extends Block[IndexedSeq] {
    override type Elem = E
  }

  def apply[E <: Element: ClassTag](elements: Iterable[E]): Block[IndexedSeq] =
    Strict(elements.toIndexedSeq)

  def apply[E <: Element: ClassTag](element: E, elements: E*): Block[IndexedSeq] =
    Strict(element +: elements.toVector)

}
