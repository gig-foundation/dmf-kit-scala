package gig.dmf.models.common

import gig.dmf.models.common.Element.Reserved

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 30, 2020
 */
case class Reference(identity: Identity) extends Element with Reserved
