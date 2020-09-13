package gig.dmf.models.encodings.borer

import cats.syntax.option._
import io.bullet.borer.Encoder
import io.bullet.borer.Writer

import scala.reflect.ClassTag

/**
 * Supports composition of [[Encoder]] instances at runtime, allowing for third-party registration.
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 07, 2020
 */
sealed trait TaggedEncoder {
  type Type
  def tag: ClassTag[Type]
  def encoder: Encoder[Type]
}

object TaggedEncoder {

  private case class Default[A](tag: ClassTag[A], encoder: Encoder[A]) extends TaggedEncoder {
    override type Type = A
  }

  def apply[A: ClassTag](encoder: Encoder[A]): TaggedEncoder =
    Default(implicitly[ClassTag[A]], encoder)

}
