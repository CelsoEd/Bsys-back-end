package br.com.bsys.usuario.ws;

import br.com.bsys.usuario.dto.AgendamentoRequisicaoCadastroDTO;
import br.com.bsys.usuario.service.AgendamentoService;
import br.com.bsys.util.exception.InfraestruturaException;
import br.com.bsys.util.exception.NotFoundException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("agendamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendamentoWS {

    @EJB
    private AgendamentoService agendamentoService;

    @POST
    @Path("/cadastro")
    public Response novo(AgendamentoRequisicaoCadastroDTO agendamentoRequisicaoCadastroDTO) throws NotFoundException, InfraestruturaException {
        agendamentoService.cadastraAgendamento(agendamentoRequisicaoCadastroDTO.getIdCliente(), agendamentoRequisicaoCadastroDTO.getIdServico(), agendamentoRequisicaoCadastroDTO.paraObjeto());
        return Response.ok().build();
    }

}
