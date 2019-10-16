package br.com.bsys.usuario.ws;

import br.com.bsys.usuario.dto.ServicoRequisicaoCadastroDTO;
import br.com.bsys.usuario.service.ServicoService;
import br.com.bsys.util.exception.NotFoundException;


import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("servico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicoWS {

    @Inject
    private ServicoService servicoService;

    @POST
    @Path("servico-barbearia/{id}")
    public Response novoServicoBarbearia(
            @PathParam("id") String id, ServicoRequisicaoCadastroDTO servicoRequisicaoCadastroDTO)
            throws NotFoundException {

        servicoService.novoServicoBarbearia(id,servicoRequisicaoCadastroDTO.paraObjeto());
        return Response.ok().build();
    }
}
