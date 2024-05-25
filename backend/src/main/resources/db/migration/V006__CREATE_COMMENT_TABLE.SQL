CREATE TABLE comment (
    comment_id VARCHAR(36) NOT NULL PRIMARY KEY,
    comment_owner_id VARCHAR(36) NOT NULL,
    post_id VARCHAR(36) NOT NULL,
    comment_date DATE NOT NULL,
    comment TEXT NOT NULL,

    FOREIGN KEY (comment_owner_id) REFERENCES aupair(aupair_id),
    FOREIGN KEY (post_id) REFERENCES post(post_id)
);
