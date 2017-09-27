package io.specto;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController()
@RequestMapping("/api/v1/shopping-basket")
public class ShoppingController {

    private final Set<ShoppingItem> shoppingItemSet = newHashSet();
    private final Random random = new Random();

    @RequestMapping(method = PUT)
    @ResponseStatus(OK)
    public void addToBasket(@RequestBody final ShoppingItem shoppingItem) {
        shoppingItemSet.add(shoppingItem);
    }

    @RequestMapping(method = GET)
    public Set<ShoppingItem> getShoppingBasket() {
        return shoppingItemSet;
    }

    @RequestMapping(method = DELETE)
    public void deleteShoppingBasket() {
        shoppingItemSet.clear();
    }
}
