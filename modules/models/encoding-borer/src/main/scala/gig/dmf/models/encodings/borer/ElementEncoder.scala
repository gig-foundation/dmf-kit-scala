package gig.dmf.models.encodings.borer

import implicits._
import gig.dmf.models.common.Element
import gig.dmf.models.common.Reference
import gig.dmf.models.common.Selector
import gig.dmf.models.encodings.borer.ElementEncoder.EncoderNotFound
import io.bullet.borer.Encoder
import io.bullet.borer.Writer

import scala.reflect.ClassTag

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 07, 2020
 */
case class ElementEncoder(encoders: Set[TaggedEncoder]) extends Encoder[Element] {

  private val encodersByTag: Map[ClassTag[_], TaggedEncoder] =
    encoders
      .map(encoder => (encoder.tag, encoder))
      .toMap

  override def write(writer: Writer, value: Element) =
    value match {

      case reference: Reference =>
        Encoder[Reference]
          .write(writer, reference)

      case selector: Selector =>
        Encoder[Selector]
          .write(writer, selector)

      case _ =>
        encodersByTag
          .get(ClassTag(value.getClass))
          .flatMap(te =>
            te.tag
              .unapply(value)
              .map(te.encoder.write(writer, _)))
          .getOrElse(throw EncoderNotFound(value))

    }

}

object ElementEncoder {

  case class EncoderNotFound[A](value: A) extends IllegalStateException(s"No encoder for $value.")

  implicit class Ops(val self: ElementEncoder) extends AnyVal {

    def :+[A <: Element: ClassTag](encoder: Encoder[A]): ElementEncoder =
      self :+ TaggedEncoder(encoder)

    def :+[A <: Element](encoder: TaggedEncoder): ElementEncoder =
      self.copy(self.encoders + encoder)

  }

}
