package gig.dmf.models.common

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
trait Entity[F[_]] {
  def blocks: F[Block[F]]
}

object Entity {

  case class Strict(blocks: IndexedSeq[Block[IndexedSeq]]) extends Entity[IndexedSeq]

  def apply(blocks: Iterable[Block[IndexedSeq]]): Entity[IndexedSeq] =
    Strict(blocks.toIndexedSeq)

  def apply(block: Block[IndexedSeq], blocks: Block[IndexedSeq]*): Entity[IndexedSeq] =
    Strict(block +: blocks.toVector)

}
