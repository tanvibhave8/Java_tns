
-- =====================================
-- MICRO WAREHOUSE DATABASE SCHEMA
-- =====================================

-- 1. PRODUCTS TABLE

CREATE TABLE IF NOT EXISTS products (
    sku_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    category VARCHAR(50) NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    stock_qty INT NOT NULL,

    CHECK (unit_price >= 0),
    CHECK (stock_qty >= 0)
);


-- 2. ORDERS TABLE

CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_phone VARCHAR(15) NOT NULL,
    order_status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CHECK (order_status IN (
        'PENDING',
        'CONFIRMED',
        'REJECTED',
        'DISPATCHED'
    ))
);


-- 3. ORDER ITEMS TABLE

CREATE TABLE IF NOT EXISTS order_items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    sku_id INT NOT NULL,
    quantity INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_order
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id),

    CONSTRAINT fk_product
        FOREIGN KEY (sku_id)
        REFERENCES products(sku_id),

    CHECK (quantity > 0),
    CHECK (subtotal >= 0)
);
