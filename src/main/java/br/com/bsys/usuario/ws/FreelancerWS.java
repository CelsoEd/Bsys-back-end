package br.com.bsys.usuario.ws;

import br.com.bsys.usuario.dto.FreelancerRequisicaoCadastroDTO;
import br.com.bsys.usuario.dto.UsuarioRequisicaoConsultaDTO;
import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.usuario.interceptor.Autorizacao;
import br.com.bsys.usuario.service.FreelancerService;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.exception.NotFoundException;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.security.NoSuchAlgorithmException;

@Path("freelancer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FreelancerWS {

    @EJB
    FreelancerService freelancerService;

    @POST
    @Path("/cadastro")
    public Response novo(@Valid FreelancerRequisicaoCadastroDTO freelancerRequisicaoCadastroDTO) throws NoSuchAlgorithmException {
        freelancerService.novo(freelancerRequisicaoCadastroDTO.paraObjeto());
        return Response.created(UriBuilder.fromPath("usuario").build()).build();
    }

    @GET
    public Response test(){
        return Response.ok().build();
    }


    @GET
    @Path("/consulta/{id}")
    public Response consulta(@PathParam("id") String id) throws NotFoundException {
        Freelancer freelancer = freelancerService.consultaPorId(id);
        return Response.ok(freelancer).build();
    }

    @GET
    @Path("/consulta")
    public Response consulta(UsuarioRequisicaoConsultaDTO usuarioRequisicaoConsultaDTO) throws NotFoundException {
        Freelancer freelancer = freelancerService.consultaPorId(usuarioRequisicaoConsultaDTO.getId());
        return Response.ok(freelancer).build();
    }

    @GET
    @Path("/listar")
    public Response buscarTodos() throws NotFoundException {
        return Response.ok(freelancerService.listarTodos()).build();
    }

    @GET
    @Autorizacao({TipoUsuario.CONVIDADO, TipoUsuario.ADMINISTRADOR, TipoUsuario.CLIENTE})
    public Response consultaUsuario() {
        return Response.ok().build();
    }

    @PUT
    @Path("update")
    public Response atualizarServico(
            FreelancerRequisicaoCadastroDTO freelancerRequisicaoCadastroDTO)
            throws NotFoundException {
        freelancerService.alterar(freelancerRequisicaoCadastroDTO.paraObjeto());
        return Response.ok().build();
    }

}
