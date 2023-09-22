package com.ldslab02.alugarAutomovel.models;

import java.util.List;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = Customer.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
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

    @Column(name = "name",  length = 100, nullable = false)
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

    @Column(name = "address",  length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 100)
    private String address;

    @Column(name = "profession",  length = 100, nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 100)
    private String profession;

    @Column(name = "income",  nullable = false)
    @NotNull(groups = CreateCustomer.class)
    @NotEmpty(groups = CreateCustomer.class)
    @Size(groups = CreateCustomer.class, min = 0)
    @ElementCollection(fetch = FetchType.LAZY, targetClass = Double.class)
    @CollectionTable(name = "Incomes", // Nome da tabela para armazenar a coleção
            joinColumns = @JoinColumn(name = "customer_id") // Nome da coluna que fará referência à entidade principal
                                                            // (Customer)
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL) // Configura o CascadeType.ALL
    private List<Double> income;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

}
