package com.hrabit64.springnote.config.security

import java.util.*

class OAuthAttributes (

    val oauthID:String,
    val attributes:Map<String,Objects>,
    val nameAttributeKey:String)
{
    companion object{

        fun of(registrationId:String,
                    userNameAttributeName:String,
                    attributes:Map<String,Objects>):OAuthAttributes{

            return ofGithub(userNameAttributeName,attributes)
        }

        fun ofGithub(userNameAttributeName:String,attributes:Map<String,Objects>):OAuthAttributes{
            return OAuthAttributes(
                oauthID = attributes[userNameAttributeName].toString(),
                nameAttributeKey = userNameAttributeName,
                attributes = attributes
            )
        }
    }

}