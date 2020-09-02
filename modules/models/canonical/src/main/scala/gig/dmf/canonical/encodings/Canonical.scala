package gig.dmf.canonical.encodings

import gig.dmf.models.common.Block
import gig.dmf.models.common.Element
import gig.dmf.models.common.Entity
import gig.dmf.models.common.StrictBlock
import gig.dmf.models.common.StrictEntity

import scala.collection.immutable._
import scala.reflect.ClassTag

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 01, 2020
 */
sealed trait Canonical
object Canonical {

  case class CanonicalEntity(blocks: IndexedSeq[Block with Canonical]) extends Entity with Canonical

  case class EntityOps(self: Entity) extends AnyVal {
    def toCanonical: Entity with Canonical =
      self match {
        case entity: CanonicalEntity => entity
        case _ =>
          CanonicalEntity(self
            .blocks
            .map(BlockOps(_).toCanonical)
            .toIndexedSeq)
      }
  }

  case class CanonicalBlock[E <: Element](elements: IndexedSeq[E]) extends Block with Canonical {
    override type Elem = E
  }

  case class BlockOps(self: Block) extends AnyVal {
    def toCanonical: Block with Canonical =
      self match {
        case block: CanonicalBlock[_] => block
        case _ =>
          CanonicalBlock(self.elements.toIndexedSeq)
      }
  }

  trait ImplyEntityAsCanonicalOps {
    implicit def implyEntityAsCanonicalOps(entity: Entity): EntityOps = EntityOps(entity)
  }

  trait ImplyBlockAsCanonicalOps {
    implicit def implyBlockAsCanonicalOps(block: Block): BlockOps = BlockOps(block)
  }

}
