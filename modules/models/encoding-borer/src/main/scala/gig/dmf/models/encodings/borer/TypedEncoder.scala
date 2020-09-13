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

case class TypedEncoderImpl[A](tag: ClassTag[A], encoder: Encoder[A]) extends TypedEncoder {
  override type Type = A
}
