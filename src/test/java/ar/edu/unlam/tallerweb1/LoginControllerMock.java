package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginControllerMock extends SpringTest {
	 	
	Usuario usuarioMock = mock(Usuario.class);
	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpSession sessionMock = mock(HttpSession.class);
	ServicioLogin servicioLoginMock= mock(ServicioLoginImpl.class);
     
    ControladorLogin controladorLogin = new ControladorLogin();
         
     
    @Before
	public void ini(){
    	controladorLogin.setServicioLogin(servicioLoginMock);
	}

     
    @Test
    @Transactional
    @Rollback(true)
    public void rolAdminDeberiaIrHomeAdmin() {
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(usuarioMock.getRol()).thenReturn("admin");
        when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
        requestMock.setAttribute("ROL", usuarioMock.getRol());
        
        ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/homeAdmin");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void rolUsuarioDeberiaIrInicioHome() {
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(usuarioMock.getRol()).thenReturn("usuario");
        when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
        requestMock.setAttribute("ROL", usuarioMock.getRol());
       
        ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/inicioHome");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void desloguearseDeberiaIrInicioHome(){
        when(requestMock.getSession()).thenReturn(sessionMock);
        
        ModelAndView modelAndView = controladorLogin.desloguearse(requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/inicioHome");
    }
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void emailDisponibleDeberiaIrLogin() {
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(usuarioMock.getEmail()).thenReturn(null);
        requestMock.setAttribute("email", usuarioMock.getEmail());
        
        ModelAndView modelAndView = controladorLogin.cargarDatosUsuario(usuarioMock, requestMock);
        //ModelAndView modelAndView = controladorLogin.registroValidar(usuarioMock, requestMock);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:login");
    }
    
    
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void emailUsadoDeberiaIrRegistroUsuario() throws Exception {
//        when(requestMock.getSession()).thenReturn(sessionMock);
//        when(usuarioMock.getEmail()).thenReturn(null);
//        when(servicioLoginMock.validarUsuario(usuarioMock.getEmail()));
//        requestMock.setAttribute("email", usuarioMock.getEmail());
//        ModelAndView modelAndView = controladorLogin.cargarDatosUsuario(usuarioMock, requestMock);
//        //ModelAndView modelAndView = controladorLogin.registroValidar(usuarioMock, requestMock);
//        assertThat(modelAndView.getViewName()).isEqualTo("registroUsuario");
//    }
    
   
    
//  @Test
//  @Transactional
//  @Rollback(true)
//  public void loginController() {
//      Usuario usuarioMock = mock(Usuario.class);
//      HttpServletRequest requestMock = mock(HttpServletRequest.class);
//      HttpSession sessionMock = mock(HttpSession.class);
//      ServicioLogin servicioLoginMock= mock(ServicioLoginImpl.class);
//      ControladorLogin controladorLogin = new ControladorLogin();
//     // controladorLogin.setServicioLogin(servicioLoginMock);
//      when(requestMock.getSession()).thenReturn(sessionMock);
//      when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
//      when(usuarioMock.getRol()).thenReturn("ROL");
//      requestMock.setAttribute("ROL", usuarioMock.getRol());
//      ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
//      assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
//  }

}
 
