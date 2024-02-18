package org.example.info;

import java.util.Date;

public class YoungestEldestWorkers {
    private String name;
    private Date birthday;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday + '}';
    }
}
