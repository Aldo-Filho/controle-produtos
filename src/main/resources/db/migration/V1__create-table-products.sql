CREATE TABLE product (
    id            BIGSERIAL PRIMARY KEY ,
    name          VARCHAR(50) NOT NULL UNIQUE,
    description   VARCHAR(255),
    price         NUMERIC(12,2) NOT NULL,
    qtt_in_stock  INT NOT NULL DEFAULT 0,
    active        BOOLEAN NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP
);