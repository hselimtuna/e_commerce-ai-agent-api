DROP TABLE IF EXISTS order_items CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS trendyol_products CASCADE;
DROP TABLE IF EXISTS trendyol_accounts CASCADE;
DROP TABLE IF EXISTS customers CASCADE;

CREATE TABLE customers (
    id UUID UNIQUE PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    trendyol_id VARCHAR(100) UNIQUE,
    amazon_id VARCHAR(100) UNIQUE,
    hepsiburada_id VARCHAR(100) UNIQUE,
    is_active BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE trendyol_accounts (
    id UUID PRIMARY KEY,
    customer_id UUID UNIQUE NOT NULL,
    seller_id VARCHAR(100) UNIQUE NOT NULL,
    api_key VARCHAR(500) UNIQUE NOT NULL,
    api_secret VARCHAR(500) UNIQUE NOT NULL,
    integration_reference_code VARCHAR(255) UNIQUE NOT NULL,
    token VARCHAR(255) UNIQUE NOT NULL,
    store_name VARCHAR(255) UNIQUE NOT NULL,
    is_active BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX idx_customers_email ON customers(email);
CREATE UNIQUE INDEX idx_customers_trendyol_id ON customers(trendyol_id);
CREATE UNIQUE INDEX idx_customers_amazon_id ON customers(amazon_id);
CREATE UNIQUE INDEX idx_customers_hepsiburada_id ON customers(hepsiburada_id);
CREATE UNIQUE INDEX idx_trendyol_accounts_seller_id ON trendyol_accounts(customer_id, seller_id);
