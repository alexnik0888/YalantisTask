package alexnik0888.yalantistask.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FBProfile extends RealmObject {

    @PrimaryKey
    private String id;

    private String firstName;

    private String lastName;

    private String linkUri;


    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLinkUri() {
        return linkUri;
    }

    public void setLinkUri(String linkUri) {
        this.linkUri = linkUri;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        FBProfile fbProfile = (FBProfile) object;

        return id.equals(fbProfile.id);

    }
}
