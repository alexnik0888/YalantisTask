
package alexnik0888.yalantistask.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;


public class City extends RealmObject {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("ru_name")
    private String ruName;

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
     *     The ruName
     */
    public String getRuName() {
        return ruName;
    }

    /**
     * 
     * @param ruName
     *     The ru_name
     */
    public void setRuName(String ruName) {
        this.ruName = ruName;
    }

}
