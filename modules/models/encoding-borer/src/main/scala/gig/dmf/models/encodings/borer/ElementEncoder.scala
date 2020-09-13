package gig.dmf.models.encodings.borer

import implicits._
import gig.dmf.models.common.Element
import gig.dmf.models.common.Reference
import gig.dmf.models.common.Selector
import io.bullet.borer.Encoder
import io.bullet.borer.Writer

import scala.reflect.ClassTag

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 07, 2020
 */
case class ElementEncoder(encoders: Map[Class[_], TypedEncoder]) extends Encoder[Element] {

  override def write(writer: Writer, value: Element) =
    value match {

      case reference: Reference =>
        Encoder[Reference]
          .write(writer, reference)

      case selector: Selector =>
        Encoder[Selector]
          .write(writer, selector)

      case _ =>
        encoders
          .get(value.getClass)
          .flatMap {
            case TypedEncoderImpl(tag, encoder) =>
              tag
                .unapply(value)
                .map(encoder.write(writer, _))
          }
          .getOrElse(???)

    }

}

object ElementEncoder {

  implicit class Ops(val self: ElementEncoder) extends AnyVal {
    def :+[A <: Element](encoder: Encoder[A])(implicit A: ClassTag[A]): ElementEncoder =
      self.copy(self.encoders.updated(A.runtimeClass, TypedEncoderImpl(A, encoder)))
  }

}
