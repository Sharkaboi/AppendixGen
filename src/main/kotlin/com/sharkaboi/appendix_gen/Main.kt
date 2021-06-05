package com.sharkaboi.appendix_gen

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.context
import com.github.ajalt.clikt.output.Localization
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.versionOption
import java.io.File

class AppendixGen : CliktCommand(
    help = "Generate MarkDown appendix of all files inside current folder.",
    name = "AppendixGen"
) {
    init {
        this.context {
            helpOptionNames = setOf("-h", "--help")
            localization = object : Localization {
                override fun helpOptionMessage(): String {
                    return "View additional info on any command."
                }
            }
        }
        this.versionOption(
            version = "1.0.0",
            help = "Show the current version of AppendixGen."
        )
    }

    private val name: String? by option(help = "Name of generated markdown file. Defaults to appendix.md")

    private val verboseFlag by option(
        "--verbose",
        "-v",
        help = "For showing verbose log of operations."
    ).flag(default = false)

    override fun run() {
        val currentDirectory = System.getProperty("user.dir")
        val dirAsFile = File(currentDirectory)
        if (verboseFlag) {
            echo("Starting from " + dirAsFile.absolutePath)
        }
        val fileName = name.getFileName()
        val mdFilePath = dirAsFile.absolutePath + File.separator + fileName
        val mdFile = File(mdFilePath)
        if (mdFile.exists()) {
            echo("$fileName already exists in ${dirAsFile.absolutePath}.")
        } else {
            val isMDFileCreated: Boolean = mdFile.createFile()
            if (!isMDFileCreated) {
                echo("Could not create $fileName in ${dirAsFile.absolutePath}.")
            } else if (!mdFile.canWrite()) {
                echo("Could not create $fileName in ${dirAsFile.absolutePath}. Check security permissions.")
            } else {
                dirAsFile.walk().forEach {
                    if (it.isFile && it.canRead() && it.absolutePath != mdFilePath && !it.absolutePath.contains(".git")) {
                        val relativePath = it.getRelativePathFromBase(dirAsFile)
                        val content = "# $relativePath  \n```${it.extension}\n${it.readText()}\n```  \n"
                        mdFile.appendText(content)
                        if (verboseFlag) {
                            echo("Written code of $relativePath")
                        }
                    } else if (verboseFlag) {
                        echo("Skipping " + it.absolutePath)
                    }
                }
                echo("Generated $fileName in ${dirAsFile.absolutePath}")
            }
        }
    }
}

fun main(args: Array<String>) = AppendixGen()
    .main(args)