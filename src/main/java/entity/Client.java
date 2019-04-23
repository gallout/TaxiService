package entity;

public class Client {

    private int id_client;
    private String fio;
    private String address;
    private long contact_num;

    public Client(int id_client,String fio, String address, long contact_num) {
        this.id_client = id_client;
        this.fio = fio;
        this.address = address;
        this.contact_num = contact_num;
    }
    public Client(String fio, String address, long contact_num) {
        this.fio = fio;
        this.address = address;
        this.contact_num = contact_num;
    }
    public Client() {
    }

    public int getIdClient() {
        return id_client;
    }
    public void setIdClient(int id_client) {
        this.id_client = id_client;
    }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactNum() {
        return contact_num;
    }
    public void setContactNum(long contact_num) {
        this.contact_num = contact_num;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", fio='" + fio +
                ", address=" + address +
                ", contact_num=" + contact_num +
                '}';
    }
}