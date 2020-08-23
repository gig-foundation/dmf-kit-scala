package gig.dmf.persistence

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Entity {
  def blocks: IndexedSeq[Block]
}

case class StrictEntity(
  blocks: IndexedSeq[Block])
  extends Entity
