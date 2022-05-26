package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivary {

    @Id @GeneratedValue
    @Column(name = "delivary_id")
    private Long id;

    @OneToOne(mappedBy = "delivary")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DelivaryStatus status; // READY, COMP
}
