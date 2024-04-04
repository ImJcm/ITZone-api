//package com.itzone.itzone.hardware;
//
//import com.itzone.itzone.category.HardwareCategory;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Getter
//@NoArgsConstructor
//@Table(name = "hardwares")
//public class Hardware {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String productName;
//
//    @Column(nullable = false)
//    private String manufacturer;
//
//    @Column(nullable = false)
//    private String creationDate;
//
//    @Column(nullable = false)
//    private String description;
//
//    @OneToOne
//    @JoinColumn(name = "hardware_category_id")
//    private HardwareCategory hardwareCategory;
//}
