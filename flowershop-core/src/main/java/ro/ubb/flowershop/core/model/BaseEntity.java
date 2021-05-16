package ro.ubb.flowershop.core.model;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> implements Serializable {


    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
