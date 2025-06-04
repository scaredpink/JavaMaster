package i.love.wsq.springbucks.repository;

import i.love.wsq.springbucks.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    List<CoffeeOrder> findByCustomerOrderById(String customer);

    List<CoffeeOrder> findByItems_Name(String name);
}
