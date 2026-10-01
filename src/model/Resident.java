package model;

public class Resident {

    private int resident_id;
    private String full_name;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String guardian_name;
    private String guardian_phone;
    private String join_date;
    private int room_id;

    private String username;
    private String password;


    // Empty constructor
    public Resident() {

    }


    // Constructor used by ResidentManagement (without login)
    public Resident(String full_name,
                    String gender,
                    String phone,
                    String email,
                    String address,
                    String guardian_name,
                    String guardian_phone,
                    String join_date,
                    int room_id) {

        this.full_name = full_name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.guardian_name = guardian_name;
        this.guardian_phone = guardian_phone;
        this.join_date = join_date;
        this.room_id = room_id;

    }


    // Constructor with login details
    public Resident(String full_name,
                    String gender,
                    String phone,
                    String email,
                    String address,
                    String guardian_name,
                    String guardian_phone,
                    String join_date,
                    int room_id,
                    String username,
                    String password) {

        this.full_name = full_name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.guardian_name = guardian_name;
        this.guardian_phone = guardian_phone;
        this.join_date = join_date;
        this.room_id = room_id;
        this.username = username;
        this.password = password;

    }


    public int getResident_id() {
        return resident_id;
    }

    public void setResident_id(int resident_id) {
        this.resident_id = resident_id;
    }


    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }


    public String getGuardian_phone() {
        return guardian_phone;
    }

    public void setGuardian_phone(String guardian_phone) {
        this.guardian_phone = guardian_phone;
    }


    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }


    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}