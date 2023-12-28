package com.example.purebasketconsumer.domain.purchase.entity;

import com.example.purebasketconsumer.domain.member.entity.Member;
import com.example.purebasketconsumer.domain.product.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "purchase")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchase extends TimeStamp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1)
    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    @Builder
    private Purchase(int amount, int price, Member member, Product product) {
        this.amount = amount;
        this.price = price;
        this.member = member;
        this.product = product;
    }

    public static Purchase of(Product product, int amount, Member member) {
        return Purchase.builder()
                .amount(amount)
                .price(product.getPrice())
                .member(member)
                .product(product)
                .build();
    }
}