package kr.co.wikibook.gallery.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDto {
    private int id;
    private String name;
    private String imgPath;
    private int price;
    private int discount;
}
