/*
 * Copyright (c) 2018 Biopet
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package nl.biopet.tools.seattleseqkit.multifilter

import java.io.File

import nl.biopet.utils.tool.{AbstractOptParser, ToolCommand}

class ArgsParser(toolCommand: ToolCommand[Args])
    extends AbstractOptParser[Args](toolCommand) {
  opt[(String, File)]('i', "inputFile")
    .required()
    .unbounded()
    .action((x, c) => c.copy(inputFiles = c.inputFiles + x))
    .text("Seattle seq input file")
  opt[File]('o', "outputDir")
    .required()
    .action((x, c) => c.copy(outputDir = x))
    .text("Output directory")
  opt[Int]("multiSampleTreshold")
    .action((x, c) => c.copy(multiSampleTreshold = x))
    .text(
      s"Minimal number of samples per gene, default: ${Args().multiSampleTreshold}")
  opt[File]("geneColapseOutput")
    .action((x, c) => c.copy(geneColapseOutput = Some(x)))
    .text("Output file to count per gene hits")
  opt[(String, File)]("intervals")
    .unbounded()
    .action((x, c) => c.copy(intervals = c.intervals + x))
    .text("Intervals bed file")
  opt[(String, String)]("fieldMustContain")
    .action((x, c) => c.copy(fieldMustContain = x :: c.fieldMustContain))
    .text("Field must contain given text")
    .valueName("<key>=<text>")
  opt[(String, Double)]("fieldMustBeBelow")
    .action((x, c) => c.copy(fieldMustBeBelow = x :: c.fieldMustBeBelow))
    .text("Field must be below given numeric value")
    .valueName("<key>=<double>")
}
