import com.typesafe.sbt.packager.docker.{DockerChmodType, DockerPermissionStrategy}

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
  "com.typesafe.play" %% "play"                  % "2.8.1",
  "com.typesafe.play" %% "play-json"             % "2.8.1",
  "com.typesafe.play" %% "play-slick"            % "5.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
  "org.xerial"        % "sqlite-jdbc"            % "3.30.1",
  "org.specs2"        %% "specs2-junit"          % "4.9.3" % Test,
  "org.specs2"        %% "specs2-core"           % "4.9.3" % Test,
  "org.specs2"        %% "specs2-mock"           % "4.9.3" % Test,
  filters,
  guice,
  ws
)
