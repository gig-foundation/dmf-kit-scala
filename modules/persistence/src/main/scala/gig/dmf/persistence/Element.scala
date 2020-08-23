package gig.dmf.persistence

import gig.dmf.core._

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Element {
  type Data
  def data: Data
}

object Element {
  sealed trait HasMetadata {
    type Metadata
    def metadata: Metadata
  }
}

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 22, 2020
 */
sealed trait Reference extends Element {
  override type Data = IndexedSeq[Identity]
}

object Reference {

  def apply(identities: Iterable[Identity]): Reference =
    StrictReference(identities.toIndexedSeq)

  def apply(identity: Identity, identities: Identity*): Reference =
    Reference(identity +: identities.toIndexedSeq)

  implicit class Ops(val reference: Reference) extends AnyVal {
    def identities: IndexedSeq[Identity] = reference.data
  }

}

case class StrictReference(data: IndexedSeq[Identity]) extends Reference
