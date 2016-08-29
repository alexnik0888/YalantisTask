
package alexnik0888.yalantistask.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;


public class StreetType extends RealmObject {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("short_name")
    private String shortName;

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 
     * @param shortName
     *     The short_name
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
