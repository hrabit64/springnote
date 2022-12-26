package com.hrabit64.springnote.config.security

import com.hrabit64.springnote.utlis.log.Log
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.OAuth2Error
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomOAuth2UserService : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    companion object : Log()

    @Value("springnote.security.admin_uid")
    var adminUID:String = ""

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {

        val delegate:OAuth2UserService<OAuth2UserRequest,OAuth2User> = DefaultOAuth2UserService()
        val oauth2User:OAuth2User = delegate.loadUser(userRequest)

        val registrationID:String = userRequest?.clientRegistration?.registrationId ?: "None"

        if(registrationID != "github"){
            throw OAuth2AuthenticationException(OAuth2Error("invalid_registrationID", "you can only use github for registrationID ", ""));
        }

        val userNameAttributeName: String = userRequest?.clientRegistration?.providerDetails?.userInfoEndpoint?.userNameAttributeName ?: "None"

        if(userNameAttributeName == "None"){
            throw OAuth2AuthenticationException(OAuth2Error("invalid_userNameAttributeName", "cannot find user name attribute name", ""));
        }

        val attributes:OAuthAttributes = OAuthAttributes.of(registrationID,
            userNameAttributeName,
            oauth2User.attributes as Map<String, Objects>)

        if(attributes.oauthID != adminUID){
            logger.info("UID = {} Try login. but this is not owner uid.",attributes.oauthID)
            throw OAuth2AuthenticationException(OAuth2Error("invalid_user", "your not this blog owner", ""));
        }

        logger.info("UID = {} Try login. Successfully check uid. Welcome!",attributes.oauthID)


        return DefaultOAuth2User(Collections.singleton(SimpleGrantedAuthority("ROLE_OWNER")),attributes.attributes, attributes.nameAttributeKey)
    }
}