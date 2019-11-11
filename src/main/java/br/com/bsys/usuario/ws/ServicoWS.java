package br.com.bsys.usuario.ws;

import br.com.bsys.usuario.dto.ServicoRequisicaoCadastroDTO;
import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.usuario.service.ServicoService;
import br.com.bsys.util.exception.NotFoundException;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("servico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicoWS {

    @EJB
    private ServicoService servicoService;

    @POST
    @Path("servico-barbearia")
    public Response novoServicoBarbearia(
            ServicoRequisicaoCadastroDTO servicoRequisicaoCadastroDTO)
            throws NotFoundException {

        servicoService.novoServicoBarbearia(servicoRequisicaoCadastroDTO.getId(), servicoRequisicaoCadastroDTO.paraObjeto());
        return Response.ok().build();
    }

    @POST
    @Path("servico-freelancer")
    public Response novoServicoFreelancer(ServicoRequisicaoCadastroDTO servicoRequisicaoCadastroDTO)
            throws NotFoundException {

        servicoService.novoServicoFreelancer(servicoRequisicaoCadastroDTO.getId(), servicoRequisicaoCadastroDTO.paraObjeto());
        return Response.ok().build();
    }

    @PUT
    @Path("servico-update")
    public Response atualizarServico(
            ServicoRequisicaoCadastroDTO servicoRequisicaoCadastroDTO)
            throws NotFoundException {

        servicoService.alteraServico(servicoRequisicaoCadastroDTO.paraObjeto());
        return Response.ok().build();
    }

    @GET
    @Path("/consulta")
    public Response consulta(ServicoRequisicaoCadastroDTO servicoRequisicaoCadastroDTO) throws NotFoundException {
        Servicos servico = servicoService.consultaPorId(servicoRequisicaoCadastroDTO.getIdServico());
        return Response.ok(servico).build();
    }
}
