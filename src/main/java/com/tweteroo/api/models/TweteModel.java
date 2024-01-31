package com.tweteroo.api.models;

import org.springframework.data.annotation.Id;

import com.tweteroo.api.dtos.TweteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "twetes")
public class TweteModel {

    public TweteModel(TweteDTO dto) {
        this.text = dto.getText();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 280, nullable = false)
    private String text ;
}
