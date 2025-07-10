package kr.co.wikibook.gallery.order;

import kr.co.wikibook.gallery.order.model.OrderPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;

    @PostMapping
    ResponseEntity<?> add(@RequestBody OrderPostReq req) {
        log.info("req: {}", req);
        return null;
    }
}
