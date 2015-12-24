package grs.epam.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ITEMS")
@NamedQuery(name = "Item.getAll", query = "SELECT it FROM Item it")
public class Item extends AbstractModel<Integer> implements Identified<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PK_ITEMS_SEQ")
    @SequenceGenerator(name="PK_ITEMS_SEQ", sequenceName="PK_ITEMS_SEQ", allocationSize=1)
    @Column(name="ID")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_BIDDING_TIME")
    private Date startBidingTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_LEFT")
    private Date timeLeft;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<Bid> bids;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "SELLER_ID")
    private User user;

    private String title;
    private String description;

    @Column(name = "START_PRICE")
    private double startPrice;
    @Column(name = "BID_INCREMENT")
    private double bidIncrement;
    @Column(name = "BUY_IT_NOW")
    private boolean buyItNow;
    @Column(name = "SOLD")
    private boolean isSold;

    public Item(){}

    public void addBid(Bid bid){
        bid.setItem(this);
        bids.add(bid);
    }

    @Override
    public Integer getId() {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartBidingTime() {
        return startBidingTime;
    }

    public void setStartBidingTime(Date startBidingTime) {
        this.startBidingTime = startBidingTime;
    }

    public Date getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Date timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getBidIncrement() {
        return bidIncrement;
    }

    public void setBidIncrement(double bidIncrement) {
        this.bidIncrement = bidIncrement;
    }

    public boolean isBuyItNow() {
        return buyItNow;
    }

    public void setBuyItNow(boolean buyItNow) {
        this.buyItNow = buyItNow;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    public static Builder newBuilder() {
        return new Item().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder setUserTitle(String title) {
            Item.this.title = title;
            return this;
        }
        public Builder setUserDescription(String description) {
            Item.this.description = description;
            return this;
        }
        public Builder setUserStartBidingTime(Date startBidingTime) {
            Item.this.startBidingTime = startBidingTime;
            return this;
        }
        public Builder setUserStartPrice(double startPrice) {
            Item.this.startPrice = startPrice;
            return this;
        }
        public Builder setUserBidIncrement(double bidIncrement) {
            Item.this.bidIncrement = bidIncrement;
            return this;
        }
        public Builder setUserTimeLeft(Date timeLeft) {
            Item.this.timeLeft = timeLeft;
            return this;
        }
        public Builder setUserBuyItNow(boolean buyItNow) {
            Item.this.buyItNow = buyItNow;
            return this;
        }
        public Builder setUserSold(boolean isSold) {
            Item.this.isSold = isSold;
            return this;
        }

        public Item build(User user){
            Item.this.setUser(user);
            return Item.this;
        }
    }
}
