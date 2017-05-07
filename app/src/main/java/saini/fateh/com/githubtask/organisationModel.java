package saini.fateh.com.githubtask;

/**
 * Created by fateh on 6/5/17.
 */

class OrientationModel {

    String name;
    String id;
    String avatar_url;
    String url;
    String type;
    String score;
    String followers_url;
    String gists_url;
    String subscriptions_url;
    String organizations_url;
    String repos_url;
    String events_url;

    public OrientationModel(String name, String id, String avatar_url, String url, String type, String score
            , String followers_url, String gists_url, String subscriptions_url, String organizations_url, String repos_url, String events_url) {
        this.name = name;
        this.id = id;
        this.avatar_url = avatar_url;
        this.url = url;
        this.type = type;
        this.score = score;
        this.followers_url = followers_url;
        this.gists_url = gists_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getUrl() {
        return url;
    }


    public String getType() {
        return type;
    }

    public String getScore() {
        return score;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }
}
