package com.hrabit64.springnote.domain.posts

import com.hrabit64.springnote.domain.comments.mainComments.MainComments
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document(value = "Posts")
data class Posts(
    @Id
    @Field("_id")
    var id:Long? = null,

    @NotEmpty
    @Size(min = 1 ,max = 50)
    @Field("title")
    var title:String = "이름 없는 게시글 입니다.",

    @Size(max = 5)
    @Field("tags")
    var tags: Set<String> = mutableSetOf(),


    @Size(max = 100)
    @Field("series")
    var series:String? = null,

    @NotEmpty
    @Size(min = 1, max = 2000000)
    @Field("contents")
    var contents:String = "본문이 없습니다.",

    @Size(max = 500)
    @Field("comments")
    var comments:Set<MainComments> = mutableSetOf(),

    @Size(max = 1000)
    @Field("comments_seq")
    var commentsSeq:Int = 1)
{

  fun update(title: String, tags: Set<String>, series: String?){
      this.title = title
      this.tags = tags
      this.series = series
  }

}



