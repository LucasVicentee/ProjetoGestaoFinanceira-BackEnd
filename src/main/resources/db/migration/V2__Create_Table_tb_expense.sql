CREATE TABLE tb_expense (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
user_id BIGINT NOT NULL,
expense_title VARCHAR(50) NOT NULL,
expense_value DECIMAL(19, 2) NOT NULL,
expense_description VARCHAR(500),
expense_created_at DATETIME(6),
CONSTRAINT fk_expense_user
FOREIGN KEY (user_id)
REFERENCES tb_user(id)
ON DELETE CASCADE
);