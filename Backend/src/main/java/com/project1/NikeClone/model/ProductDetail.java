package com.project1.NikeClone.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDetail {
    private final String name;
    private final String describe;
    private final String caterology;
    private final String avata;
    private final Double price;

    private final List<String> image;
    private final List<ProductSizeForm> size;
}
