package gig.dmf.models.common

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
trait Element {
  type Data
}

object Element {
  trait HasMetadata { _: Element =>
    type Metadata
  }
}
