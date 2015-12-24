package grs.epam.data.dto;

import grs.epam.data.model.Bid;
import grs.epam.data.model.User;

import java.util.Date;
import java.util.Set;

public class ItemDTO {

    private Integer id;
    private Date startBidingTime;
    private Date timeLeft;
    private Set<Bid> bids;
    private User user;
    private String title;
    private String description;
    private double startPrice;
    private double bidIncrement;
    private boolean buyItNow;
    private boolean isSold;

    public ItemDTO(Integer id, Date startBidingTime, Date timeLeft, Set<Bid> bids, User user, String title, String description, double startPrice, double bidIncrement, boolean buyItNow, boolean isSold) {
        this.id = id;
        this.startBidingTime = startBidingTime;
        this.timeLeft = timeLeft;
        this.bids = bids;
        this.user = user;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidIncrement = bidIncrement;
        this.buyItNow = buyItNow;
        this.isSold = isSold;
    }

    public Integer getId() {
        return id;
    }

    public Date getStartBidingTime() {
        return startBidingTime;
    }

    public Date getTimeLeft() {
        return timeLeft;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public double getBidIncrement() {
        return bidIncrement;
    }

    public boolean isBuyItNow() {
        return buyItNow;
    }

    public boolean isSold() {
        return isSold;
    }
}
