package gig.dmf.canonical.encodings.cbor

import gig.dmf.canonical.encodings.implicits._
import gig.dmf.canonical.encodings.Canonical
import gig.dmf.canonical.encodings.Canonical.CanonicalBlock
import gig.dmf.canonical.encodings.Canonical.CanonicalEntity
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

//implicit val EncoderRange: Encoder[Range] =
//  Encoder { (writer, range) =>
//    writer.writeArrayOpen(3)
//    writer.writeInt(range.start)
//    writer.writeInt(range.end)
//    writer.writeInt(range.step)
//    writer.writeArrayClose()
//  }
//
//implicit val DecoderRange: Decoder[Range] =
//  Decoder { reader =>
//    val unbounded = reader.readArrayOpen(3)
//    val start = reader.readInt()
//    val end = reader.readInt()
//    val step = reader.readInt()
//    val range = Range(start, end, step)
//    reader.readArrayClose(unbounded, range)
//  }
//
//implicit val codecIdentity: Codec[Identity] = Codec.of[Array[Byte]].bimap(_.digest, Identity(_))

  //implicit def codecElement[A <: Element]: Codec[A] = ???

  implicit def decoderBlock: Decoder[Block with Canonical] = ???
  //  deriveDecoder[CanonicalBlock[A]].map(identity[Block with Canonical])

  implicit def encoderBlock: Encoder[Block with Canonical] = ???
  //  deriveEncoder[CanonicalBlock[A]].contramap {
  //    case block: CanonicalBlock[_] => block
  //  }

  implicit val decoderEntity: Decoder[Entity with Canonical] =
    deriveDecoder[CanonicalEntity].map(identity[Entity with Canonical])

  implicit val encoderEntity: Encoder[Entity with Canonical] =
    deriveEncoder[CanonicalEntity].contramap {
      case entity: CanonicalEntity => entity
    }

}
