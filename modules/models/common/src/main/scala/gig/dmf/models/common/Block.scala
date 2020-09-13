package gig.dmf.models.common

import scala.collection.immutable._
import scala.reflect.ClassTag

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
trait Block[F[_]] {
  type Type <: Element
  def elements: F[Type]
}

object Block {

  case class Strict[A <: Element](override val elements: IndexedSeq[A]) extends Block[IndexedSeq] {
    override type Type = A
  }

  def apply[A <: Element](elements: Iterable[A]): Block[IndexedSeq] =
    Strict(elements.toIndexedSeq)

  def apply[A <: Element: ClassTag](element: A, elements: A*): Block[IndexedSeq] =
    Strict(element +: elements.toVector)

}
