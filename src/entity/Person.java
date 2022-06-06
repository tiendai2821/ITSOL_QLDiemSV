package entity;

import java.io.Serializable;

public class Person implements Serializable {
    protected String name, address, phonenum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
