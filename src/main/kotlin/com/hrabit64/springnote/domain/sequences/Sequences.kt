package com.hrabit64.springnote.domain.sequences

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(value = "sequences")
class Sequences (

    @Id
    @Field("_id")
    var id:String = "",

    @NotEmpty
    @Size(min = 0)
    @Field("seq")
    var seq:Int = 0)

{

}