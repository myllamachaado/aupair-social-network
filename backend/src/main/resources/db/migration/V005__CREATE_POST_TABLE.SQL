CREATE TABLE post (
    post_id VARCHAR(36) NOT NULL PRIMARY KEY,
    post_owner VARCHAR(36) NOT NULL,
    post TEXT NOT NULL,
    post_type INT NOT NULL,
    post_date DATE NOT NULL,

    FOREIGN KEY (post_owner) REFERENCES aupair(aupair_id)
);
