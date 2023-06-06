package com.log.eventlog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="log")
public class Log {

    @Id
    private Long id;
    private LocalDateTime dataEvento;
    private String statusRota;

}