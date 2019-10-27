package br.com.bsys.util;

import br.com.bsys.util.exception.InfraestruturaException;

public interface DTO<T> {
    T paraObjeto() throws InfraestruturaException;
}
