package com.onesight.searchdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;

import java.util.UUID;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    private UUID productId;

    String productName;
    String productDescription;
    String productLink;
    String categories;
    String docs;
}
