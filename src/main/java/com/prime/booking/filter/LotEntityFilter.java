package com.prime.booking.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prime.booking.annotations.CustomSpan;
import com.prime.booking.model.LotEntity;
import com.prime.booking.utils.StringUtils;
import jakarta.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class LotEntityFilter implements Filter<LotEntity> {

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer minFloor;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer maxFloor;

    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer minSq;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer maxSq;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer minCountOfRooms;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer maxCountOfRooms;

    private String city;

    @Override
    @CustomSpan
    public Specification<LotEntity> toSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Optional.ofNullable(name).ifPresent(item -> predicates
                    .add(criteriaBuilder.like(root.get("name"), StringUtils.formatEntryString(name))));
            predicates
                    .add(criteriaBuilder.between(root.get("floor"),
                            Optional.ofNullable(minFloor).orElse(0),
                            Optional.ofNullable(maxFloor).orElse(Integer.MAX_VALUE)));
            Optional.ofNullable(address).ifPresent(item -> predicates
                    .add(criteriaBuilder.like(root.get("address"), StringUtils.formatEntryString(address))));
            predicates
                    .add(criteriaBuilder.between(root.get("sq"),
                            Optional.ofNullable(minSq).orElse(0),
                            Optional.ofNullable(maxSq).orElse(Integer.MAX_VALUE)));

            predicates
                    .add(criteriaBuilder.between(root.get("countOfRooms"),
                            Optional.ofNullable(minCountOfRooms).orElse(0),
                            Optional.ofNullable(maxCountOfRooms).orElse(Integer.MAX_VALUE)));

            Optional.ofNullable(city).ifPresent(item -> predicates
                    .add(criteriaBuilder.equal(root.get("city"), city)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
