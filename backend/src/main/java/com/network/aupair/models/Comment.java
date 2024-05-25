package com.network.aupair.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @UuidGenerator
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(unique = true, insertable = false, updatable = false)
    private String commentId;

    @ManyToOne
    @JoinColumn(name = "commentOwner", referencedColumnName = "aupairId")
    private Aupair commentOwner;

    @ManyToOne
    private Post post;

    @Column(name = "comment_date", nullable = false)
    private LocalDate commentDate;

    @Lob
    @Column(name = "comment", nullable = false, length = 5000)
    private String comment;

}
