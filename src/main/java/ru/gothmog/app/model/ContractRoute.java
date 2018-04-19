package ru.gothmog.app.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "contract_route")
public class ContractRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_route_id", nullable = false, unique = true)
    private Long id;
    @Column(name = "exit_point")
    private String exitPoint;
    @Column(name = "exit_time")
    private LocalTime exitTime;
    @Column(name = "point_of_arrival")
    private String pointOfArrival;
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExitPoint() {
        return exitPoint;
    }

    public void setExitPoint(String exitPoint) {
        this.exitPoint = exitPoint;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getPointOfArrival() {
        return pointOfArrival;
    }

    public void setPointOfArrival(String pointOfArrival) {
        this.pointOfArrival = pointOfArrival;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
