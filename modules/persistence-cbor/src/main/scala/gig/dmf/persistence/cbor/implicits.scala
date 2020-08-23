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

  implicit val CodecIdentity: Codec[Identity] =
    Codec.bimap(
      _.digest,
      Identity(_))

  implicit val CodecReference: Codec[Reference] =
    Codec.bimap(
      _.identities,
      Reference(_))

  implicit val CodecReferences: Codec[References] =
    Codec
      .of[IndexedSeq[Reference]]
      .bimap(
        _.elements,
        References(_))

  implicit val EncoderEntity: Encoder[Entity] =
    Encoder { (writer, entity) =>
      writer
        .writeArrayOpen(1)
        .writeToArray(entity.references)
        .writeArrayClose()
    }

  implicit val DecoderEntity: Decoder[Entity] =
    Decoder { reader =>
      val unbounded = reader.readArrayOpen(1)

      val references = reader.read[References]
      val entity = Entity(
        references
      )

      reader.readArrayClose(unbounded, entity)
    }

}
