package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.expensive;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_title", length = 50)
    private String expenseTitle;

    @Column(name = "expense_value")
    private BigDecimal expenseValue;

    @Column(name = "expense_description", length = 500)
    private String expenseDescription;

    @Column(name = "expense_created_at")
    @CreatedDate
    private LocalDateTime expenseCreatedAt;

    public Expense() {

    }

    public Expense(Long id, String expenseTitle, BigDecimal expenseValue, String expenseDescription, LocalDateTime expenseCreatedAt) {
        this.id = id;
        this.expenseTitle = expenseTitle;
        this.expenseValue = expenseValue;
        this.expenseDescription = expenseDescription;
        this.expenseCreatedAt = expenseCreatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public BigDecimal getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(BigDecimal expenseValue) {
        this.expenseValue = expenseValue;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public LocalDateTime getExpenseCreatedAt() {
        return expenseCreatedAt;
    }

    public void setExpenseCreatedAt(LocalDateTime expenseCreatedAt) {
        this.expenseCreatedAt = expenseCreatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(getId(), expense.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
