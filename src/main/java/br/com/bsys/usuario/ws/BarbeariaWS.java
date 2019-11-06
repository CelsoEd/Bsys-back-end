package br.com.bsys.usuario.ws;

import br.com.bsys.usuario.dto.BarbeariaRequisicaoCadastroDTO;
import br.com.bsys.usuario.dto.ServicoRequisicaoCadastroDTO;
import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Usuario;
import br.com.bsys.usuario.interceptor.Autorizacao;
import br.com.bsys.usuario.service.BarbeariaService;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.exception.NotFoundException;


import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.security.NoSuchAlgorithmException;

@Path("barbearia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BarbeariaWS {

    @EJB
    BarbeariaService barbeariaService;

    @POST
    @Path("/cadastro")
    public Response novo(@Valid BarbeariaRequisicaoCadastroDTO barbeariaRequisicaoCadastroDTO) throws NoSuchAlgorithmException {
        barbeariaService.novo(barbeariaRequisicaoCadastroDTO.paraObjeto());
        return Response.created(UriBuilder.fromPath("usuario").build()).build();
    }

//    @POST
//    @Path("/servico")
//    public Response novoServico(String id ,@Valid ServicoRequisicaoCadastroDTO servicoRequisicaoCadastroDTO) throws NotFoundException {
//        barbeariaService.novoServico(id,servicoRequisicaoCadastroDTO.paraObjeto());
//        return Response.ok().build();
//    }

    @GET
    @Path("/consulta/{id}")
    public Response consulta(@PathParam("id") String id) throws NotFoundException {
        Barbearia barbearia = barbeariaService.consultaPorId(id);
        return Response.ok(barbearia).build();
    }

    @GET
    @Path("/listar")
    public Response buscarTodos() throws NotFoundException {
        return Response.ok(barbeariaService.listarTodas()).build();
    }

    @GET
    @Autorizacao({TipoUsuario.CONVIDADO, TipoUsuario.ADMINISTRADOR, TipoUsuario.CLIENTE})
    public Response consultaUsuario() {
        return Response.ok().build();
    }



}
