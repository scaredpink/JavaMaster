package i.love.wsq.springbucks.repository;

import i.love.wsq.springbucks.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
