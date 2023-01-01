package com.hrabit64.springnote.dto.serviceDto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class PostAddRequestServiceDto (

    var title:String = "",
    var tags:Set<String>? = mutableSetOf(),
    var series:String? = "",
    var contents:String = ""
)
