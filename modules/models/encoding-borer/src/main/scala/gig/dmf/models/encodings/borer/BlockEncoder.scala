package gig.dmf.models.encodings.borer

import cats._
import cats.syntax.foldable._
import gig.dmf.models.common.Block
import io.bullet.borer.Encoder
import io.bullet.borer.Writer

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 07, 2020
 */
class BlockEncoder[F[_]: Foldable] extends Encoder[Block[F]] {

  override def write(writer: Writer, value: Block[F]) = {
    implicit def enc: Encoder[value.Elem] = ???
    value.elements.foldLeft(writer)(_.write(_))
  }

}
