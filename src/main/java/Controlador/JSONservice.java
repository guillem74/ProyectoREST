package Controlador;

import Modelo.Eetakemon;
import Modelo.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/json")
public class JSONservice {

    protected Controlador c;

    public JSONservice() {
        c = Controlador.getControlador();
        c.anadirATabla(new Eetakemon("Aleix",1));
        c.anadirATabla(new Eetakemon("Guillem",2));
        c.anadirATabla(new Eetakemon("Mikel",3));
        c.anadirATabla(new Usuario("aleix123","messi1234","aleixdsa@gmail.com"));
        c.anadirATabla(new Usuario("guillem123","neymar1234","guillemdsa@gmail.com"));
        c.anadirATabla(new Usuario("Mikel","suarez1234","mikeldsa@gmail.com"));
    }

    @GET
    @Path("/getEetakemon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Eetakemon getEetakemonId(@PathParam("id") int id) {
        Eetakemon e = (Eetakemon) c.buscarPorIdEetakemon(id);
        System.out.println(e.toString());
        return e;
    }


    @POST
    @Path("/newEetakemon")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newEetakemon(Eetakemon eetakemon) {
        c.anadirATabla(eetakemon);
        return Response.status(201).entity("Eetakemon añadido: ").build();
    }

    @POST
    @Path("/newUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(Usuario usuario) {
        c.anadirATabla(usuario);
        return Response.status(201).entity("Usuario añadido: ").build();
    }


    @GET
    @Path("/getUsuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuarioId(@PathParam("id") int id) {
        Usuario u = (Usuario) c.buscarPorIdUsuario(id);
        System.out.println(u.toString());
        return u;
    }

    @DELETE
    @Path("/delEetakemon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delEetakemon(@PathParam("id") int id) {

        c.borrarEetakemonPorId(id);
        return Response.status(201).entity("Eetakemon eliminado").build();
    }

    @DELETE
    @Path("/delUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delUsern(@PathParam("id") int id) {

        c.borrarUsuarioPorId(id);
        return Response.status(201).entity("Usuario eliminado").build();
    }
}
