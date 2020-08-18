package com.framework.entities


import com.fasterxml.jackson.annotation.JsonProperty

data class FullUserObject(
    @JsonProperty("avatar_url")
    var avatarUrl: String?,
    @JsonProperty("bio")
    var bio: String?,
    @JsonProperty("blog")
    var blog: String?,
    @JsonProperty("company")
    var company: Any?,
    @JsonProperty("created_at")
    var createdAt: String?,
    @JsonProperty("email")
    var email: Any?,
    @JsonProperty("events_url")
    var eventsUrl: String?,
    @JsonProperty("followers")
    var followers: Int?,
    @JsonProperty("followers_url")
    var followersUrl: String?,
    @JsonProperty("following")
    var following: Int?,
    @JsonProperty("following_url")
    var followingUrl: String?,
    @JsonProperty("gists_url")
    var gistsUrl: String?,
    @JsonProperty("gravatar_id")
    var gravatarId: String?,
    @JsonProperty("hireable")
    var hireable: Any?,
    @JsonProperty("html_url")
    var htmlUrl: String?,
    @JsonProperty("id")
    var id: Int?,
    @JsonProperty("location")
    var location: Any?,
    @JsonProperty("login")
    var login: String?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("node_id")
    var nodeId: String?,
    @JsonProperty("organizations_url")
    var organizationsUrl: String?,
    @JsonProperty("public_gists")
    var publicGists: Int?,
    @JsonProperty("public_repos")
    var publicRepos: Int?,
    @JsonProperty("received_events_url")
    var receivedEventsUrl: String?,
    @JsonProperty("repos_url")
    var reposUrl: String?,
    @JsonProperty("site_admin")
    var siteAdmin: Boolean?,
    @JsonProperty("starred_url")
    var starredUrl: String?,
    @JsonProperty("subscriptions_url")
    var subscriptionsUrl: String?,
    @JsonProperty("twitter_username")
    var twitterUsername: Any?,
    @JsonProperty("type")
    var type: String?,
    @JsonProperty("updated_at")
    var updatedAt: String?,
    @JsonProperty("url")
    var url: String?
)