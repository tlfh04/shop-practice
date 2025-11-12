package com.apple.shop;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String title;
    @Column(nullable = false)
    public Integer price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 비어 있을 수 없습니다.");
        }
        if (title.length() > 20){
            throw new IllegalArgumentException("제목은 20자 이하여야 합니다.");
        }
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price <= 0){
            throw new IllegalArgumentException("가격은 0보다 커야합니다.");
        }
        this.price = price;
    }
}