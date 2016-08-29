
package alexnik0888.yalantistask.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;


public class User extends RealmObject {

    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("middle_name")
    private String middleName;
    @SerializedName("email")
    private String email;
    @SerializedName("birthday")
    private int birthday;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private Address address;
    @SerializedName("fb_registered")
    private int fbRegistered;

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
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * 
     * @param middleName
     *     The middle_name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The birthday
     */
    public int getBirthday() {
        return birthday;
    }

    /**
     * 
     * @param birthday
     *     The birthday
     */
    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The fbRegistered
     */
    public int getFbRegistered() {
        return fbRegistered;
    }

    /**
     * 
     * @param fbRegistered
     *     The fb_registered
     */
    public void setFbRegistered(int fbRegistered) {
        this.fbRegistered = fbRegistered;
    }

}
