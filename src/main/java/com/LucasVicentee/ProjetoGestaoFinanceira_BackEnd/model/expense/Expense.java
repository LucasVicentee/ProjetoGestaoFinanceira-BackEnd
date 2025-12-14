package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.expense;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_expense")
public class Expense {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
