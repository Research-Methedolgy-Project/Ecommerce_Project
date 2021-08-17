package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Product} entity.
 */
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private String category;

    private Long remaining_stock;

    private ZonedDateTime added_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getRemaining_stock() {
        return remaining_stock;
    }

    public void setRemaining_stock(Long remaining_stock) {
        this.remaining_stock = remaining_stock;
    }

    public ZonedDateTime getAdded_date() {
        return added_date;
    }

    public void setAdded_date(ZonedDateTime added_date) {
        this.added_date = added_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", category='" + getCategory() + "'" +
            ", remaining_stock=" + getRemaining_stock() +
            ", added_date='" + getAdded_date() + "'" +
            "}";
    }
}
