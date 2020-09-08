package gig.dmf.canonical.encodings.cbor

import gig.dmf.canonical.encodings.cbor.implicits._
import gig.dmf.models.common.Block
import io.bullet.borer.Encoder
import io.bullet.borer.Writer

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 07, 2020
 */
class BlockEncoder[F[_]](implicit FA: Functor[F]) extends Encoder[Block[F]] {

  override def write(writer: Writer, value: Block[F]) = {
    implicit def enc: Encoder[value.Elem] = ???
    FA.leftFold[value.Elem, Writer](writer)(value.elements, _.write(_))
  }

}
