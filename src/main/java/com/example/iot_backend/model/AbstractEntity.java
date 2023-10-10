package com.example.iot_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="created_at",nullable = false)
    LocalDateTime createdAt;
    @Column(name="removed_at",nullable = false)
    LocalDateTime removedAt;
    @Column(name="modified_at",nullable = false)
    LocalDateTime modifiedAt;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id_created_at")
    private User createdAtUser;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id_modified_at")
    private User modifiedAtUser;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id_removed_at")
    private User removedAtUser;
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;
    @PrePersist
    public void toCreate(){
        this.setCreatedAt(LocalDateTime.now());
    }
    @PreUpdate
    public void toModified(){
        this.setModifiedAt(LocalDateTime.now());
    }
    @PreRemove
    public void toRemove(){
        this.setRemovedAt(LocalDateTime.now());
    }

}
