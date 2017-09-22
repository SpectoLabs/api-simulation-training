package io.specto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1/discount-codes")
public class DiscountCodeController {

    @RequestMapping(method = GET)
    public List<String> getDiscountCodes() {
        return Arrays.asList("SALE10", "SALE20", "SPECTO");
    }
}
