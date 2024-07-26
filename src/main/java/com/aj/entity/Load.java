package com.aj.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_load")
public class Load {@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loading_point", nullable = false)
    private String loadingPoint;

    @Column(name = "unloading_point", nullable = false)
    private String unloadingPoint;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "truck_type", nullable = false)
    private String truckType;

    @Column(name = "no_of_trucks", nullable = false)
    private int noOfTrucks;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "comment")
    private String comment;

    @Column(name = "shipper_id", nullable = false)
    private UUID shipperId;

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
