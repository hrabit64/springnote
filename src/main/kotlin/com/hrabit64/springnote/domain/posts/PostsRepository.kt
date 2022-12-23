package com.hrabit64.springnote.domain.posts

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostsRepository : CrudRepository<Posts,Long>, PostsCustomRepository{

}
