package com.hrabit64.springnote.service

import com.hrabit64.springnote.dto.controllerDto.post.PostResponseControllerDto
import com.hrabit64.springnote.dto.serviceDto.PostAddRequestServiceDto
import com.hrabit64.springnote.dto.serviceDto.PostResponseServiceDto
import com.hrabit64.springnote.dto.serviceDto.PostUpdateRequestServiceDto
import org.springframework.data.domain.Page

interface PostsService {

    fun addPost(postAddRequestServiceDto: PostAddRequestServiceDto):PostResponseServiceDto
    fun deletePostById(id:Int):PostResponseServiceDto
    fun updatePostById(id: Int,postUpdateRequestControllerDto: PostUpdateRequestServiceDto):PostResponseServiceDto

    fun findPostById(id:Int):PostResponseServiceDto
    fun findPostByTitle(title:String): Page<PostResponseServiceDto>
    fun findPostBySeries(series:String): Page<PostResponseServiceDto>
    fun findPostByTag(tag:String): Page<PostResponseServiceDto>
    fun findPostByContent(content:String): Page<PostResponseServiceDto>

}