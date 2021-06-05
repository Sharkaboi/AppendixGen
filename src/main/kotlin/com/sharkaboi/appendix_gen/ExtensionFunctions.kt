package com.sharkaboi.appendix_gen

import java.io.File

fun File.createFile(): Boolean {
    return runCatching { this.createNewFile() }.getOrDefault(false)
}

fun String?.getFileName(): String {
    return (this ?: "appendix") + ".md"
}

fun File.getRelativePathFromBase(base: File): String {
    return runCatching { this.relativeTo(base).path }.getOrDefault(this.path)
}