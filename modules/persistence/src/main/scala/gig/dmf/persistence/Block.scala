package gig.dmf.persistence

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Block {
  type E <: Element
  def elements: IndexedSeq[E]
}

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 23, 2020
 */
sealed trait References extends Block {
  override type E = Reference
}

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 23, 2020
 */
case class StrictReferences(elements: IndexedSeq[Reference]) extends References
