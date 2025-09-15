package com.sony.gsois.sellinfct.domain;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class SalesCompanyId implements Serializable {
    private String compCode;
}
