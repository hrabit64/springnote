package com.hrabit64.springnote.utlis.convert

import org.springframework.stereotype.Component
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

@Component
class MarkdownToHtmlConverter(
    val parser: Parser = Parser.builder().build(),
    val renderer:HtmlRenderer = HtmlRenderer.builder().build())
{
    fun convert(markdownString:String):String{

        val document: Node = parser.parse(markdownString)
        return renderer.render(document)
    }
}