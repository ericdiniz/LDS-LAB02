package com.ldslab02.alugarAutomovel.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = RentalRequest.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RentalRequest {
    public static final String TABLE_NAME = "RentalRequest";

    public interface CreateRentalRequest {

    }

    public interface UpdateRentalRequest {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_RentalRequest", unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    @JsonIgnore
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "rental_request_vehicles", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "rental_request_id"), inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    @JsonIgnore
    private List<Vehicles> vehicles;

    public List<Vehicles> getVehicles() {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        return vehicles;
    }

    @Column(name = "date", length = 100, nullable = false)
    @NotNull(groups = CreateRentalRequest.class)
    @NotEmpty(groups = CreateRentalRequest.class)
    @Size(groups = CreateRentalRequest.class, min = 2, max = 100)
    private String date;

    // SERVICE ->
    // obj.setProfiles(Stream.of(ProfileEnum.USER.getCode()).collect(Collectors.toSet()));

    // @ElementCollection(fetch = FetchType.EAGER)
    // @JsonProperty(access = Access.WRITE_ONLY)
    // @CollectionTable(name = "user_profile")
    // @Column(name = "profile", nullable = false)
    // private Set<Integer> statusRentalRequest = new HashSet<>();

    // public Set<EnumStatusRentalRequest> getStatusRentalRequest() {
    // return this.statusRentalRequest.stream().map(x ->
    // EnumStatusRentalRequest.toEnum(x))
    // .collect(Collectors.toSet());
    // }

    // public void addStatus(EnumStatusRentalRequest profileEnum) {
    // this.statusRentalRequest.add(profileEnum.getCode());
    // }
}
