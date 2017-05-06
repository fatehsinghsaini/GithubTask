package saini.fateh.com.githubtask;

import java.io.Serializable;

/**
 * Created by fateh on 6/5/17.
 */

class OrientationModel implements Serializable {

    String name;
    String id;
    String avatar_url;
    String url;

    public OrientationModel(String name, String id, String avatar_url, String url) {
        this.name = name;
        this.id = id;
        this.avatar_url = avatar_url;
        this.url = url;
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

}
