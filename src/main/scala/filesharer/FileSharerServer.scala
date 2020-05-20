package filesharer

import cats.effect.{ConcurrentEffect, ContextShift, ExitCode, Timer}
import fs2.Stream
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.middleware.Logger

object FileSharerServer {

  def stream[F[_]: ConcurrentEffect](
      implicit T: Timer[F],
      C: ContextShift[F]
  ): Stream[F, ExitCode] = {

    // Combine Service Routes into an HttpApp.
    // Can also be done via a Router if you
    // want to extract a segments not checked
    // in the underlying routes.
    val httpApp =
      FileSharerRoutes.uploadRoutes[F](UploadFile.impl[F]).orNotFound

    // With Middlewares in place
    val finalHttpApp =
      Logger.httpApp(logHeaders = true, logBody = true)(httpApp)

    BlazeServerBuilder[F]
      .bindHttp(8080, "0.0.0.0")
      .withHttpApp(finalHttpApp)
      .serve
  }
}