organization := "com.github.biopet"
organizationName := "Biopet"

startYear := Some(2018)

name := "SeattleSeqKit"
biopetUrlName := "seattleseqkit"

biopetIsTool := true

mainClass in assembly := Some("nl.biopet.tools.seattleseqkit.SeattleSeqKit")

developers += Developer(id = "ffinfo",
                        name = "Peter van 't Hof",
                        email = "pjrvanthof@gmail.com",
                        url = url("https://github.com/ffinfo"))

biocondaTestCommands := Seq(
  "biopet-seattleseqkit filter --help",
  "biopet-seattleseqkit filter --version",
  "biopet-seattleseqkit mergegenes --help",
  "biopet-seattleseqkit mergegenes --version"
)
scalaVersion := "2.11.12"

libraryDependencies += "com.github.biopet" %% "tool-utils" % "0.6"
libraryDependencies += "com.github.biopet" %% "tool-test-utils" % "0.3"
libraryDependencies += "com.github.biopet" %% "ngs-utils" % "0.6"
