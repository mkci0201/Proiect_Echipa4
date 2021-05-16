package ro.ubb.flowershop.core.model;

public class Order extends BaseEntity<Integer>{

    private Employee username;
    private String date;
    private OrderStatus statusId;

    public Order(Employee username, String date, OrderStatus statusId) {
        this.username = username;
        this.date = date;
        this.statusId = statusId;
    }

    public Employee getUsername() {
        return username;
    }

    public void setUsername(Employee username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(OrderStatus statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "username=" + username +
                ", date='" + date + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}
