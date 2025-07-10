package kr.co.wikibook.gallery.order;

import kr.co.wikibook.gallery.item.ItemMapper;
import kr.co.wikibook.gallery.order.model.OrderPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final ItemMapper itemMapper;

    public int saveOrder(OrderPostReq req) {
        //상품 정보를 DB로 부터 가져온다.
        List<Integer> itemIds = req.getItemIds();

        return  1;
    }
}
