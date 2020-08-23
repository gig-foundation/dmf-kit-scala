package gig.dmf.persistence

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Entity {
  def references: References
}

object Entity {

  def apply(
    references: References
  ): Entity =
    StrictEntity(
      references
    )

  implicit class Ops(val entity: Entity) extends AnyVal {
    def blocks: IndexedSeq[Block] =
      IndexedSeq(entity.references)
  }
}

case class StrictEntity(
  references: References)
  extends Entity
