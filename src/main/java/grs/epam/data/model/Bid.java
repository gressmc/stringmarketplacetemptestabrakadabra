package grs.epam.data.model;

import javax.persistence.*;

@Entity
@Table(name = "BIDS")
@NamedQuery(name = "Bid.getAll", query = "SELECT b FROM Bid b")
public class Bid extends AbstractModel<Integer> implements Identified<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PK_BIDS_SEQ")
    @SequenceGenerator(name="PK_BIDS_SEQ", sequenceName="PK_BIDS_SEQ", allocationSize=1)
    @Column(name="ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "BIDDER_ID")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private double bid;

    public Bid() {}

    public Bid(double bid) {
        this.bid = bid;
    }

    @Override
    public Integer getId() {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
}
