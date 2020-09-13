package gig.dmf.models.common

import gig.dmf.ByteString

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 22, 2020
 */
case class Identity(digest: ByteString) extends AnyVal
