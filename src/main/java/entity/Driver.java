package entity;

import javax.servlet.ServletConfig;

public class Driver {
    private int id_driver;
    private String fio;
    private int pass_seria;
    private int pass_numb;
    private long inn;
    private int licence;
    private int stage;
    private String category;
    private boolean personal_auto;
    private int trip_num;

    public Driver(int id_driver, String fio, int pass_seria, int pass_numb, long inn, int licence, int stage,
           String category, boolean personal_auto, int trip_num) {
        this.id_driver = id_driver;
        this.fio = fio;
        this.pass_seria = pass_seria;
        this.pass_numb = pass_numb;
        this.inn = inn;
        this.licence = licence;
        this.stage = stage;
        this.category = category;
        this.personal_auto = personal_auto;
        this.trip_num = trip_num;
    }

    public Driver(String fio, int pass_seria, int pass_numb, long inn, int licence, int stage,
                  String category, boolean personal_auto, int trip_num) {

        this.fio = fio;
        this.pass_seria = pass_seria;
        this.pass_numb = pass_numb;
        this.inn = inn;
        this.licence = licence;
        this.stage = stage;
        this.category = category;
        this.personal_auto = personal_auto;
        this.trip_num = trip_num;
    }


    public Driver() { }

    public int getIdDriver() {
        return id_driver;
    }
    public void setIdDriver(int id_driver) {
        this.id_driver = id_driver;
    }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getPassSeria() {
        return pass_seria;
    }
    public void setPassSeria(int pass_seria) {
        this.pass_seria = pass_seria;
    }

    public int getPassNumb() {
        return pass_numb;
    }
    public void setPassNumb(int pass_numb) {
        this.pass_numb = pass_numb;
    }

    public long getInn() {
        return inn;
    }
    public void setInn(long inn) {
        this.inn = inn;
    }

    public int getLicence() {
        return licence;
    }
    public void setLicence(int licence) {
        this.licence = licence;
    }

    public int getStage() {
        return stage;
    }
    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getPersonalAuto() {
        return personal_auto;
    }
    public void setPersonalAuto(Boolean personal_auto) {
        this.personal_auto = personal_auto;
    }

    public int getTripNum() {
        return trip_num;
    }
    public void setTripNum(int trip_num) {
        this.trip_num = trip_num;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id_driver=" + id_driver +
                ", fio='" + fio +
                ", pass_seria=" + pass_seria +
                ", pass_numb=" + pass_numb +
                ", inn='" + inn +
                ", licence=" + licence +
                ", stage=" + stage +
                ", category='" + category +
                ", personal_auto=" + personal_auto +
                ", trip_num=" + trip_num +
                '}';
    }

    public void init(ServletConfig servletConfig) {
    }
}