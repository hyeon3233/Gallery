package kr.co.wikibook.gallery.order;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.wikibook.gallery.cart.CartMapper;
import kr.co.wikibook.gallery.cart.model.CartGetRes;
import kr.co.wikibook.gallery.item.ItemMapper;
import kr.co.wikibook.gallery.item.model.ItemGetRes;
import kr.co.wikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final ItemMapper itemMapper;
    private final OrderItemMapper orderItemMapper;
    private final CartMapper cartMapper;

    public int saveOrder(OrderPostReq req, int loggineMemberId) {
        //상품 정보를 DB로 부터 가져온다.
        List<ItemGetRes> itemList = itemMapper.findAllByIdIn(req.getItemIds());
        int amount = 0;
        for (ItemGetRes item : itemList) {
            amount += item.getPrice() - (item.getPrice() * item.getDiscountPer() / 100);
        }
        log.info("amount: {}", amount);

        // OrderPostDto 객체화하고 데이터 넣기
        OrderPostDto orderPostDto = new OrderPostDto();
        orderPostDto.setMemberId(loggineMemberId);
        orderPostDto.setName(req.getName());
        orderPostDto.setAddress(req.getAddress());
        orderPostDto.setPayment(req.getPayment());
        orderPostDto.setCardNumber(req.getCardNumber());
        orderPostDto.setAmount(amount);
        log.info("before-orderPostDto: {}", orderPostDto);
        int result = orderMapper.save(orderPostDto);
        log.info("after-orderPostDto: {}", orderPostDto);

        OrderItemPostDto orderItemPostDto = new OrderItemPostDto(orderPostDto.getOrderId(), req.getItemIds());
        orderItemMapper.save(orderItemPostDto);

        cartMapper.deleteByMemberId(loggineMemberId);

        return  1;
    }

    public List<OrderGetRes> findAll(int memberId) {
        return orderMapper.findAllByMemberIdOrderByIdDesc(memberId);
    }

    public OrderDetailGetRes detail(OrderDetailGetReq req) {
        OrderDetailGetRes result = orderMapper.findByOrderIdAndMemberId(req);
        log.info("result: {}", result);
        return result;
    }
}
