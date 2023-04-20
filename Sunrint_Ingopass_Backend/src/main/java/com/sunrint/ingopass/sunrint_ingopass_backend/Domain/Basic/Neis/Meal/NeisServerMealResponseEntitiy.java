package com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.Meal;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class NeisServerMealResponseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<NeisServerMealResponseEntitiyRow> mealServiceDietInfo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public NeisServerMealResponseEntitiy(List<NeisServerMealResponseEntitiyRow> mealServiceDietInfo, Date createdAt) {
        this.mealServiceDietInfo = mealServiceDietInfo;
        this.createdAt = createdAt;
    }

    public NeisServerMealResponseEntitiy() {
    }

    public List<NeisServerMealResponseEntitiyRow> getMealServiceDietInfo() {
        return mealServiceDietInfo;
    }

    public void setMealServiceDietInfo(List<NeisServerMealResponseEntitiyRow> mealServiceDietInfo) {
        this.mealServiceDietInfo = mealServiceDietInfo;
    }

    @Override
    public String toString() {
        return "NeisServerMealResponseEntitiy{" +
                "mealServiceDietInfo=" + mealServiceDietInfo +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
