package com.microservices.userservice.VO;

import com.microservices.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemaplteVO {

    private User user;
    private Department department;
}
