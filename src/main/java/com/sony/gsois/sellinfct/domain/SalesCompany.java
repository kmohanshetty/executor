package com.sony.gsois.sellinfct.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import org.hibernate.Hibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(SalesCompanyId.class)
@Entity
@Table(name = "SALES_COMPANY")
@Builder
public class SalesCompany implements Serializable {

    @Id
    @Column(name = "COMP_CD", nullable = false)
    private String compCode;

    @Column(name = "COMP_SHORT_NM", nullable = false)
    private String compShortName;

    @Column(name = "COMP_NM", nullable = false)
    private String compName;

    @Column(name = "EMAIL_DISTR_LIST")
    private String emailDistributionList;

    @Column(name = "DEF_FDC")
    private String defaultFdc;

    @Column(name = "DEF_TPT")
    private String defaultTpt;

    @Column(name = "SEIHAN_MON")
    private Integer seihanMonth;

    @Column(name = "SEIHAN_WK")
    private Integer seihanWeek;

    @Column(name = "PROCESSING_DT")
    private Date processingDate;
    @Column(name = "SELL_IN_HANDLING_CD")
    private String sellInHandlingCd;
    @Column(name = "IMMEDIATE_ISSUE_FLAG")
    private String immeIssueFlag;

    @Embedded
    private CreatedUpdated createdUpdated;

    /*@OneToMany(mappedBy = "salesCompany", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Product> products;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SalesCompany that = (SalesCompany) o;
        return compCode != null && Objects.equals(compCode, that.compCode);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
