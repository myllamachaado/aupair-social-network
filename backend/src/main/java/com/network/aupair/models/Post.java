package com.network.aupair.models;

import com.network.aupair.enums.PostType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "post")
public class Post {

    @Id
    @UuidGenerator
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(unique = true, insertable = false, updatable = false)
    private String postId;

    @ManyToOne
    @JoinColumn(name = "postOwner", referencedColumnName = "aupairId")
    private Aupair postOwner;

    @Lob
    @Column(name = "post", nullable = false, length = 5000)
    private String post;

    @Column(name = "post_type", nullable = false)
    private PostType postType;

    @Column(name = "post_date", nullable = false)
    private LocalDate postDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> coments;

}
