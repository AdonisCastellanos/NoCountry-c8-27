package com.nocountry.promoving_a_job.entity;

import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Company {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String logo;

    @Column
    private Integer validation;

    @ManyToMany(mappedBy = "companies", fetch = FetchType.LAZY)
    private Set<User> users;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    //@JoinColumn(name = "offer_id", nullable = false)
    private Set<JobOffer> jobOffers;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Comment> Comments;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
