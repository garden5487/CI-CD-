package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.registry.RegistryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegistryMapper extends GenericMapper<RegistryDTO, String> {

}
