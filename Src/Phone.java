public class Phone {
    private int id;
    private String phone;
    private boolean fax;
    
    public Phone() {
    }

    public boolean isFax() {
        return fax;
    }

    public void setFax(boolean fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
