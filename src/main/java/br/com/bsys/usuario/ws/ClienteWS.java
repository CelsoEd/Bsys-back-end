package br.com.bsys.usuario.ws;

import br.com.bsys.usuario.dto.ClienteRequisicaoCadastroDTO;
import br.com.bsys.usuario.dto.UsuarioRequisicaoLoginDTO;
import br.com.bsys.usuario.dto.UsuarioRespostaAutenticacaoDTO;
import br.com.bsys.usuario.entidade.Cliente;
import br.com.bsys.usuario.interceptor.Autorizacao;
import br.com.bsys.usuario.service.AutenticacaoService;
import br.com.bsys.usuario.service.ClienteService;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.exception.UnauthorizedException;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.awt.*;
import java.security.NoSuchAlgorithmException;

@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteWS {

    @EJB
    ClienteService clienteService;

    @EJB
    private AutenticacaoService autenticacaoService;

    @POST
    public Response novo(@Valid ClienteRequisicaoCadastroDTO clienteRequisicaoCadastroDTO) throws NoSuchAlgorithmException {
        clienteService.novo(clienteRequisicaoCadastroDTO.paraObjeto());
        return Response.created(UriBuilder.fromPath("usuario").build()).build();
    }

    @Path("login")
    @POST
    public Response login(UsuarioRequisicaoLoginDTO usuarioRequisicaoLoginDTO) throws UnauthorizedException, NoSuchAlgorithmException {
        UsuarioRespostaAutenticacaoDTO usuario = autenticacaoService.fazerLogin(usuarioRequisicaoLoginDTO.getEmail(), usuarioRequisicaoLoginDTO.getSenha());
        return Response
                .ok(usuario)
                .header(HttpHeaders.AUTHORIZATION, usuario.getToken())
                .build();
    }

    @GET
    @Autorizacao({TipoUsuario.CONVIDADO, TipoUsuario.ADMINISTRADOR, TipoUsuario.CLIENTE})
    public Response consultaUsuario() {
        return Response.ok().build();
    }


}
