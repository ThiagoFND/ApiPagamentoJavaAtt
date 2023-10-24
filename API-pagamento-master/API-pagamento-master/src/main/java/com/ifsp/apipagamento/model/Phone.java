package com.ifsp.apipagamento.model;

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O número de telefone é obrigatório")
    @Size(min = 10, max = 15, message = "O número de telefone deve ter entre 10 e 15 caracteres")
    @Pattern(regexp = "\\+?\\d+", message = "O número de telefone deve conter apenas dígitos e pode começar com '+'")
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Phone() {
    }

    public Phone(Long id, String phone, Customer customer) {
        super();
        this.id = id;
        this.phone = phone;
        this.customer = customer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
