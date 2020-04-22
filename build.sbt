import com.typesafe.sbt.packager.docker.{ DockerChmodType, DockerPermissionStrategy }

name := "cerebro"
scalaVersion := "2.12.11"

enablePlugins(BuildInfoPlugin, JavaServerAppPackaging, LauncherJarPlugin, PlayScala)

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)
buildInfoPackage := "models"

maintainer := "sirocchj"

pipelineStages := Seq(digest, gzip)

Compile / doc / sources := Seq.empty

dockerBaseImage := "openjdk:11.0.7-jre-slim"
dockerChmodType := DockerChmodType.UserGroupWriteExecute
dockerExposedPorts := Seq(9000)
dockerPermissionStrategy := DockerPermissionStrategy.Run
dockerUpdateLatest := true
dockerUsername := Some("sirocchj")
Docker / daemonUser := "cerebro"
Docker / version := version.value.replace("+", "-") // '+' is an invalid in Docker image tag string

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play"                  % "2.7.0",
  "com.typesafe.play" %% "play-json"             % "2.7.2",
  "com.typesafe.play" %% "play-slick"            % "4.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "4.0.0",
  "org.xerial"        %  "sqlite-jdbc"           % "3.23.1",
  "org.specs2"        %% "specs2-junit"          % "4.3.4" % Test,
  "org.specs2"        %% "specs2-core"           % "4.3.4" % Test,
  "org.specs2"        %% "specs2-mock"           % "4.3.4" % Test,
  filters,
  guice,
  ws
)
