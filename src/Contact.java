public class Contact {
    private String name;
    private Long phone;

//    creating constructor
    public Contact(String userInputName, Long userInputPhone) {
        this.name = userInputName;
        this.phone = userInputPhone;
    }
//getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String toString() {
        return this.getName() + "--" + this.getPhone();
    }

}
