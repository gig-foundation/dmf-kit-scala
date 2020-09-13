package gig.dmf.models.encodings.borer

import io.bullet.borer.Encoder

import scala.reflect.ClassTag

/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 07, 2020
 */
sealed trait TypedEncoder {
  type Type
  def tag: ClassTag[Type]
  def encoder: Encoder[Type]
}

object TypedEncoder {

  private case class Default[A](tag: ClassTag[A], encoder: Encoder[A]) extends TypedEncoder {
    override type Type = A
  }

  def unapply(encoder: TypedEncoder) =
    encoder match {
      case Default(tag, encoder) => Some((tag, encoder))
    }

  def apply[A](tag: ClassTag[A], encoder: Encoder[A]): TypedEncoder =
    Default(tag, encoder)

}
