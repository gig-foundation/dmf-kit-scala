package gig.dmf.models.common

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
trait Element
object Element {
  trait Reserved { _: Element => }
}
