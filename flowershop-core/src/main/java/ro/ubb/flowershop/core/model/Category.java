package ro.ubb.flowershop.core.model;

public class Category extends BaseEntity<Integer>{


    private String name;

    public Category(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

}
