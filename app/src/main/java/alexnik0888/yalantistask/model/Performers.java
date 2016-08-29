
package alexnik0888.yalantistask.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;


public class Performers extends RealmObject {

    @SerializedName("id")
    private int id;
    @SerializedName("organization")
    private String organization;
    @SerializedName("person")
    private String person;
    @SerializedName("deadline")
    private int deadline;

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
     *     The organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * 
     * @param organization
     *     The organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * 
     * @return
     *     The person
     */
    public String getPerson() {
        return person;
    }

    /**
     * 
     * @param person
     *     The person
     */
    public void setPerson(String person) {
        this.person = person;
    }

    /**
     * 
     * @return
     *     The deadline
     */
    public int getDeadline() {
        return deadline;
    }

    /**
     * 
     * @param deadline
     *     The deadline
     */
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

}
