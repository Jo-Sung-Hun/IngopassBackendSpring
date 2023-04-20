package com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.Meal;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
public class NeisServerMealResponseEntitiyRow {
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<NeisServerMealResponseEntitiyRowMeal> row;
    @Builder
    public NeisServerMealResponseEntitiyRow(Long id, List<NeisServerMealResponseEntitiyRowMeal> row) {
        this.id = id;
        this.row = row;
    }

    public NeisServerMealResponseEntitiyRow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NeisServerMealResponseEntitiyRowMeal> getRow() {
        return row;
    }

    public void setRow(List<NeisServerMealResponseEntitiyRowMeal> row) {
        this.row = row;
    }
}
