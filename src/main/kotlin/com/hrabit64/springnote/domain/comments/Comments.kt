//package com.hrabit64.springnote.domain.comments
//
//import jakarta.validation.constraints.NotEmpty
//import jakarta.validation.constraints.Pattern
//import jakarta.validation.constraints.Size
//import org.springframework.data.annotation.Id
//import org.springframework.data.mongodb.core.mapping.Document
//import org.springframework.data.mongodb.core.mapping.Field
//
//open class Comments (@Id
//                     @Field("_id")
//                     val id:Long? = null,
//
//                     @NotEmpty
//                     @Size(min = 1, max = 2000000)
//                     @Field("contents")
//                     val contents:String = "본문이 없습니다.",
//
//                     @NotEmpty
//                     @Size(max = 1000)
//                     @Field("ip")
//                     @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\$")
//                     val ip:String = "0.0.0.0"
//)