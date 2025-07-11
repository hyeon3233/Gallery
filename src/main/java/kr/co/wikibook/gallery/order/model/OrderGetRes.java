package kr.co.wikibook.gallery.order.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderGetRes {
    private int id;
    private String name;
    private String payment;
    private long amount;
    private String created;
}
