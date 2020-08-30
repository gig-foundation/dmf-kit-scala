package gig.dmf.persistence.cbor

import gig.dmf.core.Identity
import gig.dmf.persistence._
import io.bullet.borer._

import scala.collection.immutable._

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since August 22, 2020
 */
object implicits {

//implicit val CodecIdentity: Codec[Identity] =
//  Codec
//    .bimap(
//      _.digest,
//      Identity(_))
//
//implicit val CodecReference: Codec[Reference] =
//  Codec
//    .bimap[Iterable[Identity], Reference](
//      _.identities,
//      Reference(_))
//
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
//implicit val CodecSelector: Codec[Selector] =
//  Codec
//    .bimap[Iterable[Range], Selector](
//      _.ranges,
//      Selector(_))
//
//implicit val EncoderEntity: Encoder[Entity] =
//  Encoder { (writer, entity) =>
//    writer
//      .writeArrayOpen(entity.blocks.size)
//      .writeIterator(entity.blocks)
//      .writeArrayClose()
//  }
//
//implicit val DecoderEntity: Decoder[Entity] =
//  Decoder { reader =>
//    val unbounded = reader.readArrayStart()
//
//    reader.read
//
//    reader.readArrayClose(unbounded, ???)
//  }

}
