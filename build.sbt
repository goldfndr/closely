name := "closely"

enablePlugins(PlayScala, GitVersioning)

disablePlugins(PlayLayoutPlugin)

libraryDependencies += ws

routesGenerator := InjectedRoutesGenerator

pipelineStages := Seq(rjs, digest, gzip)

scalaVersion := "2.11.7"

herokuAppName in Compile := "closely"

herokuProcessTypes in Compile := Map(
  "web" -> ("target/universal/stage/bin/" ++ name.value ++ " -Dhttp.port=$PORT -Dplay.crypto.secret=$SECRET")
)

RjsKeys.paths += "routes" -> ("routes", "empty:")

excludeDependencies += SbtExclusionRule("com.google.inject.extensions", "guice-assistedinject")