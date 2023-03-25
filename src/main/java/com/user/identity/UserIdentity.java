package com.user.identity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserIdentity {
    private String bankAccount;
    private String socialId;
    private String name;
    private String phone;
}
