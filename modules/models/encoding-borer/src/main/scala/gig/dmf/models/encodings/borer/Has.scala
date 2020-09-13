package gig.dmf.models.encodings.borer

import scala.reflect.ClassTag

// TODO: Give credit to ZIO project for pattern.
/**
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 * @since September 13, 2020
 */
case class Has[_] private (private val values: Map[ClassTag[_], _])
object Has {

  implicit class Ops[Self <: Has[_]](private val self: Self) extends AnyVal {
    import self.values

    def add[B: ClassTag](b: B): Self with Has[B] =
      new Has(values ++ Has(b).values)
        .asInstanceOf[Self with Has[B]]

    def apply[B](implicit tag: ClassTag[B]): B =
      values(tag)
        .asInstanceOf[B]

    def get[B](implicit tag: ClassTag[B]): Option[B] =
      values.get(tag)
        .map(_.asInstanceOf[B])

  }

  def apply[A](a: A)(implicit tag: ClassTag[A]): Has[A] =
    new Has(Map((tag, a)))

  def apply[A: ClassTag, B: ClassTag](a: A, b: B): Has[A] with Has[B] =
    Has(a).add(b)

}
