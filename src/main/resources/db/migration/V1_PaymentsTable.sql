CREATE TABLE payments
(
    id                 int(10) PRIMARY KEY unsigned NOT NULL AUTO_INCREMENT,
    name               varchar(255) NOT NULL,
    phone              varchar(255) DEFAULT NULL,
    amount             int(11) NOT NULL,
    account            varchar(255) NOT NULL,
    customer_id        int(11) DEFAULT NULL,
    companyid          varchar(255) DEFAULT NULL,
    transaction_number varchar(255) NOT NULL,
    transaction_date   datetime     NOT NULL,
    payable_type       varchar(255) NOT NULL,
    payable_id         varchar(255) NOT NULL,
    processed          tinyint(1) NOT NULL DEFAULT '0',
    confirmed          tinyint(1) NOT NULL DEFAULT '0',
    payment_method     varchar(255) DEFAULT NULL,
    created_at         timestamp NULL DEFAULT NULL,
    updated_at         timestamp NULL DEFAULT NULL,
    PRIMARY KEY (id)
)