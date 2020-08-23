package gig.dmf.persistence

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Entity {
  def references: References
  def selectors: Selectors
}

object Entity {

  def apply(
    references: References,
    selectors: Selectors
  ): Entity =
    StrictEntity(
      references,
      selectors
    )

  implicit class Ops(val entity: Entity) extends AnyVal {
    def blocks: IndexedSeq[Block] =
      IndexedSeq(
        entity.references,
        entity.selectors
      )
  }
}

case class StrictEntity(
  references: References,
  selectors: Selectors)
  extends Entity
