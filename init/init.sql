DROP
DATABASE IF EXISTS `csq`;
CREATE
DATABASE `csq`;

USE
`csq`;

CREATE TABLE `category`
(
    id         VARCHAR(36) primary key,
    created_at varchar(255),
    deleted_at varchar(255),
    updated_at varchar(255),
    name       varchar(50) not null
);

CREATE TABLE `quiz`
(
    id              VARCHAR(36) primary key,
    created_at      varchar(255),
    deleted_at      varchar(255),
    updated_at      varchar(255),
    answer          binary(255) not null,
    content         binary(255) not null,
    explanation     binary(255) not null,
    multiple_choice binary(255) not null,
    recommend       integer,
    title           varchar(100) not null,
    type            varchar(20)  not null,
    user_id         varchar(36),
    category_id     VARCHAR(36)
);

CREATE TABLE `comment`
(
    id         VARCHAR(36) primary key,
    created_at varchar(255),
    deleted_at varchar(255),
    updated_at varchar(255),
    content    binary(255),
    recommand  integer,
    user_id    varchar(36),
    quiz_id    VARCHAR(36)
);

ALTER TABLE `quiz`
    ADD FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE `comment`
    ADD FOREIGN KEY (quiz_id) REFERENCES quiz (id);