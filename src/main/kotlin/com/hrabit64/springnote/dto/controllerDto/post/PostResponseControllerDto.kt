package com.hrabit64.springnote.dto.controllerDto.post

import com.hrabit64.springnote.utlis.annotaion.validation.setSize.CheckSetSize
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class PostResponseControllerDto (

    @Size(max=40, message = "title 은 최대 40자까지 설정 가능합니다.")
    @NotEmpty(message = "title 필드는 필수입니다.")
    var title:String = "",

    @CheckSetSize(max=5, message = "tags 에 입력가능한 갯수는 최대 5개 입니다.")
    var tags:Set<String>? = mutableSetOf(),

    @Size(max=40, message = "series는 최대 40자까지 설정 가능합니다.")
    var series:String? = "",

    @Size(max=20000, message = "contents는 최대 20000자까지 설정 가능합니다.")
    @NotEmpty(message = "contents 필드는 필수입니다.")
    var contents:String = ""
)
