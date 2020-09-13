package gig.dmf.models.encodings.borer

import cats._
import cats.syntax.foldable._
import gig.dmf.ByteString
import gig.dmf.models.common._
import io.bullet.borer.Codec
import io.bullet.borer.Decoder
import io.bullet.borer.Encoder
import io.bullet.borer.derivation.ArrayBasedCodecs._

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 22, 2020
 */
object implicits {

  implicit val encoderRange: Encoder[Range] =
    Encoder { (writer, range) =>
      writer.writeArrayOpen(3)
      writer.writeInt(range.start)
      writer.writeInt(range.end)
      writer.writeInt(range.step)
      writer.writeArrayClose()
    }

  implicit val decoderRange: Decoder[Range] =
    Decoder { reader =>
      val unbounded = reader.readArrayOpen(3)
      val start = reader.readInt()
      val end = reader.readInt()
      val step = reader.readInt()
      val range = Range(start, end, step)
      reader.readArrayClose(unbounded, range)
    }

  implicit val codecByteString: Codec[ByteString] =
    Codec.of[Array[Byte]]
      .bimap(_.toArray, ByteString(_))

  implicit val codecIdentity: Codec[Identity] = deriveCodec[Identity]

  implicit val codecReference: Codec[Reference] = deriveCodec[Reference]

  implicit val codecSelector: Codec[Selector] = deriveCodec[Selector]

  implicit def encoderBlock[F[_]: Foldable](implicit encoders: Has[Encoder[_]]): Encoder[Block[F]] = { (writer, block) =>
    implicit val encoderElement: Encoder[block.Type] = encoders[Encoder[block.Type]]

    block
      .elements
      .foldLeft(writer)(_.write(_))
  }

  implicit def encoderEntity[F[_]: Foldable](implicit encoders: Has[Encoder[_]]): Encoder[Entity[F]] = { (writer, entity) =>
    entity
      .blocks
      .foldLeft(writer)(_.write(_))
  }

}
