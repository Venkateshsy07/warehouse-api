package com.example.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "racked_block")
public class RackedBlock extends Block{

    @OneToMany(mappedBy = "rackedblock")
    private List<Rack> racks;

}