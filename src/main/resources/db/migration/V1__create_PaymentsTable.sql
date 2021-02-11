CREATE TABLE `payments` (
                            `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `amount` int(11) NOT NULL,
                            `account` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `customer_id` int(11) DEFAULT NULL,
                            `companyid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `transaction_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `transaction_date` datetime NOT NULL,
                            `payable_type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `payable_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `processed` tinyint(1) NOT NULL DEFAULT '0',
                            `confirmed` tinyint(1) NOT NULL DEFAULT '0',
                            `payment_method` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `created_at` timestamp NULL DEFAULT NULL,
                            `updated_at` timestamp NULL DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=747 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;