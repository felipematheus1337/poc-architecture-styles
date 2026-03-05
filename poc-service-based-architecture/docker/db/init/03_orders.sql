CREATE TABLE orders.orders (
    id UUID PRIMARY KEY,
    user_id UUID,
    status TEXT NOT NULL,
    total NUMERIC(12,2) NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE orders.order_items (
    id UUID PRIMARY KEY,
    order_id UUID,
    sku TEXT NOT NULL,
    qty INTEGER NOT NULL,
    price NUMERIC(12,2) NOT NULL
);