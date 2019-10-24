package br.com.bsys.usuario.ws;

import br.com.bsys.usuario.dto.AgendamentoRequisicaoCadastroDTO;
import br.com.bsys.usuario.service.AgendamentoService;
import br.com.bsys.util.exception.NotFoundException;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("agendamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendamentoWS {

    @EJB
    private AgendamentoService agendamentoService;

    @POST
    @Path("/cadastro/{idCliente}/{idServico}")
    public Response novo(@PathParam("idCliente") String idCliente, @PathParam("idServico") int idServico, AgendamentoRequisicaoCadastroDTO agendamentoRequisicaoCadastroDTO) throws NotFoundException {
        agendamentoService.cadastraAgendamento(idCliente,idServico,agendamentoRequisicaoCadastroDTO.paraObjeto());
        return Response.ok().build();
    }
}
