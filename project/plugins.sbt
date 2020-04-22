// Comment to get more information during initialization
logLevel := Level.Warn

addSbtPlugin("com.dwijnand"      % "sbt-dynver"          % "4.0.0")
addSbtPlugin("com.eed3si9n"      % "sbt-buildinfo"       % "0.9.0")
addSbtPlugin("com.typesafe.play" % "sbt-plugin"          % "2.7.0")
addSbtPlugin("com.typesafe.sbt"  % "sbt-digest"          % "1.1.4")
addSbtPlugin("com.typesafe.sbt"  % "sbt-gzip"            % "1.0.2")
addSbtPlugin("com.typesafe.sbt"  % "sbt-native-packager" % "1.3.19")
addSbtPlugin("org.scalameta"     % "sbt-scalafmt"        % "2.3.4")
