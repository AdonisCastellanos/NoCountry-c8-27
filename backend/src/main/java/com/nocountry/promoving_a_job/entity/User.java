package com.nocountry.promoving_a_job.entity;

import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User {

    @Id
    @Column(nullable = false, updatable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 150)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false, length = 60)
    private String country;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_company",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> companies;

    /*@OneToMany(mappedBy = "userComments")
    private Set<Comment> userComments;
    */
    @CreatedDate
    @Column(nullable = false, updatable = false, length = 15)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false, length = 15)
    private OffsetDateTime lastUpdated;

}
