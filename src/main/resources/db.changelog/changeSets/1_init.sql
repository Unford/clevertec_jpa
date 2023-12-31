-- liquibase formatted sql

-- changeset vladimir_feshenko:1701815037055-1
CREATE TABLE payment
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    payment_from VARCHAR(255),
    payment_to   VARCHAR(255),
    payment_type VARCHAR(255),
    CONSTRAINT pk_payment PRIMARY KEY (id)
);

-- changeset vladimir_feshenko:1701815037055-2
CREATE TABLE payment_by_erip
(
    id                  BIGINT NOT NULL,
    field_for_insertion VARCHAR(255),
    value_for_insertion VARCHAR(255),
    CONSTRAINT pk_payment_by_erip PRIMARY KEY (id)
);

-- changeset vladimir_feshenko:1701815037055-3
CREATE TABLE payment_by_requisite
(
    id          BIGINT NOT NULL,
    unp         VARCHAR(255),
    receiver    VARCHAR(255),
    destination VARCHAR(255),
    CONSTRAINT pk_paymentbyrequisite PRIMARY KEY (id)
);

-- changeset vladimir_feshenko:1701815037055-4
ALTER TABLE payment_by_requisite
    ADD CONSTRAINT FK_PAYMENTBYREQUISITE_ON_ID FOREIGN KEY (id) REFERENCES payment (id);

-- changeset vladimir_feshenko:1701815037055-5
ALTER TABLE payment_by_erip
    ADD CONSTRAINT FK_PAYMENT_BY_ERIP_ON_ID FOREIGN KEY (id) REFERENCES payment (id);

