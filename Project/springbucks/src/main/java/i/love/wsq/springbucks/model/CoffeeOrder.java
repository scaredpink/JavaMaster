package i.love.wsq.springbucks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder extends BaseEntity implements Serializable {

    private String customer;

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")// Coffee和CoffeeOrder之间的映射关系是通过表T_ORDER_COFFEE表示的, 是一个多对多的关系
    private List<Coffee> items; // 一个订单可以对应多个咖啡

    @Column(nullable = false)
    private OrderState state;  // 订单的状态
}
