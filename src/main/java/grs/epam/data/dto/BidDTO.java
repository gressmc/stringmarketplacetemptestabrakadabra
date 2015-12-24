package grs.epam.data.dto;

import grs.epam.data.model.Item;
import grs.epam.data.model.User;

public class BidDTO {

    private Integer id;
    private User user;
    private Item item;
    private double bid;

    public BidDTO(Integer id, User user, Item item, double bid) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.bid = bid;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public double getBid() {
        return bid;
    }
}
