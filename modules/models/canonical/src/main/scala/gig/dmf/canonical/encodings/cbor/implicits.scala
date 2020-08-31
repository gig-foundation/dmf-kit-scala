package gig.dmf.canonical.encodings.cbor

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
//implicit val codecElement: Codec[Element] = deriveAllCodecs[Element]
//implicit val codecBlock: Codec[Block] = deriveAllCodecs[Block]
//implicit val codecEntity: Codec[Entity] = deriveCodec[Entity]

}
