package dev.pkobevko.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Vote {
    @Id
    @GeneratedValue
    private Long id;
    private int vote;
}
