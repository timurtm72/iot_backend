package com.example.iot_backend.model.object;

import jakarta.persistence.*;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
    private LocalDateTime createdAt;
    @Column(name="removed_at",nullable = false)
    private LocalDateTime removedAt;
    @Column(name="modified_at",nullable = false)
    private LocalDateTime modifiedAt;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id_created_at")
//    private User createdAtUser;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id_modified_at")
//    private User modifiedAtUser;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id_removed_at")
//    private User removedAtUser;
    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved = Boolean.FALSE;

    @PrePersist
    public void toCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void toModified() {
        this.modifiedAt = LocalDateTime.now();
    }

    @PreRemove
    public void toRemove() {
        this.removedAt = LocalDateTime.now();
    }

}
