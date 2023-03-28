//package com.ruleengine.scheduler.entity.rule_entity;
//
//import com.ruleengine.scheduler.entity.rule_entity.ChannelId;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "adaccount")
//public class AdAccount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "channel_id")
//    private ChannelId channelId;
//
//    @Column(name = "auth_token")
//    private String authToken;
//
//    @Column(name = "ext_account_name", length = 128)
//    private String extAccountName;
//
//    @Column(name = "ext_account_id",length = 128)
//    private String extAccountId;
//
//    @Column(name = "last_sync_time")
//    private LocalDateTime lastSyncTime;
//
//    @Column(name = "last_sync_status", length = 128)
//    private String lastSyncStatus;
//
//    @Column(name = "last_sync_size")
//    private String lastSyncSize;
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
//    @Column(name = "status")
//    private Status status;
//
//    @Column(name = "parent_id")
//    private Integer parentId;
//    @Column(name = "timezone",length = 64)
//    private String timezone;
//
//    @Column(name = "currency", length = 64)
//    private String currency;
//
//    @Column(name = "total_size")
//    private Integer totalSize;
//
//    @Column(name = "manager_account_id", length = 64)
//    private String managerAccountId;
//
//    @Column(name = "manager_account_name", length = 64)
//    private String managerAccountName;
//
//    @Column(name = "advertiser_id")
//    private Integer advertiserId;
//
//    @Column(name = "agency_id")
//    private Integer agencyId;
//
//    @Column(name = "start_sync_time")
//    private LocalDateTime startSyncTime;
//
//    @Column(name = "account_id")
//    private Integer accountId;
//
//}
//
