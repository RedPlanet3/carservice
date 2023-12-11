package ru.pryakhina.car_service.exception_handing;

public class IncorrectData {

    private String info;

    public IncorrectData(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
