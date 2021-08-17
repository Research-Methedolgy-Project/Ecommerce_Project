package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Order.
 */
@Entity
@Table(name = "jhi_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "order_date_and_time")
    private ZonedDateTime orderDateAndTime;

    @ManyToOne
    private User user;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_jhi_order__product",
        joinColumns = @JoinColumn(name = "jhi_order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order id(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public Order status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZonedDateTime getOrderDateAndTime() {
        return this.orderDateAndTime;
    }

    public Order orderDateAndTime(ZonedDateTime orderDateAndTime) {
        this.orderDateAndTime = orderDateAndTime;
        return this;
    }

    public void setOrderDateAndTime(ZonedDateTime orderDateAndTime) {
        this.orderDateAndTime = orderDateAndTime;
    }

    public User getUser() {
        return this.user;
    }

    public Order user(User user) {
        this.setUser(user);
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    public Order products(Set<Product> products) {
        this.setProducts(products);
        return this;
    }

    public Order addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    public Order removeProduct(Product product) {
        this.products.remove(product);
        return this;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return id != null && id.equals(((Order) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", orderDateAndTime='" + getOrderDateAndTime() + "'" +
            "}";
    }
}
