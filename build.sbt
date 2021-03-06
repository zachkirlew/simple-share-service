val Http4sVersion       = "0.21.3"
val CirceVersion        = "0.13.0"
val Specs2Version       = "4.9.3"
val LogbackVersion      = "1.2.3"
val Fs2BlobstoreVersion = "0.7.2"
val PureconfigVersion   = "0.12.3"
val DoobieVersion       = "0.8.8"

lazy val root = (project in file("."))
  .settings(
    organization := "com.zachkirlew",
    name := "file-sharer",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      "org.http4s"               %% "http4s-blaze-server"    % Http4sVersion,
      "org.http4s"               %% "http4s-blaze-client"    % Http4sVersion,
      "org.http4s"               %% "http4s-circe"           % Http4sVersion,
      "org.http4s"               %% "http4s-dsl"             % Http4sVersion,
      "io.circe"                 %% "circe-generic"          % CirceVersion,
      "org.specs2"               %% "specs2-core"            % Specs2Version % "test",
      "ch.qos.logback"           % "logback-classic"         % LogbackVersion,
      "com.github.fs2-blobstore" %% "core"                   % Fs2BlobstoreVersion,
      "com.github.fs2-blobstore" %% "gcs"                    % Fs2BlobstoreVersion,
      "com.github.pureconfig"    %% "pureconfig"             % PureconfigVersion,
      "com.github.pureconfig"    %% "pureconfig-cats-effect" % PureconfigVersion,
      "org.tpolecat"             %% "doobie-core"            % DoobieVersion,
      "org.tpolecat"             %% "doobie-h2"              % DoobieVersion
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.10.3"),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1")
  )

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Xfatal-warnings",
)
