package com.network.aupair.posts.models;

import com.network.aupair.posts.enums.PostType;

import java.time.LocalDate;
import java.util.UUID;

public class Post {

    private String id;
    private String postOwner;
    private String post;
    private PostType postType;

    private LocalDate postDate;
    private int bookmark;

}
