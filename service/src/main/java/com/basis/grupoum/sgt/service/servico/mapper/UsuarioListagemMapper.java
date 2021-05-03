package com.basis.grupoum.sgt.service.servico.mapper;

import com.basis.grupoum.sgt.service.dominio.Usuario;
import com.basis.grupoum.sgt.service.servico.dto.UsuarioListagemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioListagemMapper extends EntityMapper<UsuarioListagemDTO, Usuario>  {
}
