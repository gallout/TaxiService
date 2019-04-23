package entity;

public class Operator {

    private int id_operator;
    private String fio;
    private String adress;
    private long contact_num;

    public Operator(int id_operator, String fio, String adress, long contact_num) {
        this.id_operator = id_operator;
        this.fio = fio;
        this.adress = adress;
        this.contact_num = contact_num;
    }


    public Operator(String fio, String adress, long contact_num) {
        this.id_operator = id_operator;
        this.fio = fio;
        this.adress = adress;
        this.contact_num = contact_num;
    }

    public Operator() {
    }

    public int getIdOperator() {
        return id_operator;
    }
    public void setIdOperator(int id_operator) {
        this.id_operator = id_operator;
    }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return adress;
    }
    public void setAddress(String adress) {
        this.adress = adress;
    }

    public long getContactNum() {
        return contact_num;
    }
    public void setContactNum(long contact_num) {
        this.contact_num = contact_num;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id_operator=" + id_operator +
                ", fio='" + fio +
                ", adress=" + adress +
                ", contact_num=" + contact_num +
                '}';
    }
}