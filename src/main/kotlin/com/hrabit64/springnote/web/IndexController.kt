package com.hrabit64.springnote.web


import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Controller("/")
class IndexController {
    @GetMapping
    fun index(model:Model):String{

        return "index"

    }

    @GetMapping("/posts")
    fun posts(model:Model):String{

        return "posts"

    }
}