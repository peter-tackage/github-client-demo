package com.moac.android.mvpgithubclient.api.model;

import com.google.auto.value.AutoValue;
import com.moac.android.mvpgithubclient.api.autovalue.AutoGson;

@AutoValue
@AutoGson(autoValueClass = AutoValue_User.class)
public abstract class User {

    public abstract String login();

    public abstract Integer id();

    public abstract String avatarUrl();

    public abstract String gravatarId();

    public abstract String url();

    public abstract String htmlUrl();

    public abstract String followersUrl();

    public abstract String followingUrl();

    public abstract String gistsUrl();

    public abstract String starredUrl();

    public abstract String subscriptionsUrl();

    public abstract String organizationsUrl();

    public abstract String reposUrl();

    public abstract String eventsUrl();

    public abstract String receivedEventsUrl();

    public abstract String type();

    public abstract Boolean siteAdmin();

    public abstract String name();

    public abstract String company();

    public abstract String blog();

    public abstract String location();

    public abstract String email();

    public abstract Boolean hireable();

    public abstract String bio();

    public abstract Integer publicRepos();

    public abstract Integer publicGists();

    public abstract Integer followers();

    public abstract Integer following();

    public abstract String createdAt();

    public abstract String updatedAt();

    public abstract Integer totalPrivateRepos();

    public abstract Integer ownedPrivateRepos();

    public abstract Integer privateGists();

    public abstract Integer diskUsage();

    public abstract Integer collaborators();

    public abstract Plan plan();

}
