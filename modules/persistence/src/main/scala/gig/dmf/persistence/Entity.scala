package gig.dmf.persistence

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 17, 2020
 */
sealed trait Entity {
  def blocks: Seq[Block]
}
