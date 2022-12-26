package com.hrabit64.springnote.domain.comments.subComments

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

//TODO Comments 공통 속성 상속으로 리펙토링 해보기
@Document(value = "sub_comments")
data class SubComments(

    @Id
    @Field("_id")
    var id:Long? = null,

    @NotEmpty
    @Size(max = 4)
    @Field("nick_name")
    var nickName:String = "None",

    @NotEmpty
    @Size(min = 1, max = 2000000)
    @Field("contents")
    var contents:String = "본문이 없습니다.",

    @NotEmpty
    @Size(max = 1000)
    @Field("ip")
    @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\$")
    var ip:String = "0.0.0.0")