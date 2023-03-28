//package com.ruleengine.scheduler.entity.rule;
//
//import com.ruleengine.scheduler.entity.common.Status;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "account")
//public class Account {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Integer id;
//    @Column(name = "name", length = 256)
//    private String name;
//    @Column(name = "description", length = 100)
//    private String description;
//
//    @Column(name = "currency")
//    private Currency currency;
//
//    @Column(name = "timezone", length = 64)
//    private String timezone;
//
//    @Column(name = "phone",length = 64)
//    private String phone;
//
//    @Column(name = "address1", length = 256)
//    private String address1;
//
//    @Column(name = "address2", length = 256)
//    private String address2;
//
//    @Column(name = "city", length = 128)
//    private String city;
//
//    @Column(name = "state", length = 64)
//    private String state;
//
//    @Column(name = "status")
//    private Status status;
//
//    @Column(name = "country", length = 64)
//    private String country;
//
//    @Column(name = "zip", length = 64)
//    private String zip;
//
//    @Column(name = "parent_id")
//    private Integer parentId;
//
//    @Column(name = "self_managed")
//    private Integer selfManaged;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @Column(name = "created_by")
//    private Integer createdBy;
//
//    @Column(name = "updated_by")
//    private Integer updatedBy;
//
//    @Column(name = "email", length = 45)
//    private String email;
//
//    @Column(name = "website", length = 255)
//    private String website;
//
//    @Column(name = "logo_url", length = 255)
//    private String logoUrl;
//
//    @Column(name = "is_unified")
//    private Integer isUnified;
//
//}
