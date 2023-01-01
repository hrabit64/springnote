package com.hrabit64.springnote.web

import com.hrabit64.springnote.dto.controllerDto.post.PostAddRequestControllerDto
import com.hrabit64.springnote.dto.controllerDto.post.PostResponseControllerDto
import com.hrabit64.springnote.utlis.convert.MarkdownToHtmlConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController("/api/v1/post")
class PostApiController (@Autowired val markdownToHtmlConverter: MarkdownToHtmlConverter){

//    @PostMapping
//    fun addPost(@RequestBody request:PostAddRequestControllerDto):ResponseEntity<PostResponseControllerDto>{
//
//        val convertedContents:String = markdownToHtmlConverter.convert(request.contents)
//
//    }
}