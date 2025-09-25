package com.poc.context;

import com.poc.dto.AppUserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppUserContext extends BaseContext<AppUserDTO> {
}