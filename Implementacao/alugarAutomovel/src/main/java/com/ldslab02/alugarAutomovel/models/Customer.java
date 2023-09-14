package com.ldslab02.alugarAutomovel.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Agents.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id_user")
public class Customer extends User {
    public static final String TABLE_NAME = "Customer";

    public interface CreateCustomer {

    }

    public interface UpdateCustomer {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", unique = true)
    private Long id;

    @Column(name = "name", unique = true, length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 100)
    private String name;

    @Column(name = "cpf", unique = true, length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 20)
    private String cpf;

    @Column(name = "rg", unique = true, length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 20)
    private String rg;

    @Column(name = "address", unique = true, length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 100)
    private String address;

    @Column(name = "profession", unique = true, length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 100)
    private String profession;

    @Column(name = "income", unique = true, length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 100)
    private List<Double> income;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

}
