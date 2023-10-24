package com.ifsp.apipagamento.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_purchase")
public class Purchase implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome da empresa é obrigatório")
    @Column(name = "nameCompany")
    private String nameCompany;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;

    @NotNull(message = "O valor total é obrigatório")
    @Positive(message = "O valor total deve ser um número positivo")
    private Double total;

    @Positive(message = "O número de parcelas deve ser um número positivo")
    private int installments;

    @NotBlank(message = "O status é obrigatório")
    @Size(min = 1, max = 255, message = "O status deve conter entre 1 e 255 caracteres")
    private String status;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Purchase() {
    }


    public Purchase(Long id, String nameCompany, Instant date, Double total, int installments, String status, Card card) {
        super();
        this.id = id;
        this.nameCompany = nameCompany;
        this.date = date;
        this.total = total;
        this.installments = installments;
        this.status = status;
        this.card = card;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return this.nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getInstallments() {
        return this.installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}