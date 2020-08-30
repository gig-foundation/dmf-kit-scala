package gig.dmf.models.common

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Entity {
  def blocks: Iterable[Block]
}

object Entity {

  def apply(blocks: Iterable[Block]): Entity =
    StrictEntity(blocks.toIndexedSeq)

  def apply(block: Block, blocks: Block*): Entity =
    StrictEntity(block +: blocks.toVector)

}

case class StrictEntity(blocks: IndexedSeq[Block]) extends Entity
