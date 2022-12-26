package com.hrabit64.springnote.utlis.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Log {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)
}