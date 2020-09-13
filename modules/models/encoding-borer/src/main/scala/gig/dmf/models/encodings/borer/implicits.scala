package gig.dmf.models.encodings.borer

import gig.dmf.ByteString
import gig.dmf.canonical.encodings.implicits._
import gig.dmf.canonical.encodings.Canonical
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

  implicit val EncoderRange: Encoder[Range] =
    Encoder { (writer, range) =>
      writer.writeArrayOpen(3)
      writer.writeInt(range.start)
      writer.writeInt(range.end)
      writer.writeInt(range.step)
      writer.writeArrayClose()
    }

  implicit val DecoderRange: Decoder[Range] =
    Decoder { reader =>
      val unbounded = reader.readArrayOpen(3)
      val start = reader.readInt()
      val end = reader.readInt()
      val step = reader.readInt()
      val range = Range(start, end, step)
      reader.readArrayClose(unbounded, range)
    }

  implicit val CodecByteString: Codec[ByteString] =
    Codec.of[Array[Byte]]
      .bimap(_.toArray, ByteString(_))

  implicit val CodecIdentity: Codec[Identity] = deriveCodec[Identity]

  implicit val CodecReference: Codec[Reference] = deriveCodec[Reference]

  implicit val CodecSelector: Codec[Selector] = deriveCodec[Selector]

  sealed trait Functor[F[_]] {
    def leftFold[A, B](y: B)(xs: F[A], f: (B, A) => B): B
  }

  implicit object IndexSeqFunctor extends Functor[IndexedSeq] {
    override def leftFold[A, B](y: B)(xs: IndexedSeq[A], f: (B, A) => B): B =
      xs.foldLeft(y)(f(_, _))
  }

}
