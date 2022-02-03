package com.microservices.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Long id;
    private String departmentName;
    private String getDepartmentAddress;
    private String departmentCode;
}
