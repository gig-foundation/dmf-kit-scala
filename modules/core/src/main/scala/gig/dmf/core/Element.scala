package gig.dmf.core

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Element
object Element

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 22, 2020
 */
sealed trait Reference extends Element {
  def identities: Iterable[Identity]
}

object Reference {

  def apply(identities: Iterable[Identity]): Reference =
    StrictReference(identities.toIndexedSeq)

  def apply(identity: Identity, identities: Identity*): Reference =
    StrictReference(identity +: identities.toIndexedSeq)

}

case class StrictReference(identities: IndexedSeq[Identity]) extends Reference

sealed trait Selector extends Element {
  def ranges: Iterable[Range]
}

object Selector {

  def apply(ranges: Iterable[Range]): Selector =
    StrictSelector(ranges.toIndexedSeq)

  def apply(range: Range, ranges: Range*): Selector =
    Selector(range +: ranges.toIndexedSeq)

}

case class StrictSelector(ranges: IndexedSeq[Range]) extends Selector
