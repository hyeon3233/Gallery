package kr.co.wikibook.gallery.cart.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CartGetRes {

    private int price;
    private int id;
    private int discountPer;
    private String imgPath;
    private String name;
}
