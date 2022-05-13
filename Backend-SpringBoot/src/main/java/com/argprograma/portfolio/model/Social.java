package com.argprograma.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Social {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column (nullable=false)
    private int itemOrder;
    
    @Column (length=255)
    private String url;
    
    @JsonIgnoreProperties("socialSet")
    @ManyToOne (optional=false)
    private SocialType socialType;
    
    @JsonIgnoreProperties("socialSet")
    @ManyToOne (optional=false)
    private Portfolio portfolio;
    
}
